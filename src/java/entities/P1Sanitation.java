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
@Table(name = "p1_sanitation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "P1Sanitation.findAll", query = "SELECT p FROM P1Sanitation p")
    , @NamedQuery(name = "P1Sanitation.findTotalCount", query = "SELECT count(p.saniId) FROM P1Sanitation p")
    , @NamedQuery(name = "P1Sanitation.findBySaniId", query = "SELECT p FROM P1Sanitation p WHERE p.saniId = :saniId")
    , @NamedQuery(name = "P1Sanitation.findBySaniNature", query = "SELECT p FROM P1Sanitation p WHERE p.saniNature = :saniNature")})
public class P1Sanitation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sani_id")
    private Integer saniId;
    //@Size(max = 50)
    @Column(name = "sani_nature")
    private String saniNature;
    @JoinColumn(name = "inci_kwd", referencedColumnName = "inci_kwd")
    @ManyToOne
    private P1Incidents inciKwd;

    public P1Sanitation() {
    }

    public P1Sanitation(Integer saniId) {
        this.saniId = saniId;
    }

    public Integer getSaniId() {
        return saniId;
    }

    public void setSaniId(Integer saniId) {
        this.saniId = saniId;
    }

    public String getSaniNature() {
        return saniNature;
    }

    public void setSaniNature(String saniNature) {
        this.saniNature = saniNature;
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
        hash += (saniId != null ? saniId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof P1Sanitation)) {
            return false;
        }
        P1Sanitation other = (P1Sanitation) object;
        if ((this.saniId == null && other.saniId != null) || (this.saniId != null && !this.saniId.equals(other.saniId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.P1Sanitation[ saniId=" + saniId + " ]";
    }
    
}
