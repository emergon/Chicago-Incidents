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
@Table(name = "p1_tree_debris")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "P1TreeDebris.findAll", query = "SELECT p FROM P1TreeDebris p")
    , @NamedQuery(name = "P1TreeDebris.findTotalCount", query = "SELECT count(p.treeDebrId) FROM P1TreeDebris p")
    , @NamedQuery(name = "P1TreeDebris.findByTreeDebrId", query = "SELECT p FROM P1TreeDebris p WHERE p.treeDebrId = :treeDebrId")
    , @NamedQuery(name = "P1TreeDebris.findByTreeDebrLocation", query = "SELECT p FROM P1TreeDebris p WHERE p.treeDebrLocation = :treeDebrLocation")
    , @NamedQuery(name = "P1TreeDebris.findByTreeDebrActivity", query = "SELECT p FROM P1TreeDebris p WHERE p.treeDebrActivity = :treeDebrActivity")
    , @NamedQuery(name = "P1TreeDebris.findByTreeDebrRecentAction", query = "SELECT p FROM P1TreeDebris p WHERE p.treeDebrRecentAction = :treeDebrRecentAction")})
public class P1TreeDebris implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tree_debr_id")
    private Integer treeDebrId;
    //@Size(max = 50)
    @Column(name = "tree_debr_location")
    private String treeDebrLocation;
    //@Size(max = 100)
    @Column(name = "tree_debr_activity")
    private String treeDebrActivity;
    //@Size(max = 100)
    @Column(name = "tree_debr_recent_action")
    private String treeDebrRecentAction;
    @JoinColumn(name = "inci_kwd", referencedColumnName = "inci_kwd")
    @ManyToOne
    private P1Incidents inciKwd;

    public P1TreeDebris() {
    }

    public P1TreeDebris(Integer treeDebrId) {
        this.treeDebrId = treeDebrId;
    }

    public Integer getTreeDebrId() {
        return treeDebrId;
    }

    public void setTreeDebrId(Integer treeDebrId) {
        this.treeDebrId = treeDebrId;
    }

    public String getTreeDebrLocation() {
        return treeDebrLocation;
    }

    public void setTreeDebrLocation(String treeDebrLocation) {
        this.treeDebrLocation = treeDebrLocation;
    }

    public String getTreeDebrActivity() {
        return treeDebrActivity;
    }

    public void setTreeDebrActivity(String treeDebrActivity) {
        this.treeDebrActivity = treeDebrActivity;
    }

    public String getTreeDebrRecentAction() {
        return treeDebrRecentAction;
    }

    public void setTreeDebrRecentAction(String treeDebrRecentAction) {
        this.treeDebrRecentAction = treeDebrRecentAction;
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
        hash += (treeDebrId != null ? treeDebrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof P1TreeDebris)) {
            return false;
        }
        P1TreeDebris other = (P1TreeDebris) object;
        if ((this.treeDebrId == null && other.treeDebrId != null) || (this.treeDebrId != null && !this.treeDebrId.equals(other.treeDebrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.P1TreeDebris[ treeDebrId=" + treeDebrId + " ]";
    }
    
}
