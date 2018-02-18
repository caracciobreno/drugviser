package com.drugviser.drugviser.war.services;

import com.drugviser.drugviser.common.entity.Drug;
import javax.inject.Inject;
import com.drugviser.drugviser.business.resources.DrugServicesWebResource;
import com.drugviser.ejb.bean.DrugServicesBean;

/**
 * Publisher for the Resource "Drug".
 *
 * @author Breno Caraccio
 */
public class DrugServicesPublisher implements DrugServicesWebResource {

    /**
     * Delegate object to process requests.
     */
    @Inject
    private DrugServicesBean delegate;

    /**
     * {@inheritDoc}.
     */
    @Override
    public Drug findInteractions(String shortName) {
        return delegate.findInteractions(shortName);
    }
}
