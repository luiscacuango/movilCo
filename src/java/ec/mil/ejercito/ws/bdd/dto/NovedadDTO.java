package ec.mil.ejercito.ws.bdd.dto;

import java.util.Date;

/**
 * @unidad SIPER
 * @author Cbop. Cacuango Luis
 */
public class NovedadDTO {
    
    private Integer novCodigo;
    private int clpCodigo;
    private Date novFecini;
    private Date novFecfin;
    private Date novFecpre;
    private PersonaDTO persona;

    public NovedadDTO() {
    }

    public Integer getNovCodigo() {
        return novCodigo;
    }

    public void setNovCodigo(Integer novCodigo) {
        this.novCodigo = novCodigo;
    }

    public int getClpCodigo() {
        return clpCodigo;
    }

    public void setClpCodigo(int clpCodigo) {
        this.clpCodigo = clpCodigo;
    }

    public Date getNovFecini() {
        return novFecini;
    }

    public void setNovFecini(Date novFecini) {
        this.novFecini = novFecini;
    }

    public Date getNovFecfin() {
        return novFecfin;
    }

    public void setNovFecfin(Date novFecfin) {
        this.novFecfin = novFecfin;
    }

    public Date getNovFecpre() {
        return novFecpre;
    }

    public void setNovFecpre(Date novFecpre) {
        this.novFecpre = novFecpre;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }
    
    
    
}
