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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author anastasios
 */
@Entity
@Table(name = "p1_incident_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "P1IncidentType.findAll", query = "SELECT p FROM P1IncidentType p")
    , @NamedQuery(name = "P1IncidentType.findByInciTypeId", query = "SELECT p FROM P1IncidentType p WHERE p.inciTypeId = :inciTypeId")
    , @NamedQuery(name = "P1IncidentType.findByInciTypeName", query = "SELECT p FROM P1IncidentType p WHERE p.inciTypeName = :inciTypeName")})
public class P1IncidentType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    @Column(name = "inci_type_id")
    private Short inciTypeId;
    //@Size(max = 50)
    @Column(name = "inci_type_name")
    private String inciTypeName;
    @OneToMany(mappedBy = "inciRequestType")
    private Collection<P1Incidents> p1IncidentsCollection;

    public P1IncidentType() {
    }

    public P1IncidentType(Short inciTypeId) {
        this.inciTypeId = inciTypeId;
    }

    public Short getInciTypeId() {
        return inciTypeId;
    }

    public void setInciTypeId(Short inciTypeId) {
        this.inciTypeId = inciTypeId;
    }

    public String getInciTypeName() {
        return inciTypeName;
    }

    public void setInciTypeName(String inciTypeName) {
        this.inciTypeName = inciTypeName;
    }

    @XmlTransient
    public Collection<P1Incidents> getP1IncidentsCollection() {
        return p1IncidentsCollection;
    }

    public void setP1IncidentsCollection(Collection<P1Incidents> p1IncidentsCollection) {
        this.p1IncidentsCollection = p1IncidentsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inciTypeId != null ? inciTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof P1IncidentType)) {
            return false;
        }
        P1IncidentType other = (P1IncidentType) object;
        if ((this.inciTypeId == null && other.inciTypeId != null) || (this.inciTypeId != null && !this.inciTypeId.equals(other.inciTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.P1IncidentType[ inciTypeId=" + inciTypeId + " ]";
    }
    
}
