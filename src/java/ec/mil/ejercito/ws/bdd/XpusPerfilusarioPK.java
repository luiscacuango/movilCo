package ec.mil.ejercito.ws.bdd;

import java.io.Serializable;
import java.math.BigInteger;
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
public class XpusPerfilusarioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "MEM_CEDULA")
    private String memCedula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_CODIGOPERFIL")
    private BigInteger perCodigoperfil;

    public XpusPerfilusarioPK() {
    }

    public XpusPerfilusarioPK(String memCedula, BigInteger perCodigoperfil) {
        this.memCedula = memCedula;
        this.perCodigoperfil = perCodigoperfil;
    }

    public String getMemCedula() {
        return memCedula;
    }

    public void setMemCedula(String memCedula) {
        this.memCedula = memCedula;
    }

    public BigInteger getPerCodigoperfil() {
        return perCodigoperfil;
    }

    public void setPerCodigoperfil(BigInteger perCodigoperfil) {
        this.perCodigoperfil = perCodigoperfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memCedula != null ? memCedula.hashCode() : 0);
        hash += (perCodigoperfil != null ? perCodigoperfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XpusPerfilusarioPK)) {
            return false;
        }
        XpusPerfilusarioPK other = (XpusPerfilusarioPK) object;
        if ((this.memCedula == null && other.memCedula != null) || (this.memCedula != null && !this.memCedula.equals(other.memCedula))) {
            return false;
        }
        if ((this.perCodigoperfil == null && other.perCodigoperfil != null) || (this.perCodigoperfil != null && !this.perCodigoperfil.equals(other.perCodigoperfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.ejercito.ws.bdd.XpusPerfilusarioPK[ memCedula=" + memCedula + ", perCodigoperfil=" + perCodigoperfil + " ]";
    }

}
