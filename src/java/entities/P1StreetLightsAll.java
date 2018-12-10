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
@Table(name = "p1_street_lights_all")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "P1StreetLightsAll.findAll", query = "SELECT p FROM P1StreetLightsAll p")
    , @NamedQuery(name = "P1StreetLightsAll.findTotalCount", query = "SELECT count(p.streLighAllId) FROM P1StreetLightsAll p")
    , @NamedQuery(name = "P1StreetLightsAll.findByStreLighAllId", query = "SELECT p FROM P1StreetLightsAll p WHERE p.streLighAllId = :streLighAllId")})
public class P1StreetLightsAll implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stre_ligh_all_id")
    private Integer streLighAllId;
    @JoinColumn(name = "inci_kwd", referencedColumnName = "inci_kwd")
    @ManyToOne
    private P1Incidents inciKwd;

    public P1StreetLightsAll() {
    }

    public P1StreetLightsAll(Integer streLighAllId) {
        this.streLighAllId = streLighAllId;
    }

    public Integer getStreLighAllId() {
        return streLighAllId;
    }

    public void setStreLighAllId(Integer streLighAllId) {
        this.streLighAllId = streLighAllId;
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
        hash += (streLighAllId != null ? streLighAllId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof P1StreetLightsAll)) {
            return false;
        }
        P1StreetLightsAll other = (P1StreetLightsAll) object;
        if ((this.streLighAllId == null && other.streLighAllId != null) || (this.streLighAllId != null && !this.streLighAllId.equals(other.streLighAllId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.P1StreetLightsAll[ streLighAllId=" + streLighAllId + " ]";
    }
    
}
