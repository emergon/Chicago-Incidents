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
@Table(name = "p1_alley_lights_out")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "P1AlleyLightsOut.findAll", query = "SELECT p FROM P1AlleyLightsOut p")
    , @NamedQuery(name = "P1AlleyLightsOut.findTotalCount", query = "SELECT count(p.alleLighId) FROM P1AlleyLightsOut p")
    , @NamedQuery(name = "P1AlleyLightsOut.findByAlleLighId", query = "SELECT p FROM P1AlleyLightsOut p WHERE p.alleLighId = :alleLighId")})
public class P1AlleyLightsOut implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "alle_ligh_id")
    private Integer alleLighId;
    @JoinColumn(name = "inci_kwd", referencedColumnName = "inci_kwd")
    @ManyToOne
    private P1Incidents inciKwd;

    public P1AlleyLightsOut() {
    }

    public P1AlleyLightsOut(Integer alleLighId) {
        this.alleLighId = alleLighId;
    }

    public Integer getAlleLighId() {
        return alleLighId;
    }

    public void setAlleLighId(Integer alleLighId) {
        this.alleLighId = alleLighId;
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
        hash += (alleLighId != null ? alleLighId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof P1AlleyLightsOut)) {
            return false;
        }
        P1AlleyLightsOut other = (P1AlleyLightsOut) object;
        if ((this.alleLighId == null && other.alleLighId != null) || (this.alleLighId != null && !this.alleLighId.equals(other.alleLighId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.P1AlleyLightsOut[ alleLighId=" + alleLighId + " ]";
    }
    
}
