package ec.mil.ejercito.ws.bdd;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @unidad SIPER
 * @author Cbop. Cacuango Luis
 */
@Entity
@Table(name = "XUNI_USER", schema = "SEGURIDADES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XuniUser.findAll", query = "SELECT x FROM XuniUser x"),
    @NamedQuery(name = "XuniUser.findByUniCodigo2", query = "SELECT x FROM XuniUser x WHERE x.xuniUserPK.uniCodigo2 = :uniCodigo2"),
    @NamedQuery(name = "XuniUser.findByMemCedula", query = "SELECT x FROM XuniUser x WHERE x.xuniUserPK.memCedula = :memCedula"),
    @NamedQuery(name = "XuniUser.findBySisCodigosissub", query = "SELECT x FROM XuniUser x WHERE x.xuniUserPK.sisCodigosissub = :sisCodigosissub"),
    @NamedQuery(name = "XuniUser.findByUserFehaasigna", query = "SELECT x FROM XuniUser x WHERE x.userFehaasigna = :userFehaasigna")})
public class XuniUser implements Serializable {

    @JoinColumn(name = "SIS_CODIGOSISSUB", referencedColumnName = "SIS_CODIGOSISSUB", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private XsisSistemaSubsistema xsisSistemaSubsistema;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected XuniUserPK xuniUserPK;
    @Column(name = "USER_FEHAASIGNA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userFehaasigna;
    @JoinColumn(name = "MEM_CEDULA", referencedColumnName = "MEM_CEDULA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private XusrUsuariosistema xusrUsuariosistema;

    public XuniUser() {
    }

    public XuniUser(XuniUserPK xuniUserPK) {
        this.xuniUserPK = xuniUserPK;
    }

    public XuniUser(String uniCodigo2, String memCedula, String sisCodigosissub) {
        this.xuniUserPK = new XuniUserPK(uniCodigo2, memCedula, sisCodigosissub);
    }

    public XuniUserPK getXuniUserPK() {
        return xuniUserPK;
    }

    public void setXuniUserPK(XuniUserPK xuniUserPK) {
        this.xuniUserPK = xuniUserPK;
    }

    public Date getUserFehaasigna() {
        return userFehaasigna;
    }

    public void setUserFehaasigna(Date userFehaasigna) {
        this.userFehaasigna = userFehaasigna;
    }

    public XusrUsuariosistema getXusrUsuariosistema() {
        return xusrUsuariosistema;
    }

    public void setXusrUsuariosistema(XusrUsuariosistema xusrUsuariosistema) {
        this.xusrUsuariosistema = xusrUsuariosistema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xuniUserPK != null ? xuniUserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XuniUser)) {
            return false;
        }
        XuniUser other = (XuniUser) object;
        if ((this.xuniUserPK == null && other.xuniUserPK != null) || (this.xuniUserPK != null && !this.xuniUserPK.equals(other.xuniUserPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.ejercito.ws.bdd.XuniUser[ xuniUserPK=" + xuniUserPK + " ]";
    }

    public XsisSistemaSubsistema getXsisSistemaSubsistema() {
        return xsisSistemaSubsistema;
    }

    public void setXsisSistemaSubsistema(XsisSistemaSubsistema xsisSistemaSubsistema) {
        this.xsisSistemaSubsistema = xsisSistemaSubsistema;
    }

}
