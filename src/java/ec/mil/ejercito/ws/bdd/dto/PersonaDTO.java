package ec.mil.ejercito.ws.bdd.dto;

import java.util.Date;
import java.util.List;

/**
 * @unidad SIPER
 * @author Cbop. Cacuango Luis
 */
public class PersonaDTO {

    private String memCedula;
    private String memApelli;
    private String memNombre;
    private String gmiCodigo;
    private String ptefTEfe;
    private String uniSiglas2;
    private String novedad;
    private Date novFecini;
    private Date novFecfin;
    private Date novFecpre;
    private List<NovedadDTO> listaNovedad;
    
    public PersonaDTO() {
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

    public String getGmiCodigo() {
        return gmiCodigo;
    }

    public void setGmiCodigo(String gmiCodigo) {
        this.gmiCodigo = gmiCodigo;
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

    public List<NovedadDTO> getListaNovedad() {
        return listaNovedad;
    }

    public void setListaNovedad(List<NovedadDTO> listaNovedad) {
        this.listaNovedad = listaNovedad;
    }

    public String getNovedad() {
        return novedad;
    }

    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }

}
