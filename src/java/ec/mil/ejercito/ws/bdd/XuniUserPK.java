package ec.mil.ejercito.ws.bdd;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @unidad SIPER
 * @author Cbop. Cacuango Luis
 */
@Embeddable
public class XuniUserPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "UNI_CODIGO2")
    private String uniCodigo2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "MEM_CEDULA")
    private String memCedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SIS_CODIGOSISSUB")
    private String sisCodigosissub;

    public XuniUserPK() {
    }

    public XuniUserPK(String uniCodigo2, String memCedula, String sisCodigosissub) {
        this.uniCodigo2 = uniCodigo2;
        this.memCedula = memCedula;
        this.sisCodigosissub = sisCodigosissub;
    }

    public String getUniCodigo2() {
        return uniCodigo2;
    }

    public void setUniCodigo2(String uniCodigo2) {
        this.uniCodigo2 = uniCodigo2;
    }

    public String getMemCedula() {
        return memCedula;
    }

    public void setMemCedula(String memCedula) {
        this.memCedula = memCedula;
    }

    public String getSisCodigosissub() {
        return sisCodigosissub;
    }

    public void setSisCodigosissub(String sisCodigosissub) {
        this.sisCodigosissub = sisCodigosissub;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uniCodigo2 != null ? uniCodigo2.hashCode() : 0);
        hash += (memCedula != null ? memCedula.hashCode() : 0);
        hash += (sisCodigosissub != null ? sisCodigosissub.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XuniUserPK)) {
            return false;
        }
        XuniUserPK other = (XuniUserPK) object;
        if ((this.uniCodigo2 == null && other.uniCodigo2 != null) || (this.uniCodigo2 != null && !this.uniCodigo2.equals(other.uniCodigo2))) {
            return false;
        }
        if ((this.memCedula == null && other.memCedula != null) || (this.memCedula != null && !this.memCedula.equals(other.memCedula))) {
            return false;
        }
        if ((this.sisCodigosissub == null && other.sisCodigosissub != null) || (this.sisCodigosissub != null && !this.sisCodigosissub.equals(other.sisCodigosissub))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.ejercito.ws.bdd.XuniUserPK[ uniCodigo2=" + uniCodigo2 + ", memCedula=" + memCedula + ", sisCodigosissub=" + sisCodigosissub + " ]";
    }

}
