package com.drugviser.ejb.bean;

import com.drugviser.drugviser.common.entity.Drug;
import javax.ejb.Stateless;
import com.drugviser.drugviser.business.DrugServices;
import com.drugviser.drugviser.business.proxy.interaction.NLMInteractionAPI;
import com.drugviser.drugviser.business.proxy.interaction.entity.InteractionConcept;
import com.drugviser.drugviser.business.proxy.interaction.entity.InteractionResponse;
import com.drugviser.drugviser.business.proxy.interaction.entity.InteractionPair;
import com.drugviser.drugviser.business.proxy.interaction.entity.InteractionType;
import com.drugviser.drugviser.business.proxy.interaction.entity.InteractionTypeGroup;
import com.drugviser.drugviser.business.proxy.rxcui.NLMRxNormAPI;
import com.drugviser.drugviser.business.proxy.rxcui.entity.ApproximateTermResponse;
import com.drugviser.drugviser.business.proxy.rxcui.entity.Candidate;
import com.drugviser.drugviser.business.proxy.rxcui.entity.RxCUIResponse;
import com.drugviser.ejb.factory.APIProxyFactory;
import javax.ejb.LocalBean;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.ws.rs.core.Response;

/**
 * Stateless Session Bean for the "Drug" Resources.
 *
 * @author Breno Caraccio
 */
@Stateless
@LocalBean
public class DrugServicesBean implements DrugServices {

    /**
     * {@inheritDoc}.
     */
    @Override
    public Response findInteractions(String shortName) {

        long rxcui;
        boolean approximated;

        NLMRxNormAPI rxNormProxy = APIProxyFactory.createNLMRxNormAPI();

        RxCUIResponse rxcuiResponse = rxNormProxy.rxcui(shortName);

        // Approximate search
        if (rxcuiResponse.getIdGroup().getRxnormId() == null
                || rxcuiResponse.getIdGroup().getRxnormId().isEmpty()) {

            ApproximateTermResponse approximateTermResponse
                    = rxNormProxy.approximateTerm(shortName, null);

            if (approximateTermResponse == null
                    || approximateTermResponse.getApproximateGroup() == null
                    || approximateTermResponse.getApproximateGroup().getCandidate() == null
                    || approximateTermResponse.getApproximateGroup().getCandidate().isEmpty()) {

                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Couldn't find a drug for identifier '" + shortName + "'")
                        .build();
            }

            // Gets the rank 1 candidate
            Candidate candidate = approximateTermResponse.getApproximateGroup().getCandidate()
                    .stream()
                    .min(Comparator.comparing(Candidate::getRank))
                    .get();

            // Rejects if the score's bellow 30
            if (Integer.parseInt(candidate.getScore()) <= 30) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Couldn't find a drug for identifier '" + shortName + "'")
                        .build();
            }

            rxcui = Long.parseLong(candidate.getRxcui());
            approximated = true;

        } // Matches exactly
        else {
            rxcui = Long.parseLong(
                    rxcuiResponse.getIdGroup().getRxnormId().get(0));

            approximated = false;
        }

        NLMInteractionAPI interactionProxy = APIProxyFactory
                .createNLMInteractionAPI();

        InteractionResponse interactionResponse = interactionProxy.interaction(
                rxcui, null);

        // As we force 1 source, there's only 1 type group
        InteractionTypeGroup interactionTypeGroup = interactionResponse
                .getInteractionTypeGroup()
                .get(0);

        InteractionType interactionType = interactionTypeGroup
                .getInteractionType()
                .get(0);

        Drug drug = new Drug();
        drug.setRxcui(
                Long.parseLong(interactionResponse.getUserInput().getRxcui()));
        drug.setInputName(shortName);
        drug.setRxName(interactionType.getMinConceptItem().getName());
        drug.setInteractions(new ArrayList<>());
        drug.setApproximated(approximated);

        for (InteractionPair interactionPair : interactionType.getInteractionPair()) {

            List<InteractionConcept> concepts = interactionPair
                    .getInteractionConcept();

            // NOTE: index 0 is always referred to the queried drug
            InteractionConcept targetDrug = concepts.get(1);

            Drug.DrugInteraction interaction = drug.new DrugInteraction();

            interaction.setRxcui(Long.parseLong(
                    targetDrug.getMinConceptItem().getRxcui()));
            interaction.setName(targetDrug.getSourceConceptItem().getName());
            interaction.setDescription(interactionPair.getDescription());
            interaction.setSeverity(interactionPair.getSeverity());
            interaction.setUrl(targetDrug.getSourceConceptItem().getUrl());

            drug.getInteractions().add(interaction);
        }

        return Response.ok(drug).build();
    }
}
