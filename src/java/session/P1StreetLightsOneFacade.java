/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.P1StreetLightsOne;
import entities.P1StreetLightsOne;
import entities.P1StreetLightsOne;
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
public class P1StreetLightsOneFacade extends AbstractFacade<P1StreetLightsOne> {

    @PersistenceContext(unitName = "ChicagoIncidentsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public P1StreetLightsOneFacade() {
        super(P1StreetLightsOne.class);
    }
    
    public int getStreetLightsOneTotalCount() {
        Query query = em.createNamedQuery("P1StreetLightsOne.findTotalCount");
        return ((Long) query.getSingleResult()).intValue();
    }

    public List<P1StreetLightsOne> getStreetLightsOneList(int start, int size) {
        Query query = em.createNamedQuery("P1StreetLightsOne.findAll");
        query.setFirstResult(start);
        query.setMaxResults(size);
        List<P1StreetLightsOne> list = query.getResultList();
        return list;
    }
    
    public P1StreetLightsOne getRowData(int key){
        Query qr = em.createNamedQuery("P1StreetLightsOne.findByStreLighOneId");
        qr.setParameter("streLighOneId", key);
        return (P1StreetLightsOne)qr.getSingleResult();
    }
    
    public List<P1StreetLightsOne> getStreetLightsOneByXrhsth(P1Xrhsths xrhsths) {
        Query qr = em.createNativeQuery("select a.* from p1_Street_Lights_One a,"
                + " p1_incidents b where a.inci_kwd=b.inci_kwd and b.xrhs_kwd=:xrhsths", P1StreetLightsOne.class);
        qr.setParameter("xrhsths", xrhsths.getXrhsKwd());
        List<P1StreetLightsOne> list = qr.getResultList();
        return list;
    }

}
