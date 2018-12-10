/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author anastasios
 */
@Entity
@Table(name = "p1_current_activity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "P1CurrentActivity.findAll", query = "SELECT p FROM P1CurrentActivity p")
    , @NamedQuery(name = "P1CurrentActivity.findByCurrActiId", query = "SELECT p FROM P1CurrentActivity p WHERE p.currActiId = :currActiId")
    , @NamedQuery(name = "P1CurrentActivity.findByCurrActiName", query = "SELECT p FROM P1CurrentActivity p WHERE p.currActiName = :currActiName")})
public class P1CurrentActivity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "curr_acti_id")
    private Short currActiId;
    //@Size(max = 50)
    @Column(name = "curr_acti_name")
    private String currActiName;
    @OneToMany(mappedBy = "pothActivity")
    private Collection<P1Potholes> p1PotholesCollection;
    @OneToMany(mappedBy = "rodeActivity")
    private Collection<P1Rodent> p1RodentCollection;
    @OneToMany(mappedBy = "abanVehiActivity")
    private Collection<P1AbandonedVehicle> p1AbandonedVehicleCollection;
    @OneToMany(mappedBy = "garbCartActivity")
    private Collection<P1GarbageCart> p1GarbageCartCollection;

    public P1CurrentActivity() {
    }

    public P1CurrentActivity(Short currActiId) {
        this.currActiId = currActiId;
    }

    public Short getCurrActiId() {
        return currActiId;
    }

    public void setCurrActiId(Short currActiId) {
        this.currActiId = currActiId;
    }

    public String getCurrActiName() {
        return currActiName;
    }

    public void setCurrActiName(String currActiName) {
        this.currActiName = currActiName;
    }

    @XmlTransient
    public Collection<P1Potholes> getP1PotholesCollection() {
        return p1PotholesCollection;
    }

    public void setP1PotholesCollection(Collection<P1Potholes> p1PotholesCollection) {
        this.p1PotholesCollection = p1PotholesCollection;
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
    public Collection<P1GarbageCart> getP1GarbageCartCollection() {
        return p1GarbageCartCollection;
    }

    public void setP1GarbageCartCollection(Collection<P1GarbageCart> p1GarbageCartCollection) {
        this.p1GarbageCartCollection = p1GarbageCartCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (currActiId != null ? currActiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof P1CurrentActivity)) {
            return false;
        }
        P1CurrentActivity other = (P1CurrentActivity) object;
        if ((this.currActiId == null && other.currActiId != null) || (this.currActiId != null && !this.currActiId.equals(other.currActiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.P1CurrentActivity[ currActiId=" + currActiId + " ]";
    }
    
}
