/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entitiesSP.MostCommonRequestPerZipByDate;
import entitiesSP.RequestPerDayByType;
import entitiesSP.RequestPerType;
import entitiesSP.Top5SsaWithRequestsPerDay;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author anastasios
 */
@Entity
@Table(name = "p1_incidents")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "P1Incidents.findAll", query = "SELECT p FROM P1Incidents p")
    , @NamedQuery(name = "P1Incidents.findTotalCount", query = "SELECT count(p.inciKwd) FROM P1Incidents p")
    , @NamedQuery(name = "P1Incidents.findByInciKwd", query = "SELECT p FROM P1Incidents p WHERE p.inciKwd = :inciKwd")
    , @NamedQuery(name = "P1Incidents.findLikeAddress", query = "SELECT p FROM P1Incidents p WHERE p.inciAddress like :address")
    , @NamedQuery(name = "P1Incidents.findByInciCreationDate", query = "SELECT p FROM P1Incidents p WHERE p.inciCreationDate = :inciCreationDate")
    , @NamedQuery(name = "P1Incidents.findByInciCompletionDate", query = "SELECT p FROM P1Incidents p WHERE p.inciCompletionDate = :inciCompletionDate")
    , @NamedQuery(name = "P1Incidents.findByInciRequestNum", query = "SELECT p FROM P1Incidents p WHERE p.inciRequestNum = :inciRequestNum")
    , @NamedQuery(name = "P1Incidents.findByInciAddress", query = "SELECT p FROM P1Incidents p WHERE p.inciAddress = :inciAddress")
    , @NamedQuery(name = "P1Incidents.findByInciZip", query = "SELECT p FROM P1Incidents p WHERE p.inciZip = :inciZip")
    , @NamedQuery(name = "P1Incidents.findByInciX", query = "SELECT p FROM P1Incidents p WHERE p.inciX = :inciX")
    , @NamedQuery(name = "P1Incidents.findByInciY", query = "SELECT p FROM P1Incidents p WHERE p.inciY = :inciY")
    , @NamedQuery(name = "P1Incidents.findByInciWard", query = "SELECT p FROM P1Incidents p WHERE p.inciWard = :inciWard")
    , @NamedQuery(name = "P1Incidents.findByInciPoliceDistrict", query = "SELECT p FROM P1Incidents p WHERE p.inciPoliceDistrict = :inciPoliceDistrict")
    , @NamedQuery(name = "P1Incidents.findByInciCommArea", query = "SELECT p FROM P1Incidents p WHERE p.inciCommArea = :inciCommArea")
    , @NamedQuery(name = "P1Incidents.findByInciLatitude", query = "SELECT p FROM P1Incidents p WHERE p.inciLatitude = :inciLatitude")
    , @NamedQuery(name = "P1Incidents.findByInciLongitude", query = "SELECT p FROM P1Incidents p WHERE p.inciLongitude = :inciLongitude")})

