/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.ejercito.ws.bdd;

import java.io.Serializable;
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
@Table(name = "XSIS_SISTEMA_SUBSISTEMA", schema = "SEGURIDADES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XsisSistemaSubsistema.findAll", query = "SELECT x FROM XsisSistemaSubsistema x"),
    @NamedQuery(name = "XsisSistemaSubsistema.findBySisCodigosissub", query = "SELECT x FROM XsisSistemaSubsistema x WHERE x.sisCodigosissub = :sisCodigosissub"),
    @NamedQuery(name = "XsisSistemaSubsistema.findBySisNombresistema", query = "SELECT x FROM XsisSistemaSubsistema x WHERE x.sisNombresistema = :sisNombresistema"),
    @NamedQuery(name = "XsisSistemaSubsistema.findBySisPaginaInicio", query = "SELECT x FROM XsisSistemaSubsistema x WHERE x.sisPaginaInicio = :sisPaginaInicio"),
    @NamedQuery(name = "XsisSistemaSubsistema.findBySisEsquema", query = "SELECT x FROM XsisSistemaSubsistema x WHERE x.sisEsquema = :sisEsquema"),
    @NamedQuery(name = "XsisSistemaSubsistema.findBySisTituloSistema", query = "SELECT x FROM XsisSistemaSubsistema x WHERE x.sisTituloSistema = :sisTituloSistema"),
    @NamedQuery(name = "XsisSistemaSubsistema.findBySisCharAdministrador", query = "SELECT x FROM XsisSistemaSubsistema x WHERE x.sisCharAdministrador = :sisCharAdministrador"),
    @NamedQuery(name = "XsisSistemaSubsistema.findBySisHabilitaunidad", query = "SELECT x FROM XsisSistemaSubsistema x WHERE x.sisHabilitaunidad = :sisHabilitaunidad"),
    @NamedQuery(name = "XsisSistemaSubsistema.findBySisWeb", query = "SELECT x FROM XsisSistemaSubsistema x WHERE x.sisWeb = :sisWeb"),
    @NamedQuery(name = "XsisSistemaSubsistema.findBySisTodos", query = "SELECT x FROM XsisSistemaSubsistema x WHERE x.sisTodos = :sisTodos"),
    @NamedQuery(name = "XsisSistemaSubsistema.findBySisContext", query = "SELECT x FROM XsisSistemaSubsistema x WHERE x.sisContext = :sisContext"),
    @NamedQuery(name = "XsisSistemaSubsistema.findBySisMigradoJboss", query = "SELECT x FROM XsisSistemaSubsistema x WHERE x.sisMigradoJboss = :sisMigradoJboss")})
