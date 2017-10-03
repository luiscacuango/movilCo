/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.mil.ejercito.ws.bdd.service;

import ec.mil.ejercito.ws.bdd.XuniUser;
import ec.mil.ejercito.ws.bdd.XuniUserPK;
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
@Path("ec.mil.ejercito.ws.bdd.xuniuser")
public class XuniUserFacadeREST extends AbstractFacade<XuniUser> {
    @PersistenceContext(unitName = "webServiceMovilPU")
    private EntityManager em;

    private XuniUserPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;uniCodigo2=uniCodigo2Value;memCedula=memCedulaValue;sisCodigosissub=sisCodigosissubValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ec.mil.ejercito.ws.bdd.XuniUserPK key = new ec.mil.ejercito.ws.bdd.XuniUserPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> uniCodigo2 = map.get("uniCodigo2");
        if (uniCodigo2 != null && !uniCodigo2.isEmpty()) {
            key.setUniCodigo2(uniCodigo2.get(0));
        }
        java.util.List<String> memCedula = map.get("memCedula");
        if (memCedula != null && !memCedula.isEmpty()) {
            key.setMemCedula(memCedula.get(0));
        }
        java.util.List<String> sisCodigosissub = map.get("sisCodigosissub");
        if (sisCodigosissub != null && !sisCodigosissub.isEmpty()) {
            key.setSisCodigosissub(sisCodigosissub.get(0));
        }
        return key;
    }

    public XuniUserFacadeREST() {
        super(XuniUser.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(XuniUser entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, XuniUser entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        ec.mil.ejercito.ws.bdd.XuniUserPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public XuniUser find(@PathParam("id") PathSegment id) {
        ec.mil.ejercito.ws.bdd.XuniUserPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<XuniUser> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<XuniUser> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
