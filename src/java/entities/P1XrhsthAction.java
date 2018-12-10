/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anastasios
 */
@Entity
@Table(name = "p1_xrhsth_action")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "P1XrhsthAction.findAll", query = "SELECT p FROM P1XrhsthAction p")
    , @NamedQuery(name = "P1XrhsthAction.findByXrhsActiKwd", query = "SELECT p FROM P1XrhsthAction p WHERE p.xrhsActiKwd = :xrhsActiKwd")
    , @NamedQuery(name = "P1XrhsthAction.findByXrhsActiPerigrafh", query = "SELECT p FROM P1XrhsthAction p WHERE p.xrhsActiPerigrafh = :xrhsActiPerigrafh")
    , @NamedQuery(name = "P1XrhsthAction.findByXrhsActiTime", query = "SELECT p FROM P1XrhsthAction p WHERE p.xrhsActiTime = :xrhsActiTime")})
public class P1XrhsthAction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "xrhs_acti_kwd")
    private Integer xrhsActiKwd;
    //@Size(max = 2147483647)
    @Column(name = "xrhs_acti_perigrafh")
    private String xrhsActiPerigrafh;
    @Column(name = "xrhs_acti_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date xrhsActiTime;
    @JoinColumn(name = "xrhs_kwd", referencedColumnName = "xrhs_kwd")
    @ManyToOne
    private P1Xrhsths xrhsKwd;
    
    public P1XrhsthAction() {
    }

    public P1XrhsthAction(Integer xrhsActiKwd) {
        this.xrhsActiKwd = xrhsActiKwd;
    }

    public Integer getXrhsActiKwd() {
        return xrhsActiKwd;
    }

    public void setXrhsActiKwd(Integer xrhsActiKwd) {
        this.xrhsActiKwd = xrhsActiKwd;
    }

    public String getXrhsActiPerigrafh() {
        return xrhsActiPerigrafh;
    }

    public void setXrhsActiPerigrafh(String xrhsActiPerigrafh) {
        this.xrhsActiPerigrafh = xrhsActiPerigrafh;
    }

    public Date getXrhsActiTime() {
        return xrhsActiTime;
    }

    public void setXrhsActiTime(Date xrhsActiTime) {
        this.xrhsActiTime = xrhsActiTime;
    }

    public P1Xrhsths getXrhsKwd() {
        return xrhsKwd;
    }

    public void setXrhsKwd(P1Xrhsths xrhsKwd) {
        this.xrhsKwd = xrhsKwd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xrhsActiKwd != null ? xrhsActiKwd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof P1XrhsthAction)) {
            return false;
        }
        P1XrhsthAction other = (P1XrhsthAction) object;
        if ((this.xrhsActiKwd == null && other.xrhsActiKwd != null) || (this.xrhsActiKwd != null && !this.xrhsActiKwd.equals(other.xrhsActiKwd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.P1XrhsthAction[ xrhsActiKwd=" + xrhsActiKwd + " ]";
    }
    
}
