package com.drugviser.ejb.bean;

import com.drugviser.drugviser.common.entity.Drug;
import javax.ejb.Stateless;
import com.drugviser.drugviser.business.DrugServices;
import com.drugviser.drugviser.business.proxy.entity.interaction.InteractionJSON;
import com.drugviser.ejb.factory.APIProxyFactory;
import java.util.stream.Collectors;
import javax.ejb.LocalBean;
import com.drugviser.drugviser.business.proxy.NLMInteractionAPI;

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

        InteractionJSON interaction = proxy.interaction(88014);

        String description = interaction.getInteractionTypeGroup().get(0)
                .getInteractionType().stream()
                .flatMap(e -> e.getInteractionPair().stream())
                .map(e -> "Severity: " + e.getSeverity() + " - Description: " + e.getDescription())
                .collect(Collectors.joining("\n"));

        Drug drug = new Drug();
        drug.setDescription(description);
        drug.setRxcui(15000L);
        drug.setShortName(shortName);

        return drug;
    }
}
