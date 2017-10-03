package ec.mil.ejercito.ws.bdd;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @unidad SIPER
 * @author Cbop. Cacuango Luis
 */
@Embeddable
public class PclpCauslicperPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "LAN_TIPOSOL")
    private Character lanTiposol;
    @Basic(optional = false)
    @Column(name = "CLP_CODIGO")
    private int clpCodigo;

    public String getEstadoLicencia() {
        String variable = "";

        if (this.lanTiposol == 'L') {
            variable = "LICENCIA";
        } else if (this.lanTiposol == 'P') {
            variable = "PERMISO";
        } else if (this.lanTiposol == 'N') {
            variable = "NOVEDAD";
        } else if (this.lanTiposol == 'M') {
            variable = "MOVIMIENTO";
        } else if (this.lanTiposol == 'S') {
            variable = "PASE";
        } else if (this.lanTiposol == 'R') {
            variable = "MOVIMIENTO RETORNO";
        } else if (this.lanTiposol == 'X') {
            variable = "MOVIMIENTO";
        }
        return variable;
    }

    public PclpCauslicperPK() {
    }

    public PclpCauslicperPK(Character lanTiposol, int clpCodigo) {
        this.lanTiposol = lanTiposol;
        this.clpCodigo = clpCodigo;
    }

    public Character getLanTiposol() {
        return lanTiposol;
    }

    public void setLanTiposol(Character lanTiposol) {
        this.lanTiposol = lanTiposol;
    }

    public int getClpCodigo() {
        return clpCodigo;
    }

    public void setClpCodigo(int clpCodigo) {
        this.clpCodigo = clpCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) lanTiposol;
        hash += (int) clpCodigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PclpCauslicperPK)) {
            return false;
        }
        PclpCauslicperPK other = (PclpCauslicperPK) object;
        if (this.lanTiposol != other.lanTiposol) {
            return false;
        }
        if (this.clpCodigo != other.clpCodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.ejercito.ws.bdd.PclpCauslicperPK[lanTiposol=" + lanTiposol + ", clpCodigo=" + clpCodigo + "]";
    }
}
