package com.drugviser.ejb.bean;

import com.drugviser.drugviser.common.entity.Drug;
import javax.ejb.Stateless;
import com.drugviser.drugviser.business.DrugServices;
import javax.ejb.LocalBean;

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
        Drug drug = new Drug();
        drug.setDescription("teste description");
        drug.setRxcui(15000L);
        drug.setShortName(shortName);

        return drug;
    }
}
