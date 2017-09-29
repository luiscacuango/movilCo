package ec.mil.ejercito.ws.bdd;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @unidad SIPER
 * @author Cbop. Cacuango Luis
 */
@Entity
@Table(name = "PGMI_G_MIL", schema = "SIPER")

public class PgmiGMil implements Serializable {

    @JoinTable(name = "PCXG_COMPXGRAD", joinColumns = {
        @JoinColumn(name = "GMI_CODIGO_OPC", referencedColumnName = "GMI_CODIGO")}, inverseJoinColumns = {
        @JoinColumn(name = "GMI_CODIGO_REQ", referencedColumnName = "GMI_CODIGO")})
    @ManyToMany
    private List<PgmiGMil> pgmiGMilList;
    @Id
    @Basic(optional = false)
    @Column(name = "GMI_CODIGO")
    private Integer gmiCodigo;
    @Basic(optional = false)
    @Column(name = "GMI_NOMBRE")
    private String gmiNombre;
    @Basic(optional = false)
    @Column(name = "GMI_SIGLAS")
    private String gmiSiglas;
    @Column(name = "GMI_NOTAMI")
    private BigDecimal gmiNotami;
    @Column(name = "GMI_FACTOR")
    private Short gmiFactor;
    @Column(name = "GMI_REPRES")
    private Character gmiRepres;
    @Column(name = "GMI_GUARNI")
    private Short gmiGuarni;
    @Column(name = "GMI_TIEMPO")
    private Short gmiTiempo;
    @Column(name = "GMI_TIMESE")
    private Short gmiTimese;
    @Column(name = "GMI_TIMESP")
    private Short gmiTimesp;
    @Column(name = "GMI_PONDERA")
    private BigInteger gmiPondera;
    @Column(name = "GMI_GRDSUE")
    private Integer gmiGrdsue;
    @Column(name = "GMI_GRDEQUI")
    private Integer gmiGrdequi;
    @Column(name = "GMI_INDIGRD")
    private BigDecimal gmiIndigrd;
    @Column(name = "GMI_INDTSRV")
    private BigDecimal gmiIndtsrv;
    @Column(name = "GMI_INDSUBF")
    private BigDecimal gmiIndsubf;
    @Column(name = "GMI_GRUPOE")
    private Short gmiGrupoe;
    @Column(name = "GMI_UBICGEO")
    private Short gmiUbicgeo;
    @Column(name = "GMI_PORCLUB")
    private BigDecimal gmiPorclub;
    @Column(name = "GMI_CIRMILI")
    private BigDecimal gmiCirmili;
    @Column(name = "GMI_INDCLAS")
    private BigDecimal gmiIndclas;
    @Column(name = "GMI_SIGSUELDO")
    private String gmiSigsueldo;
    @OneToMany(mappedBy = "gmiCodigo")
    private List<PmemMilit> pmemMilitList;
    @OneToMany(mappedBy = "pgmGmiCodigo")
    private List<PmemMilit> pmemMilitList1;

    public PgmiGMil() {
    }

    public PgmiGMil(Integer gmiCodigo) {
        this.gmiCodigo = gmiCodigo;
    }

    public PgmiGMil(Integer gmiCodigo, String gmiNombre, String gmiSiglas) {
        this.gmiCodigo = gmiCodigo;
        this.gmiNombre = gmiNombre;
        this.gmiSiglas = gmiSiglas;
    }

    public Integer getGmiCodigo() {
        return gmiCodigo;
    }

    public void setGmiCodigo(Integer gmiCodigo) {
        this.gmiCodigo = gmiCodigo;
    }

    public String getGmiNombre() {
        return gmiNombre;
    }

    public void setGmiNombre(String gmiNombre) {
        this.gmiNombre = gmiNombre;
    }

    public String getGmiSiglas() {
        return gmiSiglas;
    }

    public void setGmiSiglas(String gmiSiglas) {
        this.gmiSiglas = gmiSiglas;
    }

    public BigDecimal getGmiNotami() {
        return gmiNotami;
    }

    public void setGmiNotami(BigDecimal gmiNotami) {
        this.gmiNotami = gmiNotami;
    }

    public Short getGmiFactor() {
        return gmiFactor;
    }

    public void setGmiFactor(Short gmiFactor) {
        this.gmiFactor = gmiFactor;
    }

    public Character getGmiRepres() {
        return gmiRepres;
    }

    public void setGmiRepres(Character gmiRepres) {
        this.gmiRepres = gmiRepres;
    }

