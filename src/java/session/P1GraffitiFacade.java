/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.P1Graffiti;
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
public class P1GraffitiFacade extends AbstractFacade<P1Graffiti> {

    @PersistenceContext(unitName = "ChicagoIncidentsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public P1GraffitiFacade() {
        super(P1Graffiti.class);
    }
    
    public int getGraffitiTotalCount() {
        Query query = em.createNamedQuery("P1Graffiti.findTotalCount");
        return ((Long) query.getSingleResult()).intValue();
    }

    public List<P1Graffiti> getGraffitiList(int start, int size) {
        Query query = em.createNamedQuery("P1Graffiti.findAll");
        query.setFirstResult(start);
        query.setMaxResults(size);
        List<P1Graffiti> list = query.getResultList();
        return list;
    }
    
    public P1Graffiti getRowData(int key){
        Query qr = em.createNamedQuery("P1Graffiti.findByGrafId");
        qr.setParameter("grafId", key);
        return (P1Graffiti)qr.getSingleResult();
    }

    public P1Graffiti getGraffitiByInciKwd(P1Incidents incident){
        Query qr = em.createNativeQuery("Select * from p1_graffiti where inci_kwd = :inciKwd ", P1Graffiti.class);
        qr.setParameter("inciKwd", incident.getInciKwd());
        P1Graffiti v = (P1Graffiti) qr.getSingleResult();
        return v;
    }
    
    public List<P1Graffiti> getGraffitiByXrhsth(P1Xrhsths xrhsths) {
        Query qr = em.createNativeQuery("select a.* from p1_graffiti a,"
                + " p1_incidents b where a.inci_kwd=b.inci_kwd and b.xrhs_kwd=:xrhsths", P1Graffiti.class);
        qr.setParameter("xrhsths", xrhsths.getXrhsKwd());
        List<P1Graffiti> list = qr.getResultList();
        return list;
    }
    
}
