/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author anastasios
 */
@Entity
@Table(name = "p1_xrhsths")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "P1Xrhsths.findAll", query = "SELECT p FROM P1Xrhsths p")
    , @NamedQuery(name = "P1Xrhsths.findByXrhsKwd", query = "SELECT p FROM P1Xrhsths p WHERE p.xrhsKwd = :xrhsKwd")
    , @NamedQuery(name = "P1Xrhsths.findByXrhsUsername", query = "SELECT p FROM P1Xrhsths p WHERE p.xrhsUsername = :xrhsUsername")
    , @NamedQuery(name = "P1Xrhsths.findByXrhsFname", query = "SELECT p FROM P1Xrhsths p WHERE p.xrhsFname = :xrhsFname")
    , @NamedQuery(name = "P1Xrhsths.findByXrhsLname", query = "SELECT p FROM P1Xrhsths p WHERE p.xrhsLname = :xrhsLname")
    , @NamedQuery(name = "P1Xrhsths.findByXrhsAddress", query = "SELECT p FROM P1Xrhsths p WHERE p.xrhsAddress = :xrhsAddress")
    , @NamedQuery(name = "P1Xrhsths.findByXrhsEmail", query = "SELECT p FROM P1Xrhsths p WHERE p.xrhsEmail = :xrhsEmail")
    , @NamedQuery(name = "P1Xrhsths.findByXrhsPassword", query = "SELECT p FROM P1Xrhsths p WHERE p.xrhsPassword = :xrhsPassword")
    , @NamedQuery(name = "P1Xrhsths.findByXrhsType", query = "SELECT p FROM P1Xrhsths p WHERE p.xrhsType = :xrhsType")})
public class P1Xrhsths implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "xrhs_kwd")
    private Short xrhsKwd;
    //@Size(max = 10)
    @Column(name = "xrhs_username")
    private String xrhsUsername;
    //@Size(max = 20)
    @Column(name = "xrhs_fname")
    private String xrhsFname;
    //@Size(max = 30)
    @Column(name = "xrhs_lname")
    private String xrhsLname;
    //@Size(max = 50)
    @Column(name = "xrhs_address")
    private String xrhsAddress;
    //@Size(max = 20)
    @Column(name = "xrhs_email")
    private String xrhsEmail;
    @Column(name = "xrhs_type")
    private Short xrhsType;
    @Column(name = "xrhs_password")
    private String xrhsPassword;
    @OneToMany(mappedBy = "xrhsKwd")
    private Collection<P1Incidents> p1IncidentsCollection;
    @OneToMany(mappedBy = "xrhsKwd")
    private Collection<P1XrhsthAction> p1XrhsthActionCollection;
    
    public P1Xrhsths() {
    }

    public P1Xrhsths(Short xrhsKwd) {
        this.xrhsKwd = xrhsKwd;
    }

    public Short getXrhsKwd() {
        return xrhsKwd;
    }

    public void setXrhsKwd(Short xrhsKwd) {
        this.xrhsKwd = xrhsKwd;
    }

    public String getXrhsUsername() {
        return xrhsUsername;
    }

    public void setXrhsUsername(String xrhsUsername) {
        this.xrhsUsername = xrhsUsername;
    }

    public String getXrhsFname() {
        return xrhsFname;
    }

    public void setXrhsFname(String xrhsFname) {
        this.xrhsFname = xrhsFname;
    }

    public String getXrhsLname() {
        return xrhsLname;
    }

    public void setXrhsLname(String xrhsLname) {
        this.xrhsLname = xrhsLname;
    }

    public String getXrhsAddress() {
        return xrhsAddress;
    }

    public void setXrhsAddress(String xrhsAddress) {
        this.xrhsAddress = xrhsAddress;
    }

    public String getXrhsEmail() {
        return xrhsEmail;
    }

    public void setXrhsEmail(String xrhsEmail) {
        this.xrhsEmail = xrhsEmail;
    }

    public Short getXrhsType() {
        return xrhsType;
    }

    public void setXrhsType(Short xrhsType) {
        this.xrhsType = xrhsType;
    }

    public String getXrhsPassword() {
        return xrhsPassword;
    }

    public void setXrhsPassword(String xrhsPassword) {
        this.xrhsPassword = xrhsPassword;
    }

    @XmlTransient
    public Collection<P1Incidents> getP1IncidentsCollection() {
        return p1IncidentsCollection;
    }

    public void setP1IncidentsCollection(Collection<P1Incidents> p1IncidentsCollection) {
        this.p1IncidentsCollection = p1IncidentsCollection;
    }
    
    @XmlTransient
    public Collection<P1XrhsthAction> getP1XrhsthActionCollection() {
        return p1XrhsthActionCollection;
    }

    public void setP1XrhsthActionCollection(Collection<P1XrhsthAction> p1XrhsthActionCollection) {
        this.p1XrhsthActionCollection = p1XrhsthActionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xrhsKwd != null ? xrhsKwd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof P1Xrhsths)) {
            return false;
        }
        P1Xrhsths other = (P1Xrhsths) object;
        if ((this.xrhsKwd == null && other.xrhsKwd != null) || (this.xrhsKwd != null && !this.xrhsKwd.equals(other.xrhsKwd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.P1Xrhsths[ xrhsKwd=" + xrhsKwd + " ]";
    }
    
}
