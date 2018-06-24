package com.drugviser.ejb.bean;

import com.drugviser.drugviser.common.entity.Drug;
import javax.ejb.Stateless;
import com.drugviser.drugviser.business.DrugServices;
import com.drugviser.drugviser.business.proxy.interaction.entity.InteractionJSON;
import com.drugviser.ejb.factory.APIProxyFactory;
import javax.ejb.LocalBean;
import com.drugviser.drugviser.business.proxy.interaction.NLMInteractionAPI;
import com.drugviser.drugviser.business.proxy.interaction.entity.InteractionConcept;
import com.drugviser.drugviser.business.proxy.interaction.entity.InteractionPair;
import com.drugviser.drugviser.business.proxy.interaction.entity.InteractionType;
import com.drugviser.drugviser.business.proxy.interaction.entity.InteractionTypeGroup;
import java.util.ArrayList;
import java.util.List;

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
    public Drug findInteractions(String shortName) {

        NLMInteractionAPI proxy = APIProxyFactory.createNLMInteractionAPI();

        // TODO: search NLM API to find the RXCUI of "shortName" and use it
        // TODO: treat response code
        InteractionJSON interactionResponse = proxy.interaction(88014, null);

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
        drug.setShortName(shortName);
        drug.setInteractions(new ArrayList<>());

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

        return drug;
    }
}
