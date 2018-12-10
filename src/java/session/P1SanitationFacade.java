/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.P1Sanitation;
import entities.P1Incidents;
import entities.P1Sanitation;
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
public class P1SanitationFacade extends AbstractFacade<P1Sanitation> {

    @PersistenceContext(unitName = "ChicagoIncidentsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public P1SanitationFacade() {
        super(P1Sanitation.class);
    }
    
    public int getSanitationTotalCount() {
        Query query = em.createNamedQuery("P1Sanitation.findTotalCount");
        return ((Long) query.getSingleResult()).intValue();
    }

    public List<P1Sanitation> getSanitationList(int start, int size) {
        Query query = em.createNamedQuery("P1Sanitation.findAll");
        query.setFirstResult(start);
        query.setMaxResults(size);
        List<P1Sanitation> list = query.getResultList();
        return list;
    }
    
    public P1Sanitation getRowData(int key){
        Query qr = em.createNamedQuery("P1Sanitation.findBySaniId");
        qr.setParameter("saniId", key);
        return (P1Sanitation)qr.getSingleResult();
    }
    
    public P1Sanitation getSanitationByInciKwd(P1Incidents incident){
        Query qr = em.createNativeQuery("Select * from p1_sanitation where inci_kwd = :inciKwd ", P1Sanitation.class);
        qr.setParameter("inciKwd", incident.getInciKwd());
        P1Sanitation v = (P1Sanitation) qr.getSingleResult();
        return v;
    }
    
    public List<P1Sanitation> getSanitationByXrhsth(P1Xrhsths xrhsths) {
        Query qr = em.createNativeQuery("select a.* from p1_sanitation a,"
                + " p1_incidents b where a.inci_kwd=b.inci_kwd and b.xrhs_kwd=:xrhsths", P1Sanitation.class);
        qr.setParameter("xrhsths", xrhsths.getXrhsKwd());
        List<P1Sanitation> list = qr.getResultList();
        return list;
    }

}
