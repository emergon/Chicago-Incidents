/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.P1AbandonedVehicle;
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
public class P1AbandonedVehicleFacade extends AbstractFacade<P1AbandonedVehicle> {

    @PersistenceContext(unitName = "ChicagoIncidentsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public P1AbandonedVehicleFacade() {
        super(P1AbandonedVehicle.class);
    }

    public int getAbandonedVehicleTotalCount() {
        Query query = em.createNamedQuery("P1AbandonedVehicle.findTotalCount");
        return ((Long) query.getSingleResult()).intValue();
    }

    public List<P1AbandonedVehicle> getAbandonedVehicleList(int start, int size) {
        Query query = em.createNamedQuery("P1AbandonedVehicle.findAll");
        query.setFirstResult(start);
        query.setMaxResults(size);
        List<P1AbandonedVehicle> list = query.getResultList();
        return list;
    }

    public P1AbandonedVehicle getRowData(int key) {
        Query qr = em.createNamedQuery("P1AbandonedVehicle.findByAbanVehiId");
        qr.setParameter("abanVehiId", key);
        return (P1AbandonedVehicle) qr.getSingleResult();
    }

    public P1AbandonedVehicle getAbandonedVehicleByInciKwd(P1Incidents incident) {
        Query qr = em.createNativeQuery("Select * from p1_abandoned_vehicle where inci_kwd = :inciKwd ", P1AbandonedVehicle.class);
        qr.setParameter("inciKwd", incident.getInciKwd());
        P1AbandonedVehicle v = (P1AbandonedVehicle) qr.getSingleResult();
        return v;
    }

    public List<P1AbandonedVehicle> getAbandonedVehicleByXrhsth(P1Xrhsths xrhsths) {
        Query qr = em.createNativeQuery("select a.* from p1_abandoned_vehicle a,"
                + " p1_incidents b where a.inci_kwd=b.inci_kwd and b.xrhs_kwd=:xrhsths", P1AbandonedVehicle.class);
        qr.setParameter("xrhsths", xrhsths.getXrhsKwd());
        List<P1AbandonedVehicle> list = qr.getResultList();
        return list;
    }

}
