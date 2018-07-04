package com.drugviser.drugviser.business.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.drugviser.drugviser.business.DrugServices;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

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
    @Path("interactions/{shortName}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response findInteractions(@PathParam("shortName") String shortName);
}
