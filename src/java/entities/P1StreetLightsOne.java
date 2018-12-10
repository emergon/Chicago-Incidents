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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anastasios
 */
@Entity
@Table(name = "p1_street_lights_one")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "P1StreetLightsOne.findAll", query = "SELECT p FROM P1StreetLightsOne p")
    , @NamedQuery(name = "P1StreetLightsOne.findTotalCount", query = "SELECT count(p.streLighOneId) FROM P1StreetLightsOne p")
    , @NamedQuery(name = "P1StreetLightsOne.findByStreLighOneId", query = "SELECT p FROM P1StreetLightsOne p WHERE p.streLighOneId = :streLighOneId")})
public class P1StreetLightsOne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stre_ligh_one_id")
    private Integer streLighOneId;
    @JoinColumn(name = "inci_kwd", referencedColumnName = "inci_kwd")
    @ManyToOne
    private P1Incidents inciKwd;

    public P1StreetLightsOne() {
    }

    public P1StreetLightsOne(Integer streLighOneId) {
        this.streLighOneId = streLighOneId;
    }

    public Integer getStreLighOneId() {
        return streLighOneId;
    }

    public void setStreLighOneId(Integer streLighOneId) {
        this.streLighOneId = streLighOneId;
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
        hash += (streLighOneId != null ? streLighOneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof P1StreetLightsOne)) {
            return false;
        }
        P1StreetLightsOne other = (P1StreetLightsOne) object;
        if ((this.streLighOneId == null && other.streLighOneId != null) || (this.streLighOneId != null && !this.streLighOneId.equals(other.streLighOneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.P1StreetLightsOne[ streLighOneId=" + streLighOneId + " ]";
    }
    
}
