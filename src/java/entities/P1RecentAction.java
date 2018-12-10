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
@Table(name = "p1_recent_action")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "P1RecentAction.findAll", query = "SELECT p FROM P1RecentAction p")
    , @NamedQuery(name = "P1RecentAction.findByReceActiId", query = "SELECT p FROM P1RecentAction p WHERE p.receActiId = :receActiId")
    , @NamedQuery(name = "P1RecentAction.findByReceActiName", query = "SELECT p FROM P1RecentAction p WHERE p.receActiName = :receActiName")})
public class P1RecentAction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rece_acti_id")
    private Short receActiId;
    //@Size(max = 100)
    @Column(name = "rece_acti_name")
    private String receActiName;
    @OneToMany(mappedBy = "pothRecentAction")
    private Collection<P1Potholes> p1PotholesCollection;
    @OneToMany(mappedBy = "rodeRecentAction")
    private Collection<P1Rodent> p1RodentCollection;
    @OneToMany(mappedBy = "abanVehiRecentAction")
    private Collection<P1AbandonedVehicle> p1AbandonedVehicleCollection;
    @OneToMany(mappedBy = "garbCartRecentAction")
    private Collection<P1GarbageCart> p1GarbageCartCollection;

    public P1RecentAction() {
    }

    public P1RecentAction(Short receActiId) {
        this.receActiId = receActiId;
    }

    public Short getReceActiId() {
        return receActiId;
    }

    public void setReceActiId(Short receActiId) {
        this.receActiId = receActiId;
    }

    public String getReceActiName() {
        return receActiName;
    }

    public void setReceActiName(String receActiName) {
        this.receActiName = receActiName;
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
        hash += (receActiId != null ? receActiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof P1RecentAction)) {
            return false;
        }
        P1RecentAction other = (P1RecentAction) object;
        if ((this.receActiId == null && other.receActiId != null) || (this.receActiId != null && !this.receActiId.equals(other.receActiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.P1RecentAction[ receActiId=" + receActiId + " ]";
    }
    
}
