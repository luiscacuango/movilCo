package ec.mil.ejercito.ws.bdd.service.parte;

import ec.mil.ejercito.negocio.util.FuncionesUtil;
import ec.mil.ejercito.ws.bdd.PmemMilit;
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
public class SeguridadWs {
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
            TypedQuery<XusrUsuariosistema> conUsu = em.createQuery(" Select usu FROM XusrUsuariosistema usu where usu.memCedula =:usuario and usu.usrPassword =:clave ", XusrUsuariosistema.class);
            conUsu.setParameter("usuario", usuario);
            conUsu.setParameter("clave", claveDes);
            XusrUsuariosistema usuarioPer = conUsu.getSingleResult();
            //Composicion del objeto
            usuarioDto = new UsuarioDTO();
            usuarioDto.setMemCedula(usuarioPer.getMemCedula());
            usuarioDto.setUsrPassword(usuarioPer.getUsrPassword());
            usuarioDto.setListaPerfil(null);
            /**
             * *********************************************************************************
             * Cargar Personal Disponible por Unidad (Orgánico y No Orgánico)
             * *******************************************************************************
             */
            List<PersonaDTO> listPersonal = new ArrayList<>();
            for (PmemMilit perTmp : buscarPersonalPorUnidad("155000000000000")) {
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
             * Cargar Personal Disponible
             * *******************************************************************************
             */
//            List<PersonaDTO> listPersonalNov = new ArrayList<>();
//            for (PnovNoved licPerTmp : cargaNovedades(usuarioPer.getPerSecuen().getFunSecuen().getUniSecuen().getGdoSecuen().getGdoSecuen(), new Date())) {
//                PersonaDTO personaDTO = new PersonaDTO();
//                personaDTO.setPerSecuen(licPerTmp.getPerSecuen().getPerSecuen());
//                personaDTO.setPerCedula(licPerTmp.getPerSecuen().getPerCedula());
//                personaDTO.setPerApellido(licPerTmp.getPerSecuen().getPerApellido());
//                personaDTO.setPerNombre(licPerTmp.getPerSecuen().getPerNombre());
//                personaDTO.setPerNovedad(licPerTmp.getTlpSecuen().getTlpDescri());
//                personaDTO.setPerFechaInicio(licPerTmp.getLypInicio());
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
