package ec.mil.ejercito.ws.bdd;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @unidad SIPER
 * @author Cbop. Cacuango Luis
 */
@Entity
@Table(name = "XUSR_USUARIOSISTEMA", schema = "SEGURIDADES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XusrUsuariosistema.findAll", query = "SELECT x FROM XusrUsuariosistema x"),
    @NamedQuery(name = "XusrUsuariosistema.findByMemCedula", query = "SELECT x FROM XusrUsuariosistema x WHERE x.memCedula = :memCedula"),
    @NamedQuery(name = "XusrUsuariosistema.findByUsrActivo", query = "SELECT x FROM XusrUsuariosistema x WHERE x.usrActivo = :usrActivo"),
    @NamedQuery(name = "XusrUsuariosistema.findByUsrLogin", query = "SELECT x FROM XusrUsuariosistema x WHERE x.usrLogin = :usrLogin"),
    @NamedQuery(name = "XusrUsuariosistema.findByUsrPassword", query = "SELECT x FROM XusrUsuariosistema x WHERE x.usrPassword = :usrPassword"),
    @NamedQuery(name = "XusrUsuariosistema.findByUsrCambiarpassw", query = "SELECT x FROM XusrUsuariosistema x WHERE x.usrCambiarpassw = :usrCambiarpassw"),
    @NamedQuery(name = "XusrUsuariosistema.findByUsrCaduca", query = "SELECT x FROM XusrUsuariosistema x WHERE x.usrCaduca = :usrCaduca"),
    @NamedQuery(name = "XusrUsuariosistema.findByUsrCambiainicio", query = "SELECT x FROM XusrUsuariosistema x WHERE x.usrCambiainicio = :usrCambiainicio"),
    @NamedQuery(name = "XusrUsuariosistema.findByUsrFechacrea", query = "SELECT x FROM XusrUsuariosistema x WHERE x.usrFechacrea = :usrFechacrea"),
    @NamedQuery(name = "XusrUsuariosistema.findBySerCodigo", query = "SELECT x FROM XusrUsuariosistema x WHERE x.serCodigo = :serCodigo"),
    @NamedQuery(name = "XusrUsuariosistema.findByUsrFechaUltimoLogin", query = "SELECT x FROM XusrUsuariosistema x WHERE x.usrFechaUltimoLogin = :usrFechaUltimoLogin"),
    @NamedQuery(name = "XusrUsuariosistema.findByUsrFechaPnultimoLogin", query = "SELECT x FROM XusrUsuariosistema x WHERE x.usrFechaPnultimoLogin = :usrFechaPnultimoLogin"),
    @NamedQuery(name = "XusrUsuariosistema.findBySisEsquema", query = "SELECT x FROM XusrUsuariosistema x WHERE x.sisEsquema = :sisEsquema"),
    @NamedQuery(name = "XusrUsuariosistema.findByUsrPassmd5", query = "SELECT x FROM XusrUsuariosistema x WHERE x.usrPassmd5 = :usrPassmd5")})
