/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.mil.ejercito.ws.bdd.service;

import ec.mil.ejercito.ws.bdd.XpusPerfilusario;
import ec.mil.ejercito.ws.bdd.XpusPerfilusarioPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Cbop. Cacuango Luis
 */
@Stateless
@Path("ec.mil.ejercito.ws.bdd.xpusperfilusario")
public class XpusPerfilusarioFacadeREST extends AbstractFacade<XpusPerfilusario> {
    @PersistenceContext(unitName = "webServiceMovilPU")
    private EntityManager em;

    private XpusPerfilusarioPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;memCedula=memCedulaValue;perCodigoperfil=perCodigoperfilValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ec.mil.ejercito.ws.bdd.XpusPerfilusarioPK key = new ec.mil.ejercito.ws.bdd.XpusPerfilusarioPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> memCedula = map.get("memCedula");
        if (memCedula != null && !memCedula.isEmpty()) {
            key.setMemCedula(memCedula.get(0));
        }
        java.util.List<String> perCodigoperfil = map.get("perCodigoperfil");
        if (perCodigoperfil != null && !perCodigoperfil.isEmpty()) {
            key.setPerCodigoperfil(new java.math.BigInteger(perCodigoperfil.get(0)));
        }
        return key;
    }

    public XpusPerfilusarioFacadeREST() {
        super(XpusPerfilusario.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(XpusPerfilusario entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, XpusPerfilusario entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        ec.mil.ejercito.ws.bdd.XpusPerfilusarioPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public XpusPerfilusario find(@PathParam("id") PathSegment id) {
        ec.mil.ejercito.ws.bdd.XpusPerfilusarioPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<XpusPerfilusario> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<XpusPerfilusario> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
