package ec.mil.ejercito.ws.bdd;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @unidad SIPER
 * @author Cbop. Cacuango Luis
 */
@Entity
@Table(name = "PNOV_NOVED", schema = "SIPER")
public class PnovNoved implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NOV_CODIGO")
    private Integer novCodigo;
    @Column(name = "NOV_FECINI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date novFecini;
    @Column(name = "NOV_OBSERV")
    private String novObserv;
    @Column(name = "NOV_FECFIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date novFecfin;
    @Column(name = "NOV_FECPRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date novFecpre;
    @Column(name = "NOV_DOCUMENTO")
    private String novDocumento;
    //Para registrar quien ingreso la novedad
    @Column(name = "MEM_CEDULA_REG")
    private String cedulaReg;
    @Column(name = "NOV_FECHA_REG")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReg;
    // Fin Ingreso Novedad
    @JoinColumn(name = "UNI_CODIGO2", referencedColumnName = "UNI_CODIGO2")
    @ManyToOne
    private MuniUnida uniCodigo2;
    @JoinColumn(name = "NOV_UNIDAD", referencedColumnName = "UNI_CODIGO2")
    @ManyToOne
    private MuniUnida novUnidad;
    @JoinColumns({
        @JoinColumn(name = "LAN_TIPOSOL", referencedColumnName = "LAN_TIPOSOL"),
        @JoinColumn(name = "CLP_CODIGO", referencedColumnName = "CLP_CODIGO")})
    @ManyToOne
    private PclpCauslicper pclpCauslicper;
    @JoinColumn(name = "MEM_CEDULA", referencedColumnName = "MEM_CEDULA")
    @ManyToOne
    private PmemMilit memCedula;
    @OneToMany(mappedBy = "novPadre")
    private List<PnovNoved> pnovNovedList;
    @JoinColumn(name = "NOV_PADRE", referencedColumnName = "NOV_CODIGO")
    @ManyToOne
    private PnovNoved novPadre;

    public PnovNoved() {
    }

    public PnovNoved(Integer novCodigo) {
        this.novCodigo = novCodigo;
    }

    public Integer getNovCodigo() {
        return novCodigo;
    }

    public String getCedulaReg() {
        return cedulaReg;
    }

    public void setCedulaReg(String cedulaReg) {
        this.cedulaReg = cedulaReg;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }


    public void setNovCodigo(Integer novCodigo) {
        this.novCodigo = novCodigo;
    }

    public Date getNovFecini() {
        return novFecini;
    }

    public void setNovFecini(Date novFecini) {
        this.novFecini = novFecini;
    }

    public String getNovObserv() {
        return novObserv;
    }

    public void setNovObserv(String novObserv) {
        this.novObserv = novObserv;
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

    public MuniUnida getUniCodigo2() {
        return uniCodigo2;
    }

    public void setUniCodigo2(MuniUnida uniCodigo2) {
        this.uniCodigo2 = uniCodigo2;
    }

    public MuniUnida getNovUnidad() {
        return novUnidad;
    }

    public void setNovUnidad(MuniUnida novUnidad) {
        this.novUnidad = novUnidad;
    }

    public PclpCauslicper getPclpCauslicper() {
        return pclpCauslicper;
    }

    public void setPclpCauslicper(PclpCauslicper pclpCauslicper) {
        this.pclpCauslicper = pclpCauslicper;
    }

    public PmemMilit getMemCedula() {
        return memCedula;
    }

    public void setMemCedula(PmemMilit memCedula) {
        this.memCedula = memCedula;
    }

    public List<PnovNoved> getPnovNovedList() {
        return pnovNovedList;
    }

    public void setPnovNovedList(List<PnovNoved> pnovNovedList) {
        this.pnovNovedList = pnovNovedList;
    }

    public PnovNoved getNovPadre() {
        return novPadre;
    }

    public void setNovPadre(PnovNoved novPadre) {
        this.novPadre = novPadre;
    }

    public String getNovDocumento() {
        return novDocumento;
    }

    public void setNovDocumento(String novDocumento) {
        this.novDocumento = novDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (novCodigo != null ? novCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PnovNoved)) {
            return false;
        }
        PnovNoved other = (PnovNoved) object;
        if ((this.novCodigo == null && other.novCodigo != null) || (this.novCodigo != null && !this.novCodigo.equals(other.novCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.ejercito.ws.bdd.PnovNoved[novCodigo=" + novCodigo + "]";
    }
}
