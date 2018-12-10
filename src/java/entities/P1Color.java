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
@Table(name = "p1_color")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "P1Color.findAll", query = "SELECT p FROM P1Color p")
    , @NamedQuery(name = "P1Color.findByColoId", query = "SELECT p FROM P1Color p WHERE p.coloId = :coloId")
    , @NamedQuery(name = "P1Color.findByColoName", query = "SELECT p FROM P1Color p WHERE p.coloName = :coloName")})
public class P1Color implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "colo_id")
    private Short coloId;
    //@Size(max = 20)
    @Column(name = "colo_name")
    private String coloName;
    @OneToMany(mappedBy = "abanVehiColor")
    private Collection<P1AbandonedVehicle> p1AbandonedVehicleCollection;

    public P1Color() {
    }

    public P1Color(Short coloId) {
        this.coloId = coloId;
    }

    public Short getColoId() {
        return coloId;
    }

    public void setColoId(Short coloId) {
        this.coloId = coloId;
    }

    public String getColoName() {
        return coloName;
    }

    public void setColoName(String coloName) {
        this.coloName = coloName;
    }

    @XmlTransient
    public Collection<P1AbandonedVehicle> getP1AbandonedVehicleCollection() {
        return p1AbandonedVehicleCollection;
    }

    public void setP1AbandonedVehicleCollection(Collection<P1AbandonedVehicle> p1AbandonedVehicleCollection) {
        this.p1AbandonedVehicleCollection = p1AbandonedVehicleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coloId != null ? coloId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof P1Color)) {
            return false;
        }
        P1Color other = (P1Color) object;
        if ((this.coloId == null && other.coloId != null) || (this.coloId != null && !this.coloId.equals(other.coloId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.P1Color[ coloId=" + coloId + " ]";
    }
    
}
