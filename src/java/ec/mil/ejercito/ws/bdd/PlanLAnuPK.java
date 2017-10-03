package ec.mil.ejercito.ws.bdd;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @unidad SIPER
 * @author Cbop. Cacuango Luis
 */
@Embeddable
public class PlanLAnuPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "MEM_CEDULA")
    private String memCedula;
    @Basic(optional = false)
    @Column(name = "LAN_FECINI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lanFecini;

    public PlanLAnuPK() {
    }

    public PlanLAnuPK(String memCedula, Date lanFecini) {
        this.memCedula = memCedula;
        this.lanFecini = lanFecini;
    }

    public String getMemCedula() {
        return memCedula;
    }

    public void setMemCedula(String memCedula) {
        this.memCedula = memCedula;
    }

    public Date getLanFecini() {
        return lanFecini;
    }

    public void setLanFecini(Date lanFecini) {
        this.lanFecini = lanFecini;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memCedula != null ? memCedula.hashCode() : 0);
        hash += (lanFecini != null ? lanFecini.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanLAnuPK)) {
            return false;
        }
        PlanLAnuPK other = (PlanLAnuPK) object;
        if ((this.memCedula == null && other.memCedula != null) || (this.memCedula != null && !this.memCedula.equals(other.memCedula))) {
            return false;
        }
        if ((this.lanFecini == null && other.lanFecini != null) || (this.lanFecini != null && !this.lanFecini.equals(other.lanFecini))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.ejercito.ws.bdd.PlanLAnuPK[memCedula=" + memCedula + ", lanFecini=" + lanFecini + "]";
    }

}
