package com.drugviser.drugviser.business.proxy.interaction;

import com.drugviser.drugviser.business.proxy.interaction.entity.InteractionResponse;
import javax.ws.rs.DefaultValue;
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
     * @apiNote References
     * https://rxnav.nlm.nih.gov/InteractionAPIs.html#uLink=Interaction_REST_findDrugInteractions
     *
     * @param rxcui RxNorm concept ID for the given drug.
     * @param sources The Source to use, can be: "DrugBank" or "ONCHigh".
     *
     * @return Object containing the result data.
     */
    @GET
    @Path("interaction.json")
    @Produces(MediaType.APPLICATION_JSON)
    public InteractionResponse interaction(
            @QueryParam("rxcui") long rxcui,
            @QueryParam("sources") @DefaultValue("DrugBank") String sources
    );
}
