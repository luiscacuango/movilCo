package ec.mil.ejercito.ws.bdd;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @unidad SIPER
 * @author Cbop. Cacuango Luis
 */
@Entity
@Table(name = "PCIU_CIUDAD", schema = "SIPER")

public class PciuCiudad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CIU_CODIGO")
    private BigDecimal ciuCodigo;
    @Column(name = "CIU_NOMBRE")
    private String ciuNombre;
    @Column(name = "CIU_DESCRIPCION")
    private String ciuDescripcion;
    @OneToMany(mappedBy = "ciuCodigo")
    private List<PlanLAnu> planLAnuList;
    @JoinColumn(name = "PAI_CODPAI", referencedColumnName = "PAI_CODPAI")
    @ManyToOne
    private PpaiPaises paiCodpai;

    public PciuCiudad() {
    }

    public PciuCiudad(BigDecimal ciuCodigo) {
        this.ciuCodigo = ciuCodigo;
    }

    public BigDecimal getCiuCodigo() {
        return ciuCodigo;
    }

    public void setCiuCodigo(BigDecimal ciuCodigo) {
        this.ciuCodigo = ciuCodigo;
    }

    public String getCiuNombre() {
        return ciuNombre;
    }

    public void setCiuNombre(String ciuNombre) {
        this.ciuNombre = ciuNombre;
    }

    public String getCiuDescripcion() {
        return ciuDescripcion;
    }

    public void setCiuDescripcion(String ciuDescripcion) {
        this.ciuDescripcion = ciuDescripcion;
    }

    public List<PlanLAnu> getPlanLAnuList() {
        return planLAnuList;
    }

    public void setPlanLAnuList(List<PlanLAnu> planLAnuList) {
        this.planLAnuList = planLAnuList;
    }

    public PpaiPaises getPaiCodpai() {
        return paiCodpai;
    }

    public void setPaiCodpai(PpaiPaises paiCodpai) {
        this.paiCodpai = paiCodpai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciuCodigo != null ? ciuCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PciuCiudad)) {
            return false;
        }
        PciuCiudad other = (PciuCiudad) object;
        if ((this.ciuCodigo == null && other.ciuCodigo != null) || (this.ciuCodigo != null && !this.ciuCodigo.equals(other.ciuCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.ejercito.ws.bdd.PciuCiudad[ciuCodigo=" + ciuCodigo + "]";
    }

}