public class XsisSistemaSubsistema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SIS_CODIGOSISSUB")
    private String sisCodigosissub;
    @Size(max = 100)
    @Column(name = "SIS_NOMBRESISTEMA")
    private String sisNombresistema;
    @Size(max = 60)
    @Column(name = "SIS_PAGINA_INICIO")
    private String sisPaginaInicio;
    @Size(max = 30)
    @Column(name = "SIS_ESQUEMA")
    private String sisEsquema;
    @Size(max = 200)
    @Column(name = "SIS_TITULO_SISTEMA")
    private String sisTituloSistema;
    @Size(max = 5)
    @Column(name = "SIS_CHAR_ADMINISTRADOR")
    private String sisCharAdministrador;
    @Column(name = "SIS_HABILITAUNIDAD")
    private BigInteger sisHabilitaunidad;
    @Column(name = "SIS_WEB")
    private BigInteger sisWeb;
    @Column(name = "SIS_TODOS")
    private BigInteger sisTodos;
    @Size(max = 30)
    @Column(name = "SIS_CONTEXT")
    private String sisContext;
    @Column(name = "SIS_MIGRADO_JBOSS")
    private BigInteger sisMigradoJboss;
    @OneToMany(mappedBy = "sisCodigosissub")
    private Collection<XperPerfilsistema> xperPerfilsistemaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "xsisSistemaSubsistema")
    private Collection<XuniUser> xuniUserCollection;
    @OneToMany(mappedBy = "xsiSisCodigosissub")
    private Collection<XsisSistemaSubsistema> xsisSistemaSubsistemaCollection;
    @JoinColumn(name = "XSI_SIS_CODIGOSISSUB", referencedColumnName = "SIS_CODIGOSISSUB")
    @ManyToOne
    private XsisSistemaSubsistema xsiSisCodigosissub;

    public XsisSistemaSubsistema() {
    }

    public XsisSistemaSubsistema(String sisCodigosissub) {
        this.sisCodigosissub = sisCodigosissub;
    }

    public String getSisCodigosissub() {
        return sisCodigosissub;
    }

    public void setSisCodigosissub(String sisCodigosissub) {
        this.sisCodigosissub = sisCodigosissub;
    }

    public String getSisNombresistema() {
        return sisNombresistema;
    }

    public void setSisNombresistema(String sisNombresistema) {
        this.sisNombresistema = sisNombresistema;
    }

    public String getSisPaginaInicio() {
        return sisPaginaInicio;
    }

    public void setSisPaginaInicio(String sisPaginaInicio) {
        this.sisPaginaInicio = sisPaginaInicio;
    }

    public String getSisEsquema() {
        return sisEsquema;
    }

    public void setSisEsquema(String sisEsquema) {
        this.sisEsquema = sisEsquema;
    }

    public String getSisTituloSistema() {
        return sisTituloSistema;
    }

    public void setSisTituloSistema(String sisTituloSistema) {
        this.sisTituloSistema = sisTituloSistema;
    }

    public String getSisCharAdministrador() {
        return sisCharAdministrador;
    }

    public void setSisCharAdministrador(String sisCharAdministrador) {
        this.sisCharAdministrador = sisCharAdministrador;
    }

    public BigInteger getSisHabilitaunidad() {
        return sisHabilitaunidad;
    }

    public void setSisHabilitaunidad(BigInteger sisHabilitaunidad) {
        this.sisHabilitaunidad = sisHabilitaunidad;
    }

    public BigInteger getSisWeb() {
        return sisWeb;
    }

    public void setSisWeb(BigInteger sisWeb) {
        this.sisWeb = sisWeb;
    }

    public BigInteger getSisTodos() {
        return sisTodos;
    }

    public void setSisTodos(BigInteger sisTodos) {
        this.sisTodos = sisTodos;
    }

    public String getSisContext() {
        return sisContext;
    }

    public void setSisContext(String sisContext) {
        this.sisContext = sisContext;
    }

    public BigInteger getSisMigradoJboss() {
        return sisMigradoJboss;
    }

    public void setSisMigradoJboss(BigInteger sisMigradoJboss) {
        this.sisMigradoJboss = sisMigradoJboss;
    }

    @XmlTransient
    public Collection<XperPerfilsistema> getXperPerfilsistemaCollection() {
        return xperPerfilsistemaCollection;
    }

    public void setXperPerfilsistemaCollection(Collection<XperPerfilsistema> xperPerfilsistemaCollection) {
        this.xperPerfilsistemaCollection = xperPerfilsistemaCollection;
    }

    @XmlTransient
    public Collection<XuniUser> getXuniUserCollection() {
        return xuniUserCollection;
    }

    public void setXuniUserCollection(Collection<XuniUser> xuniUserCollection) {
        this.xuniUserCollection = xuniUserCollection;
    }

    @XmlTransient
    public Collection<XsisSistemaSubsistema> getXsisSistemaSubsistemaCollection() {
        return xsisSistemaSubsistemaCollection;
    }

    public void setXsisSistemaSubsistemaCollection(Collection<XsisSistemaSubsistema> xsisSistemaSubsistemaCollection) {
        this.xsisSistemaSubsistemaCollection = xsisSistemaSubsistemaCollection;
    }

    public XsisSistemaSubsistema getXsiSisCodigosissub() {
        return xsiSisCodigosissub;
    }

    public void setXsiSisCodigosissub(XsisSistemaSubsistema xsiSisCodigosissub) {
        this.xsiSisCodigosissub = xsiSisCodigosissub;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sisCodigosissub != null ? sisCodigosissub.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XsisSistemaSubsistema)) {
            return false;
        }
        XsisSistemaSubsistema other = (XsisSistemaSubsistema) object;
        if ((this.sisCodigosissub == null && other.sisCodigosissub != null) || (this.sisCodigosissub != null && !this.sisCodigosissub.equals(other.sisCodigosissub))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.ejercito.ws.bdd.XsisSistemaSubsistema[ sisCodigosissub=" + sisCodigosissub + " ]";
    }

}
