package com.drugviser.drugviser.business.resources;

import com.drugviser.drugviser.common.entity.Drug;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.drugviser.drugviser.business.DrugServices;

/**
 * REST Service "Drug".
 *
 * @author caracciobreno
 */
// NOTE: access using localhost:8080/services/drugs
@Path("/drugs")
public interface DrugServicesWebResource extends DrugServices {

    /**
     * {@inheritDoc}.
     */
    @GET
    @Path("interactions")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Drug findInteractions(@QueryParam("shortName") String shortName);
}
