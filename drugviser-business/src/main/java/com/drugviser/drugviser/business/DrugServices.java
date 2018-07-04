package com.drugviser.drugviser.business;

import javax.ws.rs.core.Response;

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
    public Response findInteractions(String shortName);
}
