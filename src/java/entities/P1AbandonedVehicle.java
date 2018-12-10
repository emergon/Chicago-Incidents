/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entitiesSP.PlatesMoreThanOnce;
import entitiesSP.RequestPerDayByType;
import entitiesSP.SecondMostCommonColor;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anastasios
 */
@Entity
@Table(name = "p1_abandoned_vehicle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "P1AbandonedVehicle.findAll", query = "SELECT p FROM P1AbandonedVehicle p")
    , @NamedQuery(name = "P1AbandonedVehicle.findTotalCount", query = "SELECT count(p.abanVehiId) FROM P1AbandonedVehicle p")
    , @NamedQuery(name = "P1AbandonedVehicle.findByAbanVehiId", query = "SELECT p FROM P1AbandonedVehicle p WHERE p.abanVehiId = :abanVehiId")
    , @NamedQuery(name = "P1AbandonedVehicle.findByAbanVehiPlate", query = "SELECT p FROM P1AbandonedVehicle p WHERE p.abanVehiPlate = :abanVehiPlate")
    , @NamedQuery(name = "P1AbandonedVehicle.findByAbanVehiModel", query = "SELECT p FROM P1AbandonedVehicle p WHERE p.abanVehiModel = :abanVehiModel")
    , @NamedQuery(name = "P1AbandonedVehicle.findByAbanVehiDaysParked", query = "SELECT p FROM P1AbandonedVehicle p WHERE p.abanVehiDaysParked = :abanVehiDaysParked")
    , @NamedQuery(name = "P1AbandonedVehicle.findByAbanVehiSsa", query = "SELECT p FROM P1AbandonedVehicle p WHERE p.abanVehiSsa = :abanVehiSsa")})
@SqlResultSetMappings({
    @SqlResultSetMapping(name = "PlatesMoreThanOnceMapping", classes
            = @ConstructorResult(targetClass = PlatesMoreThanOnce.class,
                    columns = {
                        @ColumnResult(name = "plate", type = String.class)
                        ,
                    @ColumnResult(name = "num", type = Long.class)
                    }))
    ,
    @SqlResultSetMapping(name = "SecondMostCommonColorMapping", classes
            = @ConstructorResult(targetClass = SecondMostCommonColor.class,
                    columns = {
                        @ColumnResult(name = "color", type = Integer.class)
                        ,
                    @ColumnResult(name = "num", type = Long.class)
                    }))
})
public class P1AbandonedVehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aban_vehi_id")
    private Integer abanVehiId;
    //@Size(max = 400)
    @Column(name = "aban_vehi_plate")
    private String abanVehiPlate;
    //@Size(max = 200)
    @Column(name = "aban_vehi_model")
    private String abanVehiModel;
    @Column(name = "aban_vehi_days_parked")
    private Integer abanVehiDaysParked;
    @Column(name = "aban_vehi_ssa")
    private Short abanVehiSsa;
    @JoinColumn(name = "aban_vehi_color", referencedColumnName = "colo_id")
    @ManyToOne
    private P1Color abanVehiColor;
    @JoinColumn(name = "aban_vehi_activity", referencedColumnName = "curr_acti_id")
    @ManyToOne
    private P1CurrentActivity abanVehiActivity;
    @JoinColumn(name = "inci_kwd", referencedColumnName = "inci_kwd")
    @ManyToOne
    private P1Incidents inciKwd;
    @JoinColumn(name = "aban_vehi_recent_action", referencedColumnName = "rece_acti_id")
    @ManyToOne
    private P1RecentAction abanVehiRecentAction;

    public P1AbandonedVehicle() {
    }

    public P1AbandonedVehicle(Integer abanVehiId) {
        this.abanVehiId = abanVehiId;
    }

    public Integer getAbanVehiId() {
        return abanVehiId;
    }

    public void setAbanVehiId(Integer abanVehiId) {
        this.abanVehiId = abanVehiId;
    }

    public String getAbanVehiPlate() {
        return abanVehiPlate;
    }

    public void setAbanVehiPlate(String abanVehiPlate) {
        this.abanVehiPlate = abanVehiPlate;
    }

    public String getAbanVehiModel() {
        return abanVehiModel;
    }

    public void setAbanVehiModel(String abanVehiModel) {
        this.abanVehiModel = abanVehiModel;
    }

    public Integer getAbanVehiDaysParked() {
        return abanVehiDaysParked;
    }

    public void setAbanVehiDaysParked(Integer abanVehiDaysParked) {
        this.abanVehiDaysParked = abanVehiDaysParked;
    }

    public Short getAbanVehiSsa() {
        return abanVehiSsa;
    }

    public void setAbanVehiSsa(Short abanVehiSsa) {
        this.abanVehiSsa = abanVehiSsa;
    }

    public P1Color getAbanVehiColor() {
        return abanVehiColor;
    }

    public void setAbanVehiColor(P1Color abanVehiColor) {
        this.abanVehiColor = abanVehiColor;
    }

    public P1CurrentActivity getAbanVehiActivity() {
        return abanVehiActivity;
    }

    public void setAbanVehiActivity(P1CurrentActivity abanVehiActivity) {
        this.abanVehiActivity = abanVehiActivity;
    }

    public P1Incidents getInciKwd() {
        return inciKwd;
    }

    public void setInciKwd(P1Incidents inciKwd) {
        this.inciKwd = inciKwd;
    }

    public P1RecentAction getAbanVehiRecentAction() {
        return abanVehiRecentAction;
    }

    public void setAbanVehiRecentAction(P1RecentAction abanVehiRecentAction) {
        this.abanVehiRecentAction = abanVehiRecentAction;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (abanVehiId != null ? abanVehiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof P1AbandonedVehicle)) {
            return false;
        }
        P1AbandonedVehicle other = (P1AbandonedVehicle) object;
        if ((this.abanVehiId == null && other.abanVehiId != null) || (this.abanVehiId != null && !this.abanVehiId.equals(other.abanVehiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.P1AbandonedVehicle[ abanVehiId=" + abanVehiId + " ]";
    }

}
