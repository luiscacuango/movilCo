/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.mil.ejercito.ws;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author Cbop. Cacuango Luis
 */
@Path("parteMovil")
public class ParteMovilResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ParteMovilResource
     */
    public ParteMovilResource() {
    }

    /**
     * Retrieves representation of an instance of ec.mil.ejercito.ws.ParteMovilResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        return  "Servicio Web ParteMovil";
    }

    /**
     * PUT method for updating or creating an instance of ParteMovilResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
        System.out.println("Valor Ingresado: " + content);
    }
}
