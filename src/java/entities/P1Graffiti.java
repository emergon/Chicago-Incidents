/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anastasios
 */
@Entity
@Table(name = "p1_graffiti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "P1Graffiti.findAll", query = "SELECT p FROM P1Graffiti p")
    , @NamedQuery(name = "P1Graffiti.findTotalCount", query = "SELECT count(p.grafId) FROM P1Graffiti p")
    , @NamedQuery(name = "P1Graffiti.findByGrafId", query = "SELECT p FROM P1Graffiti p WHERE p.grafId = :grafId")
    , @NamedQuery(name = "P1Graffiti.findByGrafSurface", query = "SELECT p FROM P1Graffiti p WHERE p.grafSurface = :grafSurface")
    , @NamedQuery(name = "P1Graffiti.findByGrafLocation", query = "SELECT p FROM P1Graffiti p WHERE p.grafLocation = :grafLocation")
    , @NamedQuery(name = "P1Graffiti.findByGrafSsa", query = "SELECT p FROM P1Graffiti p WHERE p.grafSsa = :grafSsa")})
public class P1Graffiti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "graf_id")
    private Integer grafId;
    //@Size(max = 50)
    @Column(name = "graf_surface")
    private String grafSurface;
    //@Size(max = 50)
    @Column(name = "graf_location")
    private String grafLocation;
    @Column(name = "graf_ssa")
    private Short grafSsa;
    @JoinColumn(name = "inci_kwd", referencedColumnName = "inci_kwd")
    @ManyToOne
    private P1Incidents inciKwd;

    public P1Graffiti() {
    }

    public P1Graffiti(Integer grafId) {
        this.grafId = grafId;
    }

    public Integer getGrafId() {
        return grafId;
    }

    public void setGrafId(Integer grafId) {
        this.grafId = grafId;
    }

    public String getGrafSurface() {
        return grafSurface;
    }

    public void setGrafSurface(String grafSurface) {
        this.grafSurface = grafSurface;
    }

    public String getGrafLocation() {
        return grafLocation;
    }

    public void setGrafLocation(String grafLocation) {
        this.grafLocation = grafLocation;
    }

    public Short getGrafSsa() {
        return grafSsa;
    }

    public void setGrafSsa(Short grafSsa) {
        this.grafSsa = grafSsa;
    }

    public P1Incidents getInciKwd() {
        return inciKwd;
    }

    public void setInciKwd(P1Incidents inciKwd) {
        this.inciKwd = inciKwd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grafId != null ? grafId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof P1Graffiti)) {
            return false;
        }
        P1Graffiti other = (P1Graffiti) object;
        if ((this.grafId == null && other.grafId != null) || (this.grafId != null && !this.grafId.equals(other.grafId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.P1Graffiti[ grafId=" + grafId + " ]";
    }
    
}
