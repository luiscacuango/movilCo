package ec.mil.ejercito.ws.bdd;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @unidad SIPER
 * @author Cbop. Cacuango Luis
 */
@Entity
@Table(name = "PLAN_L_ANU", schema = "SIPER")
public class PlanLAnu implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlanLAnuPK planLAnuPK;
    @Column(name = "LAN_FECFIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lanFecfin;
    @Column(name = "LAN_SUELDO")
    private Character lanSueldo;
    @Column(name = "LAN_DIREC")
    private String lanDirec;
    @Column(name = "LAN_TELEFO")
    private String lanTelefo;
    //Para registrar quien ingreso la novedad
    @Column(name = "MEM_CEDULA_REG")
    private String cedulaReg;
    @Column(name = "LAN_FECHA_REG")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReg;
    // Fin Ingreso Novedad
    @Column(name = "LAN_DIADESC")
    private Short lanDiadesc;
    @Column(name = "LAN_MAXDIA")
    private Integer lanMaxdia; //LAN_OBSERVA
    @Column(name = "LAN_OBSERVA")
    private String lanObserva;
    @JoinColumn(name = "UNI_CODIGO2", referencedColumnName = "UNI_CODIGO2")
    @ManyToOne
    private MuniUnida uniCodigo2;
    @JoinColumn(name = "CIU_CODIGO", referencedColumnName = "CIU_CODIGO")
    @ManyToOne
    private PciuCiudad ciuCodigo;
    @JoinColumns({
        @JoinColumn(name = "LAN_TIPOSOL", referencedColumnName = "LAN_TIPOSOL"),
        @JoinColumn(name = "CLP_CODIGO", referencedColumnName = "CLP_CODIGO")})
    @ManyToOne
    private PclpCauslicper pclpCauslicper;
    @JoinColumn(name = "MEM_CEDULA", referencedColumnName = "MEM_CEDULA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PmemMilit pmemMilit;
    @JoinColumn(name = "ORG_NUMERO", referencedColumnName = "ORG_NUMERO")
    @ManyToOne
    private PorgOGen orgNumero;
    @JoinColumn(name = "PAI_CODPAI", referencedColumnName = "PAI_CODPAI")
    @ManyToOne
    private PpaiPaises paiCodpai;
    @Column(name = "LAN_ESTADO")
    private Character lanEstado;

    public PlanLAnu() {
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

//    public String getEstadoEstado() {
//        String variable = "";
//        if (this.lanEstado != null) {
//            if (this.lanEstado == 'P') {
//                variable = "PROCESADA";
//            } else if (this.lanEstado == 'F') {
//                variable = "FINALIZADA";
//
//            } else if (this.lanEstado == 'C') {
//                variable = "CANCELADA";
//            } else if (this.lanEstado == 'S') {
//                variable = "SUSPENDIDA";
//            }
//        } else {
//            variable = " ";
//        }
//        return variable;
//    }
    public String getEstadoSalida() {
        String variable = "";
        if (this.pclpCauslicper.pclpCauslicperPK.getLanTiposol() != null) {
            if (this.pclpCauslicper.pclpCauslicperPK.getLanTiposol() == 'L') {
                if (this.pclpCauslicper.getPclpCauslicperPK().getClpCodigo() == 2) {
                    variable = "EXTERIOR";
                } else {
                    variable = "LOCAL";
                }
            } else {
                variable = "LOCAL";
            }
        } else {
            variable = " ";
        }
        return variable;
    }

    public String getEstadoSueldo() {
        String variable = "";
        if (this.lanSueldo != null) {
            if (this.lanSueldo == 'S') {
                variable = "CON SUELDO";
            } else {
                if (this.lanSueldo == 'N') {
                    variable = "SIN SUELDO";
                }
            }
        } else {
            variable = " ";
        }
        return variable;
    }

    public String getDiasUsoLicPer() {
        String var = "";
        long diasUsoLicPer = 0;

        if (this.lanDiadesc == null) {
            diasUsoLicPer = 0;
        } else {
            diasUsoLicPer = lanDiadesc;
        }
        var = diasUsoLicPer + "";
        return var;
    }

    public String getAnioUsoLicPer() {
        String var = "";
        String anioUsoLicPer = "";
        SimpleDateFormat formatoyyyy = new SimpleDateFormat("yyyy");
        if (this.planLAnuPK.getLanFecini() == null) {
            anioUsoLicPer = (formatoyyyy.format(new Date()));
        } else {
            anioUsoLicPer = (formatoyyyy.format(planLAnuPK.getLanFecini()));
        }
        var = anioUsoLicPer + "";
        return var;
    }

    public String getLanObserva() {
        return lanObserva;
    }

    public void setLanObserva(String lanObserva) {
        this.lanObserva = lanObserva;
    }

    public PlanLAnu(PlanLAnuPK planLAnuPK) {
        this.planLAnuPK = planLAnuPK;
    }

    public PlanLAnu(String memCedula, Date lanFecini) {
        this.planLAnuPK = new PlanLAnuPK(memCedula, lanFecini);
    }

    public PlanLAnuPK getPlanLAnuPK() {
        return planLAnuPK;
    }

    public void setPlanLAnuPK(PlanLAnuPK planLAnuPK) {
        this.planLAnuPK = planLAnuPK;
    }

    public Date getLanFecfin() {
        return lanFecfin;
    }

    public void setLanFecfin(Date lanFecfin) {
        this.lanFecfin = lanFecfin;
    }

//    public Character getLanTipsol() {
//        return lanTipsol;
//    }
//
//    public void setLanTipsol(Character lanTipsol) {
//        this.lanTipsol = lanTipsol;
//    }
    public Character getLanSueldo() {
        return lanSueldo;
    }

    public void setLanSueldo(Character lanSueldo) {
        this.lanSueldo = lanSueldo;
    }

    public String getLanDirec() {
        return lanDirec;
    }

    public void setLanDirec(String lanDirec) {
        this.lanDirec = lanDirec;
    }

    public String getLanTelefo() {
        return lanTelefo;
    }

    public void setLanTelefo(String lanTelefo) {
        this.lanTelefo = lanTelefo;
    }

    public Short getLanDiadesc() {
        return lanDiadesc;
    }

    public void setLanDiadesc(Short lanDiadesc) {
        this.lanDiadesc = lanDiadesc;
    }

    public Integer getLanMaxdia() {
        return lanMaxdia;
    }

    public void setLanMaxdia(Integer lanMaxdia) {
        this.lanMaxdia = lanMaxdia;
    }

    public MuniUnida getUniCodigo2() {
        return uniCodigo2;
    }

    public void setUniCodigo2(MuniUnida uniCodigo2) {
        this.uniCodigo2 = uniCodigo2;
    }

    public PciuCiudad getCiuCodigo() {
        return ciuCodigo;
    }

    public void setCiuCodigo(PciuCiudad ciuCodigo) {
        this.ciuCodigo = ciuCodigo;
    }

    public PclpCauslicper getPclpCauslicper() {
        return pclpCauslicper;
    }

    public void setPclpCauslicper(PclpCauslicper pclpCauslicper) {
        this.pclpCauslicper = pclpCauslicper;
    }

    public PmemMilit getPmemMilit() {
        return pmemMilit;
    }

    public void setPmemMilit(PmemMilit pmemMilit) {
        this.pmemMilit = pmemMilit;
    }

    public PorgOGen getOrgNumero() {
        return orgNumero;
    }

    public void setOrgNumero(PorgOGen orgNumero) {
        this.orgNumero = orgNumero;
    }

    public PpaiPaises getPaiCodpai() {
        return paiCodpai;
    }

    public void setPaiCodpai(PpaiPaises paiCodpai) {
        this.paiCodpai = paiCodpai;
    }

    public Character getLanEstado() {
        return lanEstado;
    }

    public void setLanEstado(Character lanEstado) {
        this.lanEstado = lanEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planLAnuPK != null ? planLAnuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanLAnu)) {
            return false;
        }
        PlanLAnu other = (PlanLAnu) object;
        if ((this.planLAnuPK == null && other.planLAnuPK != null) || (this.planLAnuPK != null && !this.planLAnuPK.equals(other.planLAnuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.ejercito.ws.bdd.PlanLAnu[planLAnuPK=" + planLAnuPK + "]";
    }
}
