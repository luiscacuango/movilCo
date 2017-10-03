package ec.mil.ejercito.ws.bdd;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "XPUS_PERFILUSARIO", schema = "SEGURIDADES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XpusPerfilusario.findAll", query = "SELECT x FROM XpusPerfilusario x"),
    @NamedQuery(name = "XpusPerfilusario.findByMemCedula", query = "SELECT x FROM XpusPerfilusario x WHERE x.xpusPerfilusarioPK.memCedula = :memCedula"),
    @NamedQuery(name = "XpusPerfilusario.findByPerCodigoperfil", query = "SELECT x FROM XpusPerfilusario x WHERE x.xpusPerfilusarioPK.perCodigoperfil = :perCodigoperfil"),
    @NamedQuery(name = "XpusPerfilusario.findByPerFechaasigna", query = "SELECT x FROM XpusPerfilusario x WHERE x.perFechaasigna = :perFechaasigna"),
    @NamedQuery(name = "XpusPerfilusario.findByPerValida", query = "SELECT x FROM XpusPerfilusario x WHERE x.perValida = :perValida")})
public class XpusPerfilusario implements Serializable {

    @JoinColumn(name = "PER_CODIGOPERFIL", referencedColumnName = "PER_CODIGOPERFIL", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private XperPerfilsistema xperPerfilsistema;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected XpusPerfilusarioPK xpusPerfilusarioPK;
    @Column(name = "PER_FECHAASIGNA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFechaasigna;
    @Column(name = "PER_VALIDA")
    private Character perValida;
    @JoinColumn(name = "MEM_CEDULA", referencedColumnName = "MEM_CEDULA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private XusrUsuariosistema xusrUsuariosistema;

    public XpusPerfilusario() {
    }

    public XpusPerfilusario(XpusPerfilusarioPK xpusPerfilusarioPK) {
        this.xpusPerfilusarioPK = xpusPerfilusarioPK;
    }

    public XpusPerfilusario(String memCedula, BigInteger perCodigoperfil) {
        this.xpusPerfilusarioPK = new XpusPerfilusarioPK(memCedula, perCodigoperfil);
    }

    public XpusPerfilusarioPK getXpusPerfilusarioPK() {
        return xpusPerfilusarioPK;
    }

    public void setXpusPerfilusarioPK(XpusPerfilusarioPK xpusPerfilusarioPK) {
        this.xpusPerfilusarioPK = xpusPerfilusarioPK;
    }

    public Date getPerFechaasigna() {
        return perFechaasigna;
    }

    public void setPerFechaasigna(Date perFechaasigna) {
        this.perFechaasigna = perFechaasigna;
    }

    public Character getPerValida() {
        return perValida;
    }

    public void setPerValida(Character perValida) {
        this.perValida = perValida;
    }

    public XusrUsuariosistema getXusrUsuariosistema() {
        return xusrUsuariosistema;
    }

    public void setXusrUsuariosistema(XusrUsuariosistema xusrUsuariosistema) {
        this.xusrUsuariosistema = xusrUsuariosistema;
    }

    public XperPerfilsistema getXperPerfilsistema() {
        return xperPerfilsistema;
    }

    public void setXperPerfilsistema(XperPerfilsistema xperPerfilsistema) {
        this.xperPerfilsistema = xperPerfilsistema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xpusPerfilusarioPK != null ? xpusPerfilusarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XpusPerfilusario)) {
            return false;
        }
        XpusPerfilusario other = (XpusPerfilusario) object;
        if ((this.xpusPerfilusarioPK == null && other.xpusPerfilusarioPK != null) || (this.xpusPerfilusarioPK != null && !this.xpusPerfilusarioPK.equals(other.xpusPerfilusarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.ejercito.ws.bdd.XpusPerfilusario[ xpusPerfilusarioPK=" + xpusPerfilusarioPK + " ]";
    }

}
