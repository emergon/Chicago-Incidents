/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.P1Incidents;
import entities.P1Potholes;
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
public class P1PotholesFacade extends AbstractFacade<P1Potholes> {

    @PersistenceContext(unitName = "ChicagoIncidentsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public P1PotholesFacade() {
        super(P1Potholes.class);
    }
    
    public int getPotholesTotalCount() {
        Query query = em.createNamedQuery("P1Potholes.findTotalCount");
        return ((Long) query.getSingleResult()).intValue();
    }

    public List<P1Potholes> getPotholesList(int start, int size) {
        Query query = em.createNamedQuery("P1Potholes.findAll");
        query.setFirstResult(start);
        query.setMaxResults(size);
        List<P1Potholes> list = query.getResultList();
        return list;
    }
    
    public P1Potholes getRowData(int key){
        Query qr = em.createNamedQuery("P1Potholes.findByPothId");
        qr.setParameter("pothId", key);
        return (P1Potholes)qr.getSingleResult();
    }
    
    public P1Potholes getPotholesByInciKwd(P1Incidents incident){
        Query qr = em.createNativeQuery("Select * from p1_potholes where inci_kwd = :inciKwd ", P1Potholes.class);
        qr.setParameter("inciKwd", incident.getInciKwd());
        P1Potholes v = (P1Potholes) qr.getSingleResult();
        return v;
    }
    
    public List<P1Potholes> getPotholesByXrhsth(P1Xrhsths xrhsths) {
        Query qr = em.createNativeQuery("select a.* from p1_potholes a,"
                + " p1_incidents b where a.inci_kwd=b.inci_kwd and b.xrhs_kwd=:xrhsths", P1Potholes.class);
        qr.setParameter("xrhsths", xrhsths.getXrhsKwd());
        List<P1Potholes> list = qr.getResultList();
        return list;
    }

}
