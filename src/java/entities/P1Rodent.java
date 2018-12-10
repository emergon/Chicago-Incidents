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
@Table(name = "p1_rodent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "P1Rodent.findAll", query = "SELECT p FROM P1Rodent p")
    , @NamedQuery(name = "P1Rodent.findTotalCount", query = "SELECT count(p.rodeId) FROM P1Rodent p")
    , @NamedQuery(name = "P1Rodent.findByRodeId", query = "SELECT p FROM P1Rodent p WHERE p.rodeId = :rodeId")
    , @NamedQuery(name = "P1Rodent.findByRodePremisesBaited", query = "SELECT p FROM P1Rodent p WHERE p.rodePremisesBaited = :rodePremisesBaited")
    , @NamedQuery(name = "P1Rodent.findByRodePremisesGarbaged", query = "SELECT p FROM P1Rodent p WHERE p.rodePremisesGarbaged = :rodePremisesGarbaged")
    , @NamedQuery(name = "P1Rodent.findByRodePremisesRats", query = "SELECT p FROM P1Rodent p WHERE p.rodePremisesRats = :rodePremisesRats")})
public class P1Rodent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rode_id")
    private Integer rodeId;
    @Column(name = "rode_premises_baited")
    private Short rodePremisesBaited;
    @Column(name = "rode_premises_garbaged")
    private Short rodePremisesGarbaged;
    @Column(name = "rode_premises_rats")
    private Short rodePremisesRats;
    @JoinColumn(name = "rode_activity", referencedColumnName = "curr_acti_id")
    @ManyToOne
    private P1CurrentActivity rodeActivity;
    @JoinColumn(name = "inci_kwd", referencedColumnName = "inci_kwd")
    @ManyToOne
    private P1Incidents inciKwd;
    @JoinColumn(name = "rode_recent_action", referencedColumnName = "rece_acti_id")
    @ManyToOne
    private P1RecentAction rodeRecentAction;

    public P1Rodent() {
    }

    public P1Rodent(Integer rodeId) {
        this.rodeId = rodeId;
    }

    public Integer getRodeId() {
        return rodeId;
    }

    public void setRodeId(Integer rodeId) {
        this.rodeId = rodeId;
    }

    public Short getRodePremisesBaited() {
        return rodePremisesBaited;
    }

    public void setRodePremisesBaited(Short rodePremisesBaited) {
        this.rodePremisesBaited = rodePremisesBaited;
    }

    public Short getRodePremisesGarbaged() {
        return rodePremisesGarbaged;
    }

    public void setRodePremisesGarbaged(Short rodePremisesGarbaged) {
        this.rodePremisesGarbaged = rodePremisesGarbaged;
    }

    public Short getRodePremisesRats() {
        return rodePremisesRats;
    }

    public void setRodePremisesRats(Short rodePremisesRats) {
        this.rodePremisesRats = rodePremisesRats;
    }

    public P1CurrentActivity getRodeActivity() {
        return rodeActivity;
    }

    public void setRodeActivity(P1CurrentActivity rodeActivity) {
        this.rodeActivity = rodeActivity;
    }

    public P1Incidents getInciKwd() {
        return inciKwd;
    }

    public void setInciKwd(P1Incidents inciKwd) {
        this.inciKwd = inciKwd;
    }

    public P1RecentAction getRodeRecentAction() {
        return rodeRecentAction;
    }

    public void setRodeRecentAction(P1RecentAction rodeRecentAction) {
        this.rodeRecentAction = rodeRecentAction;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rodeId != null ? rodeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof P1Rodent)) {
            return false;
        }
        P1Rodent other = (P1Rodent) object;
        if ((this.rodeId == null && other.rodeId != null) || (this.rodeId != null && !this.rodeId.equals(other.rodeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.P1Rodent[ rodeId=" + rodeId + " ]";
    }
    
}