public class XusrUsuariosistema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USR_ACTIVO")
    private BigInteger usrActivo;
    @Size(max = 50)
    @Column(name = "USR_LOGIN")
    private String usrLogin;
    @Size(max = 50)
    @Column(name = "USR_PASSWORD")
    private String usrPassword;
    @Column(name = "USR_CAMBIARPASSW")
    private BigInteger usrCambiarpassw;
    @Column(name = "USR_CADUCA")
    private BigInteger usrCaduca;
    @Column(name = "USR_CAMBIAINICIO")
    private BigInteger usrCambiainicio;
    @Column(name = "USR_FECHACREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechacrea;
    @Column(name = "SER_CODIGO")
    private BigInteger serCodigo;
    @Column(name = "USR_FECHA_ULTIMO_LOGIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaUltimoLogin;
    @Column(name = "USR_FECHA_PNULTIMO_LOGIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaPnultimoLogin;
    @Size(max = 30)
    @Column(name = "SIS_ESQUEMA")
    private String sisEsquema;
    @Size(max = 50)
    @Column(name = "USR_PASSMD5")
    private String usrPassmd5;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "xusrUsuariosistema")
    private Collection<XpusPerfilusario> xpusPerfilusarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "xusrUsuariosistema")
    private Collection<XuniUser> xuniUserCollection;

    @JoinColumn(name = "MEM_CEDULA", referencedColumnName = "MEM_CEDULA")
    @ManyToOne
    private PmemMilit memCedula;

    public XusrUsuariosistema() {
    }

    public PmemMilit getMemCedula() {
        return memCedula;
    }

    public void setMemCedula(PmemMilit memCedula) {
        this.memCedula = memCedula;
    }

    public BigInteger getUsrActivo() {
        return usrActivo;
    }

    public void setUsrActivo(BigInteger usrActivo) {
        this.usrActivo = usrActivo;
    }

    public String getUsrLogin() {
        return usrLogin;
    }

    public void setUsrLogin(String usrLogin) {
        this.usrLogin = usrLogin;
    }

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

    public BigInteger getUsrCambiarpassw() {
        return usrCambiarpassw;
    }

    public void setUsrCambiarpassw(BigInteger usrCambiarpassw) {
        this.usrCambiarpassw = usrCambiarpassw;
    }

    public BigInteger getUsrCaduca() {
        return usrCaduca;
    }

    public void setUsrCaduca(BigInteger usrCaduca) {
        this.usrCaduca = usrCaduca;
    }

    public BigInteger getUsrCambiainicio() {
        return usrCambiainicio;
    }

    public void setUsrCambiainicio(BigInteger usrCambiainicio) {
        this.usrCambiainicio = usrCambiainicio;
    }

    public Date getUsrFechacrea() {
        return usrFechacrea;
    }

    public void setUsrFechacrea(Date usrFechacrea) {
        this.usrFechacrea = usrFechacrea;
    }

    public BigInteger getSerCodigo() {
        return serCodigo;
    }

    public void setSerCodigo(BigInteger serCodigo) {
        this.serCodigo = serCodigo;
    }

    public Date getUsrFechaUltimoLogin() {
        return usrFechaUltimoLogin;
    }

    public void setUsrFechaUltimoLogin(Date usrFechaUltimoLogin) {
        this.usrFechaUltimoLogin = usrFechaUltimoLogin;
    }

    public Date getUsrFechaPnultimoLogin() {
        return usrFechaPnultimoLogin;
    }

    public void setUsrFechaPnultimoLogin(Date usrFechaPnultimoLogin) {
        this.usrFechaPnultimoLogin = usrFechaPnultimoLogin;
    }

    public String getSisEsquema() {
        return sisEsquema;
    }

    public void setSisEsquema(String sisEsquema) {
        this.sisEsquema = sisEsquema;
    }

    public String getUsrPassmd5() {
        return usrPassmd5;
    }

    public void setUsrPassmd5(String usrPassmd5) {
        this.usrPassmd5 = usrPassmd5;
    }

    public Collection<XpusPerfilusario> getXpusPerfilusarioCollection() {
        return xpusPerfilusarioCollection;
    }

    public void setXpusPerfilusarioCollection(Collection<XpusPerfilusario> xpusPerfilusarioCollection) {
        this.xpusPerfilusarioCollection = xpusPerfilusarioCollection;
    }

    public Collection<XuniUser> getXuniUserCollection() {
        return xuniUserCollection;
    }

    public void setXuniUserCollection(Collection<XuniUser> xuniUserCollection) {
        this.xuniUserCollection = xuniUserCollection;
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
        if (!(object instanceof XusrUsuariosistema)) {
            return false;
        }
        XusrUsuariosistema other = (XusrUsuariosistema) object;
        if ((this.memCedula == null && other.memCedula != null) || (this.memCedula != null && !this.memCedula.equals(other.memCedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.ejercito.ws.bdd.XusrUsuariosistema[ memCedula=" + memCedula + " ]";
    }

}
