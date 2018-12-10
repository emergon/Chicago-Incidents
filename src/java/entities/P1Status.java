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
@Table(name = "p1_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "P1Status.findAll", query = "SELECT p FROM P1Status p")
    , @NamedQuery(name = "P1Status.findByStatId", query = "SELECT p FROM P1Status p WHERE p.statId = :statId")
    , @NamedQuery(name = "P1Status.findByStatName", query = "SELECT p FROM P1Status p WHERE p.statName = :statName")})
public class P1Status implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stat_id")
    private Short statId;
    //@Size(max = 20)
    @Column(name = "stat_name")
    private String statName;
    @OneToMany(mappedBy = "inciStatus")
    private Collection<P1Incidents> p1IncidentsCollection;

    public P1Status() {
    }

    public P1Status(Short statId) {
        this.statId = statId;
    }

    public Short getStatId() {
        return statId;
    }

    public void setStatId(Short statId) {
        this.statId = statId;
    }

    public String getStatName() {
        return statName;
    }

    public void setStatName(String statName) {
        this.statName = statName;
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
        hash += (statId != null ? statId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof P1Status)) {
            return false;
        }
        P1Status other = (P1Status) object;
        if ((this.statId == null && other.statId != null) || (this.statId != null && !this.statId.equals(other.statId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.P1Status[ statId=" + statId + " ]";
    }
    
}
