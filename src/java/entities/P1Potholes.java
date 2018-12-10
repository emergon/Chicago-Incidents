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
@Table(name = "p1_potholes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "P1Potholes.findAll", query = "SELECT p FROM P1Potholes p")
    , @NamedQuery(name = "P1Potholes.findTotalCount", query = "SELECT count(p.pothId) FROM P1Potholes p")
    , @NamedQuery(name = "P1Potholes.findByPothId", query = "SELECT p FROM P1Potholes p WHERE p.pothId = :pothId")
    , @NamedQuery(name = "P1Potholes.findByPothFilled", query = "SELECT p FROM P1Potholes p WHERE p.pothFilled = :pothFilled")
    , @NamedQuery(name = "P1Potholes.findByPothSsa", query = "SELECT p FROM P1Potholes p WHERE p.pothSsa = :pothSsa")})
public class P1Potholes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "poth_id")
    private Integer pothId;
    @Column(name = "poth_filled")
    private Short pothFilled;
    @Column(name = "poth_ssa")
    private Short pothSsa;
    @JoinColumn(name = "poth_activity", referencedColumnName = "curr_acti_id")
    @ManyToOne
    private P1CurrentActivity pothActivity;
    @JoinColumn(name = "inci_kwd", referencedColumnName = "inci_kwd")
    @ManyToOne
    private P1Incidents inciKwd;
    @JoinColumn(name = "poth_recent_action", referencedColumnName = "rece_acti_id")
    @ManyToOne
    private P1RecentAction pothRecentAction;

    public P1Potholes() {
    }

    public P1Potholes(Integer pothId) {
        this.pothId = pothId;
    }

    public Integer getPothId() {
        return pothId;
    }

    public void setPothId(Integer pothId) {
        this.pothId = pothId;
    }

    public Short getPothFilled() {
        return pothFilled;
    }

    public void setPothFilled(Short pothFilled) {
        this.pothFilled = pothFilled;
    }

    public Short getPothSsa() {
        return pothSsa;
    }

    public void setPothSsa(Short pothSsa) {
        this.pothSsa = pothSsa;
    }

    public P1CurrentActivity getPothActivity() {
        return pothActivity;
    }

    public void setPothActivity(P1CurrentActivity pothActivity) {
        this.pothActivity = pothActivity;
    }

    public P1Incidents getInciKwd() {
        return inciKwd;
    }

    public void setInciKwd(P1Incidents inciKwd) {
        this.inciKwd = inciKwd;
    }

    public P1RecentAction getPothRecentAction() {
        return pothRecentAction;
    }

    public void setPothRecentAction(P1RecentAction pothRecentAction) {
        this.pothRecentAction = pothRecentAction;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pothId != null ? pothId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof P1Potholes)) {
            return false;
        }
        P1Potholes other = (P1Potholes) object;
        if ((this.pothId == null && other.pothId != null) || (this.pothId != null && !this.pothId.equals(other.pothId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.P1Potholes[ pothId=" + pothId + " ]";
    }
    
}
