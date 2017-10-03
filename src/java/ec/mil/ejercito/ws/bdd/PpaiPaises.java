package ec.mil.ejercito.ws.bdd;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @unidad SIPER
 * @author Cbop. Cacuango Luis
 */
@Entity
@Table(name = "PPAI_PAISES", schema = "SIPER")

public class PpaiPaises implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PAI_CODPAI")
    private Integer paiCodpai;
    @Basic(optional = false)
    @Column(name = "PAI_DESPAI")
    private String paiDespai;
    @OneToMany(mappedBy = "paiCodpai")
    private List<PlanLAnu> planLAnuList;
    @OneToMany(mappedBy = "paiCodpai")
    private List<PciuCiudad> pciuCiudadList;

    public PpaiPaises() {
    }

    public PpaiPaises(Integer paiCodpai) {
        this.paiCodpai = paiCodpai;
    }

    public PpaiPaises(Integer paiCodpai, String paiDespai) {
        this.paiCodpai = paiCodpai;
        this.paiDespai = paiDespai;
    }

    public Integer getPaiCodpai() {
        return paiCodpai;
    }

    public void setPaiCodpai(Integer paiCodpai) {
        this.paiCodpai = paiCodpai;
    }

    public String getPaiDespai() {
        return paiDespai;
    }

    public void setPaiDespai(String paiDespai) {
        this.paiDespai = paiDespai;
    }

    public List<PlanLAnu> getPlanLAnuList() {
        return planLAnuList;
    }

    public void setPlanLAnuList(List<PlanLAnu> planLAnuList) {
        this.planLAnuList = planLAnuList;
    }

    public List<PciuCiudad> getPciuCiudadList() {
        return pciuCiudadList;
    }

    public void setPciuCiudadList(List<PciuCiudad> pciuCiudadList) {
        this.pciuCiudadList = pciuCiudadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paiCodpai != null ? paiCodpai.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PpaiPaises)) {
            return false;
        }
        PpaiPaises other = (PpaiPaises) object;
        if ((this.paiCodpai == null && other.paiCodpai != null) || (this.paiCodpai != null && !this.paiCodpai.equals(other.paiCodpai))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.ejercito.ws.bdd.PpaiPaises[paiCodpai=" + paiCodpai + "]";
    }

}
