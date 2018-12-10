/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.P1AlleyLightsOut;
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
public class P1AlleyLightsOutFacade extends AbstractFacade<P1AlleyLightsOut> {

    @PersistenceContext(unitName = "ChicagoIncidentsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public P1AlleyLightsOutFacade() {
        super(P1AlleyLightsOut.class);
    }

    public int getAlleyLightsOutTotalCount() {
        Query query = em.createNamedQuery("P1AlleyLightsOut.findTotalCount");
        return ((Long) query.getSingleResult()).intValue();
    }

    public List<P1AlleyLightsOut> getAlleyLightsOutList(int start, int size) {
        Query query = em.createNamedQuery("P1AlleyLightsOut.findAll");
        query.setFirstResult(start);
        query.setMaxResults(size);
        List<P1AlleyLightsOut> list = query.getResultList();
        return list;
    }
    
    public P1AlleyLightsOut getRowData(int key){
        Query qr = em.createNamedQuery("P1AlleyLightsOut.findByAlleLighId");
        qr.setParameter("alleLighId", key);
        return (P1AlleyLightsOut)qr.getSingleResult();
    }
    
    public List<P1AlleyLightsOut> getAlleyLightsOutByXrhsth(P1Xrhsths xrhsths) {
        Query qr = em.createNativeQuery("select a.* from p1_Alley_Lights_Out a,"
                + " p1_incidents b where a.inci_kwd=b.inci_kwd and b.xrhs_kwd=:xrhsths", P1AlleyLightsOut.class);
        qr.setParameter("xrhsths", xrhsths.getXrhsKwd());
        List<P1AlleyLightsOut> list = qr.getResultList();
        return list;
    }
    
}