    public Short getGmiGuarni() {
        return gmiGuarni;
    }

    public void setGmiGuarni(Short gmiGuarni) {
        this.gmiGuarni = gmiGuarni;
    }

    public Short getGmiTiempo() {
        return gmiTiempo;
    }

    public void setGmiTiempo(Short gmiTiempo) {
        this.gmiTiempo = gmiTiempo;
    }

    public Short getGmiTimese() {
        return gmiTimese;
    }

    public void setGmiTimese(Short gmiTimese) {
        this.gmiTimese = gmiTimese;
    }

    public Short getGmiTimesp() {
        return gmiTimesp;
    }

    public void setGmiTimesp(Short gmiTimesp) {
        this.gmiTimesp = gmiTimesp;
    }

    public BigInteger getGmiPondera() {
        return gmiPondera;
    }

    public void setGmiPondera(BigInteger gmiPondera) {
        this.gmiPondera = gmiPondera;
    }

    public Integer getGmiGrdsue() {
        return gmiGrdsue;
    }

    public void setGmiGrdsue(Integer gmiGrdsue) {
        this.gmiGrdsue = gmiGrdsue;
    }

    public Integer getGmiGrdequi() {
        return gmiGrdequi;
    }

    public void setGmiGrdequi(Integer gmiGrdequi) {
        this.gmiGrdequi = gmiGrdequi;
    }

    public BigDecimal getGmiIndigrd() {
        return gmiIndigrd;
    }

    public void setGmiIndigrd(BigDecimal gmiIndigrd) {
        this.gmiIndigrd = gmiIndigrd;
    }

    public BigDecimal getGmiIndtsrv() {
        return gmiIndtsrv;
    }

    public void setGmiIndtsrv(BigDecimal gmiIndtsrv) {
        this.gmiIndtsrv = gmiIndtsrv;
    }

    public BigDecimal getGmiIndsubf() {
        return gmiIndsubf;
    }

    public void setGmiIndsubf(BigDecimal gmiIndsubf) {
        this.gmiIndsubf = gmiIndsubf;
    }

    public Short getGmiGrupoe() {
        return gmiGrupoe;
    }

    public void setGmiGrupoe(Short gmiGrupoe) {
        this.gmiGrupoe = gmiGrupoe;
    }

    public Short getGmiUbicgeo() {
        return gmiUbicgeo;
    }

    public void setGmiUbicgeo(Short gmiUbicgeo) {
        this.gmiUbicgeo = gmiUbicgeo;
    }

    public BigDecimal getGmiPorclub() {
        return gmiPorclub;
    }

    public void setGmiPorclub(BigDecimal gmiPorclub) {
        this.gmiPorclub = gmiPorclub;
    }

    public BigDecimal getGmiCirmili() {
        return gmiCirmili;
    }

    public void setGmiCirmili(BigDecimal gmiCirmili) {
        this.gmiCirmili = gmiCirmili;
    }

    public BigDecimal getGmiIndclas() {
        return gmiIndclas;
    }

    public void setGmiIndclas(BigDecimal gmiIndclas) {
        this.gmiIndclas = gmiIndclas;
    }

    public String getGmiSigsueldo() {
        return gmiSigsueldo;
    }

    public void setGmiSigsueldo(String gmiSigsueldo) {
        this.gmiSigsueldo = gmiSigsueldo;
    }

    public List<PmemMilit> getPmemMilitList() {
        return pmemMilitList;
    }

    public void setPmemMilitList(List<PmemMilit> pmemMilitList) {
        this.pmemMilitList = pmemMilitList;
    }

    public List<PmemMilit> getPmemMilitList1() {
        return pmemMilitList1;
    }

    public void setPmemMilitList1(List<PmemMilit> pmemMilitList1) {
        this.pmemMilitList1 = pmemMilitList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gmiCodigo != null ? gmiCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgmiGMil)) {
            return false;
        }
        PgmiGMil other = (PgmiGMil) object;
        if ((this.gmiCodigo == null && other.gmiCodigo != null) || (this.gmiCodigo != null && !this.gmiCodigo.equals(other.gmiCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.ejercito.ws.bdd.PgmiGMil[gmiCodigo=" + gmiCodigo + "]";
    }

    @XmlTransient
    public List<PgmiGMil> getPgmiGMilList() {
        return pgmiGMilList;
    }

    public void setPgmiGMilList(List<PgmiGMil> pgmiGMilList) {
        this.pgmiGMilList = pgmiGMilList;
    }

}
