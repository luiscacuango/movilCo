package ec.mil.ejercito.ws.bdd;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @unidad SIPER
 * @author Cbop. Cacuango Luis
 */
@Entity
@Table(name = "PMEM_MILIT", schema = "SIPER")
public class PmemMilit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MEM_CEDULA")
    private String memCedula;
    @Column(name = "ORG_NUMERO")
    private String orgNumero;
    @Column(name = "MEM_PASAPO")
    private String memPasapo;
    @Column(name = "MEM_APELLI")
    private String memApelli;
    @Column(name = "MEM_NOMBRE")
    private String memNombre;
    @Column(name = "MEM_FECNAC")
    @Temporal(TemporalType.DATE)
    private Date memFecnac;
    @Column(name = "MEM_VIVO")
    private Character memVivo;
    @Column(name = "MEM_F_MUER")
    @Temporal(TemporalType.DATE)
    private Date memFMuer;
    @Column(name = "MEM_F_ALTA")
    @Temporal(TemporalType.DATE)
    private Date memFAlta;
    @Column(name = "MEM_FECING")
    @Temporal(TemporalType.DATE)
    private Date memFecing;
    @Column(name = "MEM_DIRECC")
    private String memDirecc;
    @Column(name = "MEM_TELEFO")
    private String memTelefo;
    @Column(name = "MEM_NATIVO")
    private Character memNativo;
    @Column(name = "MEM_NUMLIBRETA")
    private String memNumlibreta;
    @Column(name = "MEM_ASPIRANTE")
    private Character memAspirante;
    @Column(name = "MEM_CUENTA")
    private String memCuenta;
    @Column(name = "MEM_TIPCUEN")
    private Character memTipcuen;
    @Column(name = "MEM_RECSUB")
    private Character memRecsub;
    @Column(name = "MEM_TIPO_DOCENTE")
    private Character memTipoDocente;
    @Column(name = "MEM_ESCALAFON")
    private BigInteger memEscalafon;
    @Column(name = "MEM_CALTEM")
    private BigDecimal memCaltem;
    @Column(name = "MEM_FONPROPIOS")
    private Character memFonpropios;
    @Column(name = "MEM_TELEFN")
    private String memTelefn;
    @Column(name = "MEM_IDMILI")
    private String memIdmili;
    @Column(name = "MEM_NLOSCA")
    private Short memNlosca;
    @Column(name = "MEM_PLOSCA")
    private String memPlosca;
    @Column(name = "MEM_SISTEMA")
    private String memSistema;
    @Column(name = "MEM_E_MAIL")
    private String memEMail;
    @Column(name = "MEM_FON_RES")
    private Character memFonRes;
    @JoinColumn(name = "GMI_CODIGO", referencedColumnName = "GMI_CODIGO")
    @ManyToOne
    private PgmiGMil gmiCodigo;
    @JoinColumn(name = "PGM_GMI_CODIGO", referencedColumnName = "GMI_CODIGO")
    @ManyToOne
    private PgmiGMil pgmGmiCodigo;
    //Creados manual
    @Column(name = "PRQ_CODIG")
    private String prqNac;
    @Column(name = "CAN_CODIGO")
    private String canNac;
    @Column(name = "PRV_CODIGO")
    private String prvNac;
    @Column(name = "MPR_PRV_CODIGO")
    private String prvDom;
    @Column(name = "MPR_CAN_CODIGO")
    private String canDom;
    @Column(name = "MPR_PRQ_CODIG")
    private String prqDom;
    @Column(name = "TSA_CODIGO")
    private String tsaCodigo;
    @Column(name = "OJO_CODIGO")
    private String ojoCodigo;
    @Column(name = "CAB_CODIGO")
    private String cabCodigo;
    @Column(name = "CPI_CODIGO")
    private String pielCod;
    @Column(name = "RAZ_SECUEN")
    private String razSecuen;
    @Column(name = "REL_CODIGO")
    private Integer relCodigo;

    public PmemMilit() {
    }

    public String getPielCod() {
        return pielCod;
    }

    public void setPielCod(String pielCod) {
        this.pielCod = pielCod;
    }

    public String getCabCodigo() {
        return cabCodigo;
    }

    public void setCabCodigo(String cabCodigo) {
        this.cabCodigo = cabCodigo;
    }

    public String getOjoCodigo() {
        return ojoCodigo;
    }

    public void setOjoCodigo(String ojoCodigo) {
        this.ojoCodigo = ojoCodigo;
    }

    public String getTsaCodigo() {
        return tsaCodigo;
    }

    public void setTsaCodigo(String tsaCodigo) {
        this.tsaCodigo = tsaCodigo;
    }

    public String getCanDom() {
        return canDom;
    }

    public void setCanDom(String canDom) {
        this.canDom = canDom;
    }

    public String getCanNac() {
        return canNac;
    }

    public void setCanNac(String canNac) {
        this.canNac = canNac;
    }

    public String getPrqDom() {
        return prqDom;
    }

    public void setPrqDom(String prqDom) {
        this.prqDom = prqDom;
    }

    public String getPrqNac() {
        return prqNac;
    }

    public void setPrqNac(String prqNac) {
        this.prqNac = prqNac;
    }

    public String getPrvDom() {
        return prvDom;
    }

    public void setPrvDom(String prvDom) {
        this.prvDom = prvDom;
    }

    public String getPrvNac() {
        return prvNac;
    }

    public void setPrvNac(String prvNac) {
        this.prvNac = prvNac;
    }

    public PmemMilit(String memCedula) {
        this.memCedula = memCedula;
    }

    public String getMemCedula() {
        return memCedula;
    }

    public void setMemCedula(String memCedula) {
        this.memCedula = memCedula;
    }

    public String getOrgNumero() {
        return orgNumero;
    }

    public void setOrgNumero(String orgNumero) {
        this.orgNumero = orgNumero;
    }

    public String getMemPasapo() {
        return memPasapo;
    }

    public void setMemPasapo(String memPasapo) {
        this.memPasapo = memPasapo;
    }

    public String getMemApelli() {
        return memApelli;
    }

    public void setMemApelli(String memApelli) {
        this.memApelli = memApelli;
    }

    public String getMemNombre() {
        return memNombre;
    }

    public void setMemNombre(String memNombre) {
        this.memNombre = memNombre;
    }

    public Date getMemFecnac() {
        return memFecnac;
    }

    public void setMemFecnac(Date memFecnac) {
        this.memFecnac = memFecnac;
    }

    public Character getMemVivo() {
        return memVivo;
    }

    public void setMemVivo(Character memVivo) {
        this.memVivo = memVivo;
    }

    public Date getMemFMuer() {
        return memFMuer;
    }

    public void setMemFMuer(Date memFMuer) {
        this.memFMuer = memFMuer;
    }

    public Date getMemFAlta() {
        return memFAlta;
    }

    public void setMemFAlta(Date memFAlta) {
        this.memFAlta = memFAlta;
    }

    public Date getMemFecing() {
        return memFecing;
    }

    public void setMemFecing(Date memFecing) {
        this.memFecing = memFecing;
    }

    public String getMemDirecc() {
        return memDirecc;
    }

    public void setMemDirecc(String memDirecc) {
        this.memDirecc = memDirecc;
    }

    public String getMemTelefo() {
        return memTelefo;
    }

    public void setMemTelefo(String memTelefo) {
        this.memTelefo = memTelefo;
    }

    public Character getMemNativo() {
        return memNativo;
    }

    public void setMemNativo(Character memNativo) {
        this.memNativo = memNativo;
    }

    public String getMemNumlibreta() {
        return memNumlibreta;
    }

    public void setMemNumlibreta(String memNumlibreta) {
        this.memNumlibreta = memNumlibreta;
    }

    public Character getMemAspirante() {
        return memAspirante;
    }

    public void setMemAspirante(Character memAspirante) {
        this.memAspirante = memAspirante;
    }

    public String getMemCuenta() {
        return memCuenta;
    }

    public void setMemCuenta(String memCuenta) {
        this.memCuenta = memCuenta;
    }

    public Character getMemTipcuen() {
        return memTipcuen;
    }

    public void setMemTipcuen(Character memTipcuen) {
        this.memTipcuen = memTipcuen;
    }

    public Character getMemRecsub() {
        return memRecsub;
    }

    public void setMemRecsub(Character memRecsub) {
        this.memRecsub = memRecsub;
    }

    public Character getMemTipoDocente() {
        return memTipoDocente;
    }

    public void setMemTipoDocente(Character memTipoDocente) {
        this.memTipoDocente = memTipoDocente;
    }

    public BigInteger getMemEscalafon() {
        return memEscalafon;
    }

    public void setMemEscalafon(BigInteger memEscalafon) {
        this.memEscalafon = memEscalafon;
    }

    public BigDecimal getMemCaltem() {
        return memCaltem;
    }

    public void setMemCaltem(BigDecimal memCaltem) {
        this.memCaltem = memCaltem;
    }

    public Character getMemFonpropios() {
        return memFonpropios;
    }

    public void setMemFonpropios(Character memFonpropios) {
        this.memFonpropios = memFonpropios;
    }

    public String getMemTelefn() {
        return memTelefn;
    }

    public void setMemTelefn(String memTelefn) {
        this.memTelefn = memTelefn;
    }

    public String getMemIdmili() {
        return memIdmili;
    }

    public void setMemIdmili(String memIdmili) {
        this.memIdmili = memIdmili;
    }

    public Short getMemNlosca() {
        return memNlosca;
    }

    public void setMemNlosca(Short memNlosca) {
        this.memNlosca = memNlosca;
    }

    public String getMemPlosca() {
        return memPlosca;
    }

    public void setMemPlosca(String memPlosca) {
        this.memPlosca = memPlosca;
    }

    public String getMemSistema() {
        return memSistema;
    }

    public void setMemSistema(String memSistema) {
        this.memSistema = memSistema;
    }

    public String getMemEMail() {
        return memEMail;
    }

    public void setMemEMail(String memEMail) {
        this.memEMail = memEMail;
    }

    public Character getMemFonRes() {
        return memFonRes;
    }

    public void setMemFonRes(Character memFonRes) {
        this.memFonRes = memFonRes;
    }

    public PgmiGMil getGmiCodigo() {
        return gmiCodigo;
    }

    public void setGmiCodigo(PgmiGMil gmiCodigo) {
        this.gmiCodigo = gmiCodigo;
    }

    public PgmiGMil getPgmGmiCodigo() {
        return pgmGmiCodigo;
    }

    public void setPgmGmiCodigo(PgmiGMil pgmGmiCodigo) {
        this.pgmGmiCodigo = pgmGmiCodigo;
    }

    public String getRazSecuen() {
        return razSecuen;
    }

    public void setRazSecuen(String razSecuen) {
        this.razSecuen = razSecuen;
    }

    public Integer getRelCodigo() {
        return relCodigo;
    }

    public void setRelCodigo(Integer relCodigo) {
        this.relCodigo = relCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memCedula != null ? memCedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PmemMilit)) {
            return false;
        }
        PmemMilit other = (PmemMilit) object;
        if ((this.memCedula == null && other.memCedula != null) || (this.memCedula != null && !this.memCedula.equals(other.memCedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.ejercito.ws.bdd.PmemMilit[memCedula=" + memCedula + "]";
    }
}
