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
@Table(name = "p1_garbage_cart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "P1GarbageCart.findAll", query = "SELECT p FROM P1GarbageCart p")
    , @NamedQuery(name = "P1GarbageCart.findTotalCount", query = "SELECT count(p.garbCartId) FROM P1GarbageCart p")
    , @NamedQuery(name = "P1GarbageCart.findByGarbCartId", query = "SELECT p FROM P1GarbageCart p WHERE p.garbCartId = :garbCartId")
    , @NamedQuery(name = "P1GarbageCart.findByGarbCartDelivered", query = "SELECT p FROM P1GarbageCart p WHERE p.garbCartDelivered = :garbCartDelivered")
    , @NamedQuery(name = "P1GarbageCart.findByGarbCartSsa", query = "SELECT p FROM P1GarbageCart p WHERE p.garbCartSsa = :garbCartSsa")})
public class P1GarbageCart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "garb_cart_id")
    private Integer garbCartId;
    @Column(name = "garb_cart_delivered")
    private Integer garbCartDelivered;
    @Column(name = "garb_cart_ssa")
    private Short garbCartSsa;
    @JoinColumn(name = "garb_cart_activity", referencedColumnName = "curr_acti_id")
    @ManyToOne
    private P1CurrentActivity garbCartActivity;
    @JoinColumn(name = "inci_kwd", referencedColumnName = "inci_kwd")
    @ManyToOne
    private P1Incidents inciKwd;
    @JoinColumn(name = "garb_cart_recent_action", referencedColumnName = "rece_acti_id")
    @ManyToOne
    private P1RecentAction garbCartRecentAction;

    public P1GarbageCart() {
    }

    public P1GarbageCart(Integer garbCartId) {
        this.garbCartId = garbCartId;
    }

    public Integer getGarbCartId() {
        return garbCartId;
    }

    public void setGarbCartId(Integer garbCartId) {
        this.garbCartId = garbCartId;
    }

    public Integer getGarbCartDelivered() {
        return garbCartDelivered;
    }

    public void setGarbCartDelivered(Integer garbCartDelivered) {
        this.garbCartDelivered = garbCartDelivered;
    }

    public Short getGarbCartSsa() {
        return garbCartSsa;
    }

    public void setGarbCartSsa(Short garbCartSsa) {
        this.garbCartSsa = garbCartSsa;
    }

    public P1CurrentActivity getGarbCartActivity() {
        return garbCartActivity;
    }

    public void setGarbCartActivity(P1CurrentActivity garbCartActivity) {
        this.garbCartActivity = garbCartActivity;
    }

    public P1Incidents getInciKwd() {
        return inciKwd;
    }

    public void setInciKwd(P1Incidents inciKwd) {
        this.inciKwd = inciKwd;
    }

    public P1RecentAction getGarbCartRecentAction() {
        return garbCartRecentAction;
    }

    public void setGarbCartRecentAction(P1RecentAction garbCartRecentAction) {
        this.garbCartRecentAction = garbCartRecentAction;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (garbCartId != null ? garbCartId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof P1GarbageCart)) {
            return false;
        }
        P1GarbageCart other = (P1GarbageCart) object;
        if ((this.garbCartId == null && other.garbCartId != null) || (this.garbCartId != null && !this.garbCartId.equals(other.garbCartId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.P1GarbageCart[ garbCartId=" + garbCartId + " ]";
    }
    
}
