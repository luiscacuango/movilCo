package ec.mil.ejercito.ws.bdd;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * @unidad SIPER
 * @author Cbop. Cacuango Luis
 */
@Entity
@Table(name = "MUNI_UNIDA", schema = "SIPER")

public class MuniUnida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UNI_CODIGO2")
    private String uniCodigo2;
    @Column(name = "UNI_DESCRI2")
    private String uniDescri2;
    @Column(name = "UNI_SIGLAS2")
    private String uniSiglas2;
    @Column(name = "UNI_FECCRE")
    @Temporal(TemporalType.DATE)
    private Date uniFeccre;
    @Column(name = "UNI_RANCHO")
    private Character uniRancho;
    @Column(name = "UNI_NUMNIV")
    private BigInteger uniNumniv;
    @Column(name = "UNI_GUARNI")
    private Character uniGuarni;
    @Column(name = "UNI_ESTADO")
    private Character uniEstado;
    @Column(name = "UNI_INDEPEN")
    private Character uniIndepen;
    @Column(name = "UNI_CODFIN")
    private Short uniCodfin;
    @Column(name = "UNI_CAMPA")
    private Character uniCampa;
    @Column(name = "UNI_ORDEN")
    private Short uniOrden;
    @Column(name = "UNI_DOCT")
    private Character uniDoct;
    @Column(name = "UNI_MOVIL")
    private Character uniMovil;
    @Column(name = "UNI_SECUNI")
    private Integer uniSecuni;
    @Column(name = "UNI_GEREN")
    private Integer uniGeren;
    @Column(name = "UNI_PRIORIDAD")
    private BigInteger uniPrioridad;
    @OneToMany(mappedBy = "munUniCodigo2")
    private List<MuniUnida> muniUnidaList;
    @JoinColumn(name = "MUN_UNI_CODIGO2", referencedColumnName = "UNI_CODIGO2")
    @ManyToOne
    private MuniUnida munUniCodigo2;
    @OneToMany(mappedBy = "mun4UniCodigo2")
    private List<MuniUnida> muniUnidaList1;
    @JoinColumn(name = "MUN4_UNI_CODIGO2", referencedColumnName = "UNI_CODIGO2")
    @ManyToOne
    private MuniUnida mun4UniCodigo2;
    @OneToMany(mappedBy = "mun5UniCodigo2")
    private List<MuniUnida> muniUnidaList2;
    @JoinColumn(name = "MUN5_UNI_CODIGO2", referencedColumnName = "UNI_CODIGO2")
    @ManyToOne
    private MuniUnida mun5UniCodigo2;
    @OneToMany(mappedBy = "mun2UniCodigo2")
    private List<MuniUnida> muniUnidaList3;
    @JoinColumn(name = "MUN2_UNI_CODIGO2", referencedColumnName = "UNI_CODIGO2")
    @ManyToOne
    private MuniUnida mun2UniCodigo2;
    @OneToMany(mappedBy = "mun3UniCodigo2")
    private List<MuniUnida> muniUnidaList4;
    @JoinColumn(name = "MUN3_UNI_CODIGO2", referencedColumnName = "UNI_CODIGO2")
    @ManyToOne
    private MuniUnida mun3UniCodigo2;
    @Transient
    private BigInteger uniNivel;

    @OneToMany(mappedBy = "uniCodigo2")
    private List<PmemMilit> unidad;

    public BigInteger getUniNivel() {
        return uniNivel;
    }

    public void setUniNivel(BigInteger uniNivel) {
        this.uniNivel = uniNivel;
    }

    public MuniUnida() {
    }

    public MuniUnida(String uniCodigo2, String uniSiglas2, String uniDescri2) {
        this.uniCodigo2 = uniCodigo2;
        this.uniDescri2 = uniDescri2;
        this.uniSiglas2 = uniSiglas2;
    }

    public MuniUnida(String uniCodigo2) {
        this.uniCodigo2 = uniCodigo2;
    }

    public String getUniCodigo2() {
        return uniCodigo2;
    }

    public void setUniCodigo2(String uniCodigo2) {
        this.uniCodigo2 = uniCodigo2;
    }

    public String getUniDescri2() {
        return uniDescri2;
    }

    public void setUniDescri2(String uniDescri2) {
        this.uniDescri2 = uniDescri2;
    }

    public String getUniSiglas2() {
        return uniSiglas2;
    }

    public void setUniSiglas2(String uniSiglas2) {
        this.uniSiglas2 = uniSiglas2;
    }

    public Date getUniFeccre() {
        return uniFeccre;
    }

    public void setUniFeccre(Date uniFeccre) {
        this.uniFeccre = uniFeccre;
    }

    public Character getUniRancho() {
        return uniRancho;
    }

    public void setUniRancho(Character uniRancho) {
        this.uniRancho = uniRancho;
    }

    public BigInteger getUniNumniv() {
        return uniNumniv;
    }

    public void setUniNumniv(BigInteger uniNumniv) {
        this.uniNumniv = uniNumniv;
    }

    public Character getUniGuarni() {
        return uniGuarni;
    }

    public void setUniGuarni(Character uniGuarni) {
        this.uniGuarni = uniGuarni;
    }

    public Character getUniEstado() {
        return uniEstado;
    }

    public void setUniEstado(Character uniEstado) {
        this.uniEstado = uniEstado;
    }

    public Character getUniIndepen() {
        return uniIndepen;
    }

    public void setUniIndepen(Character uniIndepen) {
        this.uniIndepen = uniIndepen;
    }

    public Short getUniCodfin() {
        return uniCodfin;
    }

    public void setUniCodfin(Short uniCodfin) {
        this.uniCodfin = uniCodfin;
    }

    public Character getUniCampa() {
        return uniCampa;
    }

    public void setUniCampa(Character uniCampa) {
        this.uniCampa = uniCampa;
    }

    public Short getUniOrden() {
        return uniOrden;
    }

    public void setUniOrden(Short uniOrden) {
        this.uniOrden = uniOrden;
    }

    public Character getUniDoct() {
        return uniDoct;
    }

    public void setUniDoct(Character uniDoct) {
        this.uniDoct = uniDoct;
    }

    public Character getUniMovil() {
        return uniMovil;
    }

    public void setUniMovil(Character uniMovil) {
        this.uniMovil = uniMovil;
    }

    public Integer getUniSecuni() {
        return uniSecuni;
    }

    public void setUniSecuni(Integer uniSecuni) {
        this.uniSecuni = uniSecuni;
    }

    public Integer getUniGeren() {
        return uniGeren;
    }

    public void setUniGeren(Integer uniGeren) {
        this.uniGeren = uniGeren;
    }

    public BigInteger getUniPrioridad() {
        return uniPrioridad;
    }

    public void setUniPrioridad(BigInteger uniPrioridad) {
        this.uniPrioridad = uniPrioridad;
    }

    public List<MuniUnida> getMuniUnidaList() {
        return muniUnidaList;
    }

    public void setMuniUnidaList(List<MuniUnida> muniUnidaList) {
        this.muniUnidaList = muniUnidaList;
    }

    public MuniUnida getMunUniCodigo2() {
        return munUniCodigo2;
    }

    public void setMunUniCodigo2(MuniUnida munUniCodigo2) {
        this.munUniCodigo2 = munUniCodigo2;
    }

    public List<MuniUnida> getMuniUnidaList1() {
        return muniUnidaList1;
    }

    public void setMuniUnidaList1(List<MuniUnida> muniUnidaList1) {
        this.muniUnidaList1 = muniUnidaList1;
    }

    public MuniUnida getMun4UniCodigo2() {
        return mun4UniCodigo2;
    }

    public void setMun4UniCodigo2(MuniUnida mun4UniCodigo2) {
        this.mun4UniCodigo2 = mun4UniCodigo2;
    }

    public List<MuniUnida> getMuniUnidaList2() {
        return muniUnidaList2;
    }

    public void setMuniUnidaList2(List<MuniUnida> muniUnidaList2) {
        this.muniUnidaList2 = muniUnidaList2;
    }

    public MuniUnida getMun5UniCodigo2() {
        return mun5UniCodigo2;
    }

    public void setMun5UniCodigo2(MuniUnida mun5UniCodigo2) {
        this.mun5UniCodigo2 = mun5UniCodigo2;
    }

    public List<MuniUnida> getMuniUnidaList3() {
        return muniUnidaList3;
    }

    public void setMuniUnidaList3(List<MuniUnida> muniUnidaList3) {
        this.muniUnidaList3 = muniUnidaList3;
    }

    public MuniUnida getMun2UniCodigo2() {
        return mun2UniCodigo2;
    }

    public void setMun2UniCodigo2(MuniUnida mun2UniCodigo2) {
        this.mun2UniCodigo2 = mun2UniCodigo2;
    }

    public List<MuniUnida> getMuniUnidaList4() {
        return muniUnidaList4;
    }

    public void setMuniUnidaList4(List<MuniUnida> muniUnidaList4) {
        this.muniUnidaList4 = muniUnidaList4;
    }

    public MuniUnida getMun3UniCodigo2() {
        return mun3UniCodigo2;
    }

    public void setMun3UniCodigo2(MuniUnida mun3UniCodigo2) {
        this.mun3UniCodigo2 = mun3UniCodigo2;
    }

    public List<PmemMilit> getUnidad() {
        return unidad;
    }

    public void setUnidad(List<PmemMilit> unidad) {
        this.unidad = unidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uniCodigo2 != null ? uniCodigo2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MuniUnida)) {
            return false;
        }
        MuniUnida other = (MuniUnida) object;
        if ((this.uniCodigo2 == null && other.uniCodigo2 != null) || (this.uniCodigo2 != null && !this.uniCodigo2.equals(other.uniCodigo2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.ejercito.ws.bdd.MuniUnida[uniCodigo2=" + uniCodigo2 + "]";
    }
}
