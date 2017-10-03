package ec.mil.ejercito.ws.bdd.service.parte;

import ec.mil.ejercito.negocio.util.FuncionesUtil;
import ec.mil.ejercito.ws.bdd.PmemMilit;
import ec.mil.ejercito.ws.bdd.PnovNoved;
import ec.mil.ejercito.ws.bdd.XusrUsuariosistema;
import ec.mil.ejercito.ws.bdd.dto.PersonaDTO;
import ec.mil.ejercito.ws.bdd.dto.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Cbop. Cacuango Luis
 */
@Path("seguridad2")
public class SeguridadWs2 {
    @PersistenceContext(unitName = "webServiceMovilPU")
    private EntityManager em;
    private FuncionesUtil funcionesUtil;
           
    @GET
    @Path("validarUsuario/{usuario}/{clave}")
    @Produces(MediaType.APPLICATION_JSON)
    public UsuarioDTO validarUsuario(@PathParam(value = "usuario") String usuario,
            @PathParam(value = "clave") String clave) throws Exception {
        UsuarioDTO usuarioDto;
        try {
            funcionesUtil = new FuncionesUtil();
            String claveDes = funcionesUtil.encriptar(clave);
            TypedQuery<XusrUsuariosistema> conUsu = em.createQuery(" Select usu FROM XusrUsuariosistema usu where usu.memCedula.memCedula =:usuario and usu.usrPassword =:clave ", XusrUsuariosistema.class);
            conUsu.setParameter("usuario", usuario);
            conUsu.setParameter("clave", claveDes);
            XusrUsuariosistema usuarioPer = conUsu.getSingleResult();
            //Composicion del objeto
            usuarioDto = new UsuarioDTO();
            usuarioDto.setMemCedula(usuarioPer.getMemCedula().getMemCedula());
            usuarioDto.setUsrPassword(usuarioPer.getUsrPassword());
            usuarioDto.setListaPerfil(null);
            usuarioDto.setUniCodigo2(usuarioPer.getMemCedula().getUniCodigo2().getUniCodigo2());
            /**
             * *********************************************************************************
             * Cargar Personal Disponible por Unidad (Orgánico y No Orgánico)
             * *******************************************************************************
             */
            List<PersonaDTO> listPersonal = new ArrayList<>();
            String uni = findUnidad(usuario);
            for (PmemMilit perTmp : buscarPersonalPorUnidad(uni)) {
                PersonaDTO personaDTO = new PersonaDTO();
                personaDTO.setMemCedula(perTmp.getMemCedula());
                personaDTO.setMemApelli(perTmp.getMemApelli());
                personaDTO.setMemNombre(perTmp.getMemNombre());
                personaDTO.setGmiCodigo(perTmp.getGmiCodigo().getGmiSiglas());
                listPersonal.add(personaDTO);
            }
            usuarioDto.setListaPersonal(listPersonal);
            /**
             * *********************************************************************************
             * Cargar Personal con Novedad
             * *******************************************************************************
             */
//            List<PersonaDTO> listPersonalNov = new ArrayList<>();
//            for (PnovNoved licPerTmp : buscaPerNovPorUni(uni)) {
//                PersonaDTO personaDTO = new PersonaDTO();
//                personaDTO.setMemCedula(licPerTmp.getMemCedula().getMemCedula());
//                personaDTO.setMemApelli(licPerTmp.getMemCedula().getMemApelli());
//                personaDTO.setMemNombre(licPerTmp.getMemCedula().getMemNombre());
//                personaDTO.setNovedad(licPerTmp.getPclpCauslicper().getClpDescrip());
//                personaDTO.set(licPerTmp.getLypInicio());
//                personaDTO.setPerFechaFin(licPerTmp.getLypFin());
//                listPersonalNov.add(personaDTO);
//            }
//            usuarioDto.setListaPersonalNov(listPersonalNov);
        } catch (Exception e) {
            throw new Exception("Usuario no encontrado");
        }
        return usuarioDto;
    }
    
    /**
     * Método para listar personal DISPONIBLE de una unidad
     * @param uniCodigo2
     * @return
     */
    public List<PmemMilit> buscarPersonalPorUnidad(String uniCodigo2) {
        Query conPerUni = em.createNativeQuery(" SELECT * "
                + " FROM PMEM_MILIT "
                + " WHERE PMEM_MILIT.UNI_CODIGO2 = ?1 "
                + " AND TEF_CODIGO IN (1, 2, 3, 4, 5, 6, 7, 8, 15, 16)  "
                + " AND PACK_DATOS_MILITAR.F_RETORNA_ESTADO(PMEM_MILIT.MEM_CEDULA) IN (1,4,5,6,7)  ", PmemMilit.class);
        conPerUni.setParameter(1, uniCodigo2);
        return conPerUni.getResultList();
    }
    /**
     * Método para listar personal con NOVEDADES por unidad
     * @param uniCodigo2
     * @return
     */
    public List<PnovNoved> buscaPerNovPorUni(String uniCodigo2) {
        Query conPerNovUni = em.createNativeQuery(" SELECT * "
                + " FROM PNOV_NOVED NOV "
                + " WHERE NOV.UNI_CODIGO2 = ?1 "
                + " AND PACK_DATOS_MILITAR.F_RETORNA_ESTADO(PMEM_MILIT.MEM_CEDULA) IN (1,4,5,6,7)  ", PnovNoved.class);
        conPerNovUni.setParameter(1, uniCodigo2);
        return conPerNovUni.getResultList();
    }
    /**
     * Método para sacar unidad x cedula
     * @param cedula
     * @return
     */

     public String findUnidad(String cedula) {
        String r = (String) em.createNativeQuery("select mil.uni_codigo2 from pmem_milit mil where MIL.MEM_CEDULA = '"+cedula+"' ").getSingleResult();
        return r;
    }
          
    @GET
    @Path("validarUsuarioDos")
    @Produces(MediaType.APPLICATION_JSON)
    public XusrUsuariosistema validarUsuarioDos(@QueryParam(value = "usuario") String usuario,
            @QueryParam(value = "clave") String clave) {
        XusrUsuariosistema usuarioDev;
        try {
            TypedQuery<XusrUsuariosistema> conUsu = em.createQuery(" Select usu FROM XusrUsuariosistema usu where usu.memCedula =:usuario and usu.usrPassword =:clave ", XusrUsuariosistema.class);
            conUsu.setParameter("usuario", usuario);
            conUsu.setParameter("clave", clave);
            usuarioDev = conUsu.getSingleResult();
        } catch (Exception e) {
            usuarioDev = null;
        }
        return usuarioDev;
    }

    @GET
    @Path("consultarTodos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<XusrUsuariosistema> consultarTodos() {
        TypedQuery<XusrUsuariosistema> conTodUsu = em.createQuery(" Select usu from XusrUsuariosistema usu ", XusrUsuariosistema.class);
        return conTodUsu.getResultList();
    }

    @GET
    @Path("consultarLuigi")
    @Produces(MediaType.APPLICATION_JSON)
    public List<XusrUsuariosistema> consultarLuigi() {
        TypedQuery<XusrUsuariosistema> conTodUsu = em.createQuery(" Select usu from XusrUsuariosistema usu where usu.memCedula =:usuario ", XusrUsuariosistema.class);
        conTodUsu.setParameter("usuario", "1002871091");
        return conTodUsu.getResultList();
    }
    
}
