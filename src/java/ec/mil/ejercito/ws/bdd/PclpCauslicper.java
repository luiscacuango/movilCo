package ec.mil.ejercito.ws.bdd;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @unidad SIPER
 * @author Cbop. Cacuango Luis
 */
@Entity
@Table(name = "PCLP_CAUSLICPER", schema = "SIPER")
public class PclpCauslicper implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PclpCauslicperPK pclpCauslicperPK;
    @Column(name = "CLP_DESCRIP")
    private String clpDescrip;
    @Column(name = "CLP_MAXIMO")
    private Short clpMaximo;
    @Column(name = "CLP_AUTORIZA")
    private String clpAutoriza;
    @Column(name = "CLP_SUELDO")
    private Character clpSueldo;
    @Column(name = "CLP_IMPUTABLE")
    private Character clpImputable;
    @Column(name = "CLP_CLASEF")
    private Character clpClasef;
    @Column(name = "CLP_ORDENGENERAL")
    private Character clpOrdengeneral;
    @Column(name = "CLP_SIGNO")
    private Character clpSigno;
    @Column(name = "CLP_ESTADO")
    private char clpEstado;
    @Column(name = "CLP_PARTMENS")
    private String clpPastMens;


    @Column(name = "CLP_ORD")
    private String clpOrd;
    
    @OneToMany(mappedBy = "pclpCauslicper")
    private List<PlanLAnu> planLAnuList;
    @OneToMany(mappedBy = "pclpCauslicper")
    private List<PnovNoved> pnovNovedList;

    public String getClpPastMens() {
        return clpPastMens;
    }

    public void setClpPastMens(String clpPastMens) {
        this.clpPastMens = clpPastMens;
    }
    
    public String getEstadoImputable() {
        String variable = "";

        if (this.clpImputable != null) {
            if (this.clpImputable == 'S') {
                variable = "IMPUTABLE";
            } else {
                if (this.clpImputable == 'N') {
                    variable = "NO IMPUTABLE";
                }
            }
        } else {
            variable = "";
        }
        return variable;
    }

    public String getSigno() {
        String variable = "";

        if (this.clpSigno != null) {
            if (this.clpSigno == 'S') {
                variable = "SUMA";
            } else {
                if (this.clpSigno == 'R') {
                    variable = "RESTA";
                }
            }
        } else {
            variable = "";
        }
        return variable;
    }

    public PclpCauslicper() {
    }

    public char getClpEstado() {
        return clpEstado;
    }

    public void setClpEstado(char clpEstado) {
        this.clpEstado = clpEstado;
    }

    public PclpCauslicper(PclpCauslicperPK pclpCauslicperPK) {
        this.pclpCauslicperPK = pclpCauslicperPK;
    }

    public PclpCauslicper(char lanTiposol, int clpCodigo) {
        this.pclpCauslicperPK = new PclpCauslicperPK(lanTiposol, clpCodigo);
    }

    public PclpCauslicperPK getPclpCauslicperPK() {
        return pclpCauslicperPK;
    }

    public void setPclpCauslicperPK(PclpCauslicperPK pclpCauslicperPK) {
        this.pclpCauslicperPK = pclpCauslicperPK;
    }

    public String getClpDescrip() {
        return clpDescrip;
    }

    public void setClpDescrip(String clpDescrip) {
        this.clpDescrip = clpDescrip;
    }

    public Short getClpMaximo() {
        return clpMaximo;
    }

    public void setClpMaximo(Short clpMaximo) {
        this.clpMaximo = clpMaximo;
    }

    public String getClpAutoriza() {
        return clpAutoriza;
    }

    public void setClpAutoriza(String clpAutoriza) {
        this.clpAutoriza = clpAutoriza;
    }

    public Character getClpSueldo() {
        return clpSueldo;
    }

    public void setClpSueldo(Character clpSueldo) {
        this.clpSueldo = clpSueldo;
    }

    public Character getClpImputable() {
        return clpImputable;
    }

    public void setClpImputable(Character clpImputable) {
        this.clpImputable = clpImputable;
    }

    public Character getClpClasef() {
        return clpClasef;
    }

    public void setClpClasef(Character clpClasef) {
        this.clpClasef = clpClasef;
    }

    public Character getClpOrdengeneral() {
        return clpOrdengeneral;
    }

    public void setClpOrdengeneral(Character clpOrdengeneral) {
        this.clpOrdengeneral = clpOrdengeneral;
    }

    public Character getClpSigno() {
        return clpSigno;
    }

    public void setClpSigno(Character clpSigno) {
        this.clpSigno = clpSigno;
    }

    public List<PlanLAnu> getPlanLAnuList() {
        return planLAnuList;
    }

    public void setPlanLAnuList(List<PlanLAnu> planLAnuList) {
        this.planLAnuList = planLAnuList;
    }

    public List<PnovNoved> getPnovNovedList() {
        return pnovNovedList;
    }

    public void setPnovNovedList(List<PnovNoved> pnovNovedList) {
        this.pnovNovedList = pnovNovedList;
    }

    public String getClpOrd() {
        return clpOrd;
    }

    public void setClpOrd(String clpOrd) {
        this.clpOrd = clpOrd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pclpCauslicperPK != null ? pclpCauslicperPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PclpCauslicper)) {
            return false;
        }
        PclpCauslicper other = (PclpCauslicper) object;
        if ((this.pclpCauslicperPK == null && other.pclpCauslicperPK != null) || (this.pclpCauslicperPK != null && !this.pclpCauslicperPK.equals(other.pclpCauslicperPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.ejercito.ws.bdd.PclpCauslicper[pclpCauslicperPK=" + pclpCauslicperPK + "]";
    }
}
