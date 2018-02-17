package com.drugviser.drugviser.business;

import com.drugviser.drugviser.common.entity.Drug;

/**
 * Defines the provided Services for the "Drug" Resource.
 *
 * @author Breno Caraccio
 */
public interface DrugServices {

    /**
     * Retrieves all Drug interations by a given drug name.
     *
     * @param shortName Drug name.
     *
     * @return Object containing all the drug interactions info.
     */
    public Drug findInteractions(String shortName);
}
