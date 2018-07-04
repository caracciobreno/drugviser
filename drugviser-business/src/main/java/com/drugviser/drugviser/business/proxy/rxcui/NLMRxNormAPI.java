package com.drugviser.drugviser.business.proxy.rxcui;

import com.drugviser.drugviser.business.proxy.rxcui.entity.ApproximateTermResponse;
import com.drugviser.drugviser.business.proxy.rxcui.entity.RxCUIResponse;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * National Library of Medicine RxNorm API.
 *
 * @apiNote References https://rxnav.nlm.nih.gov/RxNormAPIs.html
 *
 * @author Breno Caraccio
 */
@Path("/REST")
public interface NLMRxNormAPI {

    /**
     * Finds a RxNorm Drug whose name exactly matches the given one.
     *
     * @apiNote References
     * https://rxnav.nlm.nih.gov/RxNormAPIs.html#uLink=RxNorm_REST_findRxcuiByString
     *
     * @param name Name to compare the RxNorm database drugs.
     *
     * @return Object containing the result data.
     */
    @GET
    @Path("rxcui.json")
    @Produces(MediaType.APPLICATION_JSON)
    public RxCUIResponse rxcui(
            @QueryParam("name") String name
    );

    /**
     * Finds a RxNorm Drug whose name approximates to the given one.
     *
     * @apiNote References
     * https://rxnav.nlm.nih.gov/RxNormAPIs.html#uLink=RxNorm_REST_getApproximateMatch
     *
     * @param term Term to compare the RxNorm database drugs.
     * @param maxEntries Max number of responses.
     *
     * @return Object containing the result data.
     */
    @GET
    @Path("approximateTerm.json")
    @Produces(MediaType.APPLICATION_JSON)
    public ApproximateTermResponse approximateTerm(
            @QueryParam("term") String term,
            @QueryParam("maxEntries") @DefaultValue("3") Integer maxEntries
    );
}
