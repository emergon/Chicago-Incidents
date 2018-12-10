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
@Table(name = "p1_tree_trims")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "P1TreeTrims.findAll", query = "SELECT p FROM P1TreeTrims p")
    , @NamedQuery(name = "P1TreeTrims.findTotalCount", query = "SELECT count(p.treeTrimId) FROM P1TreeTrims p")
    , @NamedQuery(name = "P1TreeTrims.findByTreeTrimId", query = "SELECT p FROM P1TreeTrims p WHERE p.treeTrimId = :treeTrimId")
    , @NamedQuery(name = "P1TreeTrims.findByTreeTrimLocation", query = "SELECT p FROM P1TreeTrims p WHERE p.treeTrimLocation = :treeTrimLocation")})
public class P1TreeTrims implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tree_trim_id")
    private Integer treeTrimId;
    //@Size(max = 50)
    @Column(name = "tree_trim_location")
    private String treeTrimLocation;
    @JoinColumn(name = "inci_kwd", referencedColumnName = "inci_kwd")
    @ManyToOne
    private P1Incidents inciKwd;

    public P1TreeTrims() {
    }

    public P1TreeTrims(Integer treeTrimId) {
        this.treeTrimId = treeTrimId;
    }

    public Integer getTreeTrimId() {
        return treeTrimId;
    }

    public void setTreeTrimId(Integer treeTrimId) {
        this.treeTrimId = treeTrimId;
    }

    public String getTreeTrimLocation() {
        return treeTrimLocation;
    }

    public void setTreeTrimLocation(String treeTrimLocation) {
        this.treeTrimLocation = treeTrimLocation;
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
        hash += (treeTrimId != null ? treeTrimId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof P1TreeTrims)) {
            return false;
        }
        P1TreeTrims other = (P1TreeTrims) object;
        if ((this.treeTrimId == null && other.treeTrimId != null) || (this.treeTrimId != null && !this.treeTrimId.equals(other.treeTrimId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.P1TreeTrims[ treeTrimId=" + treeTrimId + " ]";
    }
    
}
