package ec.mil.ejercito.ws.bdd;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @unidad SIPER
 * @author Cbop. Cacuango Luis
 */
@Entity
@Table(name = "XPER_PERFILSISTEMA", schema = "SEGURIDADES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XperPerfilsistema.findAll", query = "SELECT x FROM XperPerfilsistema x"),
    @NamedQuery(name = "XperPerfilsistema.findByPerCodigoperfil", query = "SELECT x FROM XperPerfilsistema x WHERE x.perCodigoperfil = :perCodigoperfil"),
    @NamedQuery(name = "XperPerfilsistema.findByPerNombreperfil", query = "SELECT x FROM XperPerfilsistema x WHERE x.perNombreperfil = :perNombreperfil"),
    @NamedQuery(name = "XperPerfilsistema.findByPerDefault", query = "SELECT x FROM XperPerfilsistema x WHERE x.perDefault = :perDefault"),
    @NamedQuery(name = "XperPerfilsistema.findByPerAdmin", query = "SELECT x FROM XperPerfilsistema x WHERE x.perAdmin = :perAdmin")})
public class XperPerfilsistema implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_CODIGOPERFIL")
    private BigDecimal perCodigoperfil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PER_NOMBREPERFIL")
    private String perNombreperfil;
    @Column(name = "PER_DEFAULT")
    private BigInteger perDefault;
    @Column(name = "PER_ADMIN")
    private BigInteger perAdmin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "xperPerfilsistema")
    private Collection<XpusPerfilusario> xpusPerfilusarioCollection;
    @JoinColumn(name = "SIS_CODIGOSISSUB", referencedColumnName = "SIS_CODIGOSISSUB")
    @ManyToOne
    private XsisSistemaSubsistema sisCodigosissub;

    public XperPerfilsistema() {
    }

    public XperPerfilsistema(BigDecimal perCodigoperfil) {
        this.perCodigoperfil = perCodigoperfil;
    }

    public XperPerfilsistema(BigDecimal perCodigoperfil, String perNombreperfil) {
        this.perCodigoperfil = perCodigoperfil;
        this.perNombreperfil = perNombreperfil;
    }

    public BigDecimal getPerCodigoperfil() {
        return perCodigoperfil;
    }

    public void setPerCodigoperfil(BigDecimal perCodigoperfil) {
        this.perCodigoperfil = perCodigoperfil;
    }

    public String getPerNombreperfil() {
        return perNombreperfil;
    }

    public void setPerNombreperfil(String perNombreperfil) {
        this.perNombreperfil = perNombreperfil;
    }

    public BigInteger getPerDefault() {
        return perDefault;
    }

    public void setPerDefault(BigInteger perDefault) {
        this.perDefault = perDefault;
    }

    public BigInteger getPerAdmin() {
        return perAdmin;
    }

    public void setPerAdmin(BigInteger perAdmin) {
        this.perAdmin = perAdmin;
    }

    @XmlTransient
    public Collection<XpusPerfilusario> getXpusPerfilusarioCollection() {
        return xpusPerfilusarioCollection;
    }

    public void setXpusPerfilusarioCollection(Collection<XpusPerfilusario> xpusPerfilusarioCollection) {
        this.xpusPerfilusarioCollection = xpusPerfilusarioCollection;
    }

    public XsisSistemaSubsistema getSisCodigosissub() {
        return sisCodigosissub;
    }

    public void setSisCodigosissub(XsisSistemaSubsistema sisCodigosissub) {
        this.sisCodigosissub = sisCodigosissub;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perCodigoperfil != null ? perCodigoperfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XperPerfilsistema)) {
            return false;
        }
        XperPerfilsistema other = (XperPerfilsistema) object;
        if ((this.perCodigoperfil == null && other.perCodigoperfil != null) || (this.perCodigoperfil != null && !this.perCodigoperfil.equals(other.perCodigoperfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.ejercito.ws.bdd.XperPerfilsistema[ perCodigoperfil=" + perCodigoperfil + " ]";
    }

}