@SqlResultSetMappings({
    @SqlResultSetMapping(name = "RequestPerTypeMapping", classes
        = @ConstructorResult(targetClass = RequestPerType.class,
                columns = {
                    @ColumnResult(name = "requestType", type = Integer.class)
                    ,
                    @ColumnResult(name = "num", type = Long.class)
                })),
    @SqlResultSetMapping(name = "RequestPerDayByTypeMapping", classes
        = @ConstructorResult(targetClass = RequestPerDayByType.class,
                columns = {
                    @ColumnResult(name = "creationDate", type = Date.class)
                    ,
                    @ColumnResult(name = "num", type = Long.class)
                })),
    
    @SqlResultSetMapping(name = "MostCommonRequestPerZipByDateMapping", classes
        = @ConstructorResult(targetClass = MostCommonRequestPerZipByDate.class,
                columns = {
                    @ColumnResult(name = "zip", type = String.class)
                    ,
                    @ColumnResult(name = "requestType", type = Integer.class)
                    ,
                    @ColumnResult(name = "num", type = Long.class)
                })),
    @SqlResultSetMapping(name = "Top5SsaWithRequestsPerDayMapping", classes
        = @ConstructorResult(targetClass = Top5SsaWithRequestsPerDay.class,
                columns = {
                    @ColumnResult(name = "ssa", type = Integer.class)
                    ,
                    @ColumnResult(name = "num", type = Long.class)
                    ,
                    @ColumnResult(name = "hmnia", type = Date.class)
                }))
})
//@SqlResultSetMapping(name = "RequestPerTypeMapping", classes
//        = @ConstructorResult(targetClass = RequestPerType.class,
//                columns = {
//                    @ColumnResult(name = "requestType", type = Integer.class)
//                    ,
//                    @ColumnResult(name = "num", type = Long.class)
//                }))
public class P1Incidents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inci_kwd")
    private Integer inciKwd;
    @Column(name = "inci_creation_date")
    @Temporal(TemporalType.DATE)
    private Date inciCreationDate;
    @Column(name = "inci_completion_date")
    @Temporal(TemporalType.DATE)
    private Date inciCompletionDate;
    //@Size(max = 15)
    @Column(name = "inci_request_num")
    private String inciRequestNum;
    //@Size(max = 100)
    @Column(name = "inci_address")
    private String inciAddress;
    //@Size(max = 5)
    @Column(name = "inci_zip")
    private String inciZip;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "inci_x")
    private BigDecimal inciX;
    @Column(name = "inci_y")
    private BigDecimal inciY;
    @Column(name = "inci_ward")
    private Short inciWard;
    @Column(name = "inci_police_district")
    private Short inciPoliceDistrict;
    @Column(name = "inci_comm_area")
    private Short inciCommArea;
    @Column(name = "inci_latitude")
    private BigDecimal inciLatitude;
    @Column(name = "inci_longitude")
    private BigDecimal inciLongitude;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "inciKwd")
    private Collection<P1AlleyLightsOut> p1AlleyLightsOutCollection;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "inciKwd")
    private Collection<P1Sanitation> p1SanitationCollection;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "inciKwd")
    private Collection<P1Potholes> p1PotholesCollection;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "inciKwd")
    private Collection<P1StreetLightsAll> p1StreetLightsAllCollection;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "inciKwd")
    private Collection<P1Rodent> p1RodentCollection;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "inciKwd")
    private Collection<P1AbandonedVehicle> p1AbandonedVehicleCollection;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "inciKwd")
    private Collection<P1Graffiti> p1GraffitiCollection;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "inciKwd")
    private Collection<P1GarbageCart> p1GarbageCartCollection;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "inciKwd")
    private Collection<P1TreeDebris> p1TreeDebrisCollection;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "inciKwd")
    private Collection<P1StreetLightsOne> p1StreetLightsOneCollection;
    @JoinColumn(name = "inci_request_type", referencedColumnName = "inci_type_id")
    @ManyToOne
    private P1IncidentType inciRequestType;
    @JoinColumn(name = "inci_status", referencedColumnName = "stat_id")
    @ManyToOne
    private P1Status inciStatus;
    @JoinColumn(name = "xrhs_kwd", referencedColumnName = "xrhs_kwd")
    @ManyToOne
    private P1Xrhsths xrhsKwd;
    @OneToMany(mappedBy = "inciKwd")
    private Collection<P1TreeTrims> p1TreeTrimsCollection;

    public P1Incidents() {
    }

    public P1Incidents(Integer inciKwd) {
        this.inciKwd = inciKwd;
    }

    public Integer getInciKwd() {
        return inciKwd;
    }

    public void setInciKwd(Integer inciKwd) {
        this.inciKwd = inciKwd;
    }

    public Date getInciCreationDate() {
        return inciCreationDate;
    }

    public void setInciCreationDate(Date inciCreationDate) {
        this.inciCreationDate = inciCreationDate;
    }

    public Date getInciCompletionDate() {
        return inciCompletionDate;
    }

    public void setInciCompletionDate(Date inciCompletionDate) {
        this.inciCompletionDate = inciCompletionDate;
    }

    public String getInciRequestNum() {
        return inciRequestNum;
    }

    public void setInciRequestNum(String inciRequestNum) {
        this.inciRequestNum = inciRequestNum;
    }

    public String getInciAddress() {
        return inciAddress;
    }

    public void setInciAddress(String inciAddress) {
        this.inciAddress = inciAddress;
    }

    public String getInciZip() {
        return inciZip;
    }

    public void setInciZip(String inciZip) {
        this.inciZip = inciZip;
    }

    public BigDecimal getInciX() {
        return inciX;
    }

    public void setInciX(BigDecimal inciX) {
        this.inciX = inciX;
    }

    public BigDecimal getInciY() {
        return inciY;
    }

    public void setInciY(BigDecimal inciY) {
        this.inciY = inciY;
    }

    public Short getInciWard() {
        return inciWard;
    }

    public void setInciWard(Short inciWard) {
        this.inciWard = inciWard;
    }

    public Short getInciPoliceDistrict() {
        return inciPoliceDistrict;
    }

    public void setInciPoliceDistrict(Short inciPoliceDistrict) {
        this.inciPoliceDistrict = inciPoliceDistrict;
    }

    public Short getInciCommArea() {
        return inciCommArea;
    }

    public void setInciCommArea(Short inciCommArea) {
        this.inciCommArea = inciCommArea;
    }

    public BigDecimal getInciLatitude() {
        return inciLatitude;
    }

    public void setInciLatitude(BigDecimal inciLatitude) {
        this.inciLatitude = inciLatitude;
    }

    public BigDecimal getInciLongitude() {
        return inciLongitude;
    }

    public void setInciLongitude(BigDecimal inciLongitude) {
        this.inciLongitude = inciLongitude;
    }

    @XmlTransient
    public Collection<P1AlleyLightsOut> getP1AlleyLightsOutCollection() {
        return p1AlleyLightsOutCollection;
    }

    public void setP1AlleyLightsOutCollection(Collection<P1AlleyLightsOut> p1AlleyLightsOutCollection) {
        this.p1AlleyLightsOutCollection = p1AlleyLightsOutCollection;
    }

    @XmlTransient
    public Collection<P1Sanitation> getP1SanitationCollection() {
        return p1SanitationCollection;
    }

    public void setP1SanitationCollection(Collection<P1Sanitation> p1SanitationCollection) {
        this.p1SanitationCollection = p1SanitationCollection;
    }

    @XmlTransient
    public Collection<P1Potholes> getP1PotholesCollection() {
        return p1PotholesCollection;
    }

    public void setP1PotholesCollection(Collection<P1Potholes> p1PotholesCollection) {
        this.p1PotholesCollection = p1PotholesCollection;
    }

    @XmlTransient
    public Collection<P1StreetLightsAll> getP1StreetLightsAllCollection() {
        return p1StreetLightsAllCollection;
    }

    public void setP1StreetLightsAllCollection(Collection<P1StreetLightsAll> p1StreetLightsAllCollection) {
        this.p1StreetLightsAllCollection = p1StreetLightsAllCollection;
    }

    @XmlTransient
    public Collection<P1Rodent> getP1RodentCollection() {
        return p1RodentCollection;
    }

    public void setP1RodentCollection(Collection<P1Rodent> p1RodentCollection) {
        this.p1RodentCollection = p1RodentCollection;
    }

    @XmlTransient
    public Collection<P1AbandonedVehicle> getP1AbandonedVehicleCollection() {
        return p1AbandonedVehicleCollection;
    }

    public void setP1AbandonedVehicleCollection(Collection<P1AbandonedVehicle> p1AbandonedVehicleCollection) {
        this.p1AbandonedVehicleCollection = p1AbandonedVehicleCollection;
    }

    @XmlTransient
    public Collection<P1Graffiti> getP1GraffitiCollection() {
        return p1GraffitiCollection;
    }

    public void setP1GraffitiCollection(Collection<P1Graffiti> p1GraffitiCollection) {
        this.p1GraffitiCollection = p1GraffitiCollection;
    }

    @XmlTransient
    public Collection<P1GarbageCart> getP1GarbageCartCollection() {
        return p1GarbageCartCollection;
    }

    public void setP1GarbageCartCollection(Collection<P1GarbageCart> p1GarbageCartCollection) {
        this.p1GarbageCartCollection = p1GarbageCartCollection;
    }

    @XmlTransient
    public Collection<P1TreeDebris> getP1TreeDebrisCollection() {
        return p1TreeDebrisCollection;
    }

    public void setP1TreeDebrisCollection(Collection<P1TreeDebris> p1TreeDebrisCollection) {
        this.p1TreeDebrisCollection = p1TreeDebrisCollection;
    }

    @XmlTransient
    public Collection<P1StreetLightsOne> getP1StreetLightsOneCollection() {
        return p1StreetLightsOneCollection;
    }

    public void setP1StreetLightsOneCollection(Collection<P1StreetLightsOne> p1StreetLightsOneCollection) {
        this.p1StreetLightsOneCollection = p1StreetLightsOneCollection;
    }

    public P1IncidentType getInciRequestType() {
        return inciRequestType;
    }

    public void setInciRequestType(P1IncidentType inciRequestType) {
        this.inciRequestType = inciRequestType;
    }

    public P1Status getInciStatus() {
        return inciStatus;
    }

    public void setInciStatus(P1Status inciStatus) {
        this.inciStatus = inciStatus;
    }

    public P1Xrhsths getXrhsKwd() {
        return xrhsKwd;
    }

    public void setXrhsKwd(P1Xrhsths xrhsKwd) {
        this.xrhsKwd = xrhsKwd;
    }

    @XmlTransient
    public Collection<P1TreeTrims> getP1TreeTrimsCollection() {
        return p1TreeTrimsCollection;
    }

    public void setP1TreeTrimsCollection(Collection<P1TreeTrims> p1TreeTrimsCollection) {
        this.p1TreeTrimsCollection = p1TreeTrimsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inciKwd != null ? inciKwd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof P1Incidents)) {
            return false;
        }
        P1Incidents other = (P1Incidents) object;
        if ((this.inciKwd == null && other.inciKwd != null) || (this.inciKwd != null && !this.inciKwd.equals(other.inciKwd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.P1Incidents[ inciKwd=" + inciKwd + " ]";
    }
    
}
