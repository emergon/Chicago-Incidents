/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.P1StreetLightsAll;
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
public class P1StreetLightsAllFacade extends AbstractFacade<P1StreetLightsAll> {

    @PersistenceContext(unitName = "ChicagoIncidentsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public P1StreetLightsAllFacade() {
        super(P1StreetLightsAll.class);
    }
    
    public int getStreetLightsAllTotalCount() {
        Query query = em.createNamedQuery("P1StreetLightsAll.findTotalCount");
        return ((Long) query.getSingleResult()).intValue();
    }

    public List<P1StreetLightsAll> getStreetLightsAllList(int start, int size) {
        Query query = em.createNamedQuery("P1StreetLightsAll.findAll");
        query.setFirstResult(start);
        query.setMaxResults(size);
        List<P1StreetLightsAll> list = query.getResultList();
        return list;
    }
    
    public P1StreetLightsAll getRowData(int key){
        Query qr = em.createNamedQuery("P1StreetLightsAll.findByStreLighAllId");
        qr.setParameter("streLighAllId", key);
        return (P1StreetLightsAll)qr.getSingleResult();
    }
    
    public List<P1StreetLightsAll> getStreetLightsAllByXrhsth(P1Xrhsths xrhsths) {
        Query qr = em.createNativeQuery("select a.* from p1_Street_Lights_All a,"
                + " p1_incidents b where a.inci_kwd=b.inci_kwd and b.xrhs_kwd=:xrhsths", P1StreetLightsAll.class);
        qr.setParameter("xrhsths", xrhsths.getXrhsKwd());
        List<P1StreetLightsAll> list = qr.getResultList();
        return list;
    }

}
