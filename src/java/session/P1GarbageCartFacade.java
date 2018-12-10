/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.P1GarbageCart;
import entities.P1Incidents;
import entities.P1Xrhsths;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author anastasios
 */
@Stateless
public class P1GarbageCartFacade extends AbstractFacade<P1GarbageCart> {

    @PersistenceContext(unitName = "ChicagoIncidentsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public P1GarbageCartFacade() {
        super(P1GarbageCart.class);
    }
 
    public int getGarbageCartTotalCount() {
        Query query = em.createNamedQuery("P1GarbageCart.findTotalCount");
        return ((Long) query.getSingleResult()).intValue();
    }

    public List<P1GarbageCart> getGarbageCartList(int start, int size) {
        Query query = em.createNamedQuery("P1GarbageCart.findAll");
        query.setFirstResult(start);
        query.setMaxResults(size);
        List<P1GarbageCart> list = query.getResultList();
        return list;
    }
    
    public P1GarbageCart getRowData(int key){
        Query qr = em.createNamedQuery("P1GarbageCart.findByGarbCartId");
        qr.setParameter("garbCartId", key);
        return (P1GarbageCart)qr.getSingleResult();
    }
    
    public P1GarbageCart getGarbageCartByInciKwd(P1Incidents incident){
        Query qr = em.createNativeQuery("Select * from p1_garbage_cart where inci_kwd = :inciKwd ", P1GarbageCart.class);
        qr.setParameter("inciKwd", incident.getInciKwd());
        P1GarbageCart v = (P1GarbageCart) qr.getSingleResult();
        return v;
    }
    
    public List<P1GarbageCart> getGarbageCartByXrhsth(P1Xrhsths xrhsths) {
        Query qr = em.createNativeQuery("select a.* from p1_garbage_cart a,"
                + " p1_incidents b where a.inci_kwd=b.inci_kwd and b.xrhs_kwd=:xrhsths", P1GarbageCart.class);
        qr.setParameter("xrhsths", xrhsths.getXrhsKwd());
        List<P1GarbageCart> list = qr.getResultList();
        return list;
    }
   
}
