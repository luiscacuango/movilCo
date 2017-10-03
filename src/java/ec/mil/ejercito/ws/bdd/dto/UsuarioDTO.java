package ec.mil.ejercito.ws.bdd.dto;

import java.util.List;

/**
 * @unidad SIPER
 * @author Cbop. Cacuango Luis
 */
public class UsuarioDTO {
    private String usrPassword;
    private String memCedula;
    private String memApelli;
    private String memNombre;
    private String gmiSiglas;
    private String ptefTEfe;
    private String uniSiglas2;
    private String uniCodigo2;
    private List<PersonaDTO> listaPerfil;
    private List<PersonaDTO> listaPersonal;
    private List<PersonaDTO> listaPersonalNov;

    public UsuarioDTO() {
    }

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

    public String getMemCedula() {
        return memCedula;
    }

    public void setMemCedula(String memCedula) {
        this.memCedula = memCedula;
    }

    public String getMemApelli() {
        return memApelli;
    }

    public void setMemApelli(String memApelli) {
        this.memApelli = memApelli;
    }

    public String getMemNombre() {
        return memNombre;
    }

    public void setMemNombre(String memNombre) {
        this.memNombre = memNombre;
    }

    public String getGmiSiglas() {
        return gmiSiglas;
    }

    public void setGmiSiglas(String gmiSiglas) {
        this.gmiSiglas = gmiSiglas;
    }

    public String getPtefTEfe() {
        return ptefTEfe;
    }

    public void setPtefTEfe(String ptefTEfe) {
        this.ptefTEfe = ptefTEfe;
    }

    public String getUniSiglas2() {
        return uniSiglas2;
    }

    public void setUniSiglas2(String uniSiglas2) {
        this.uniSiglas2 = uniSiglas2;
    }

    public List<PersonaDTO> getListaPerfil() {
        return listaPerfil;
    }

    public void setListaPerfil(List<PersonaDTO> listaPerfil) {
        this.listaPerfil = listaPerfil;
    }

    public List<PersonaDTO> getListaPersonal() {
        return listaPersonal;
    }

    public void setListaPersonal(List<PersonaDTO> listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    public List<PersonaDTO> getListaPersonalNov() {
        return listaPersonalNov;
    }

    public void setListaPersonalNov(List<PersonaDTO> listaPersonalNov) {
        this.listaPersonalNov = listaPersonalNov;
    }

    public String getUniCodigo2() {
        return uniCodigo2;
    }

    public void setUniCodigo2(String uniCodigo2) {
        this.uniCodigo2 = uniCodigo2;
    }
    
    
}
