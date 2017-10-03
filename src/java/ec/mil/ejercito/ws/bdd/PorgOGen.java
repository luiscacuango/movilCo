package ec.mil.ejercito.ws.bdd;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @unidad SIPER
 * @author Cbop. Cacuango Luis
 */
@Entity
@Table(name = "PORG_O_GEN", schema = "SIPER")
public class PorgOGen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ORG_NUMERO")
    private String orgNumero;
    @Column(name = "ORG_FECHA")
    @Temporal(TemporalType.DATE)
    private Date orgFecha;
    @Column(name = "ORG_RESUME")
    private String orgResume;
    @OneToMany(mappedBy = "orgNumero")
    private List<PlanLAnu> planLAnuList;

    public PorgOGen() {
    }

    public PorgOGen(String orgNumero) {
        this.orgNumero = orgNumero;
    }

    public String getOrgNumero() {
        return orgNumero;
    }

    public void setOrgNumero(String orgNumero) {
        this.orgNumero = orgNumero;
    }

    public Date getOrgFecha() {
        return orgFecha;
    }

    public void setOrgFecha(Date orgFecha) {
        this.orgFecha = orgFecha;
    }

    public String getOrgResume() {
        return orgResume;
    }

    public void setOrgResume(String orgResume) {
        this.orgResume = orgResume;
    }

    public List<PlanLAnu> getPlanLAnuList() {
        return planLAnuList;
    }

    public void setPlanLAnuList(List<PlanLAnu> planLAnuList) {
        this.planLAnuList = planLAnuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orgNumero != null ? orgNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PorgOGen)) {
            return false;
        }
        PorgOGen other = (PorgOGen) object;
        if ((this.orgNumero == null && other.orgNumero != null) || (this.orgNumero != null && !this.orgNumero.equals(other.orgNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.ejercito.ws.bdd.PorgOGen[orgNumero=" + orgNumero + "]";
    }
}
