package com.drugviser.drugviser.business.proxy;

import com.drugviser.drugviser.business.proxy.entity.interaction.InteractionJSON;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * National Library of Medicine Interaction API.
 *
 * @apiNote References https://rxnav.nlm.nih.gov/InteractionAPIREST.html
 *
 * @author Breno Caraccio
 */
@Path("/REST/interaction")
public interface NLMInteractionAPI {

    /**
     * Gets the Drug interactions for the given drug.
     *
     * @param rxcui RxNorm concept ID for the given drug.
     *
     * @return Object containing the result data.
     */
    @GET
    @Path("interaction.json")
    @Produces(MediaType.APPLICATION_JSON)
    public InteractionJSON interaction(@QueryParam("rxcui") long rxcui);
}
