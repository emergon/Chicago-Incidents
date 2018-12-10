/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.P1TreeTrims;
import entities.P1Incidents;
import entities.P1TreeTrims;
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
public class P1TreeTrimsFacade extends AbstractFacade<P1TreeTrims> {

    @PersistenceContext(unitName = "ChicagoIncidentsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public P1TreeTrimsFacade() {
        super(P1TreeTrims.class);
    }
    
    public int getTreeTrimsTotalCount() {
        Query query = em.createNamedQuery("P1TreeTrims.findTotalCount");
        return ((Long) query.getSingleResult()).intValue();
    }

    public List<P1TreeTrims> getTreeTrimsList(int start, int size) {
        Query query = em.createNamedQuery("P1TreeTrims.findAll");
        query.setFirstResult(start);
        query.setMaxResults(size);
        List<P1TreeTrims> list = query.getResultList();
        return list;
    }
    
    public P1TreeTrims getRowData(int key){
        Query qr = em.createNamedQuery("P1TreeTrims.findByTreeTrimId");
        qr.setParameter("treeTrimId", key);
        return (P1TreeTrims)qr.getSingleResult();
    }
    
    public P1TreeTrims getTreeTrimsByInciKwd(P1Incidents incident){
        Query qr = em.createNativeQuery("Select * from p1_tree_trims where inci_kwd = :inciKwd ", P1TreeTrims.class);
        qr.setParameter("inciKwd", incident.getInciKwd());
        P1TreeTrims v = (P1TreeTrims) qr.getSingleResult();
        return v;
    }
    
    public List<P1TreeTrims> getTreeTrimsByXrhsth(P1Xrhsths xrhsths) {
        Query qr = em.createNativeQuery("select a.* from p1_tree_trims a,"
                + " p1_incidents b where a.inci_kwd=b.inci_kwd and b.xrhs_kwd=:xrhsths", P1TreeTrims.class);
        qr.setParameter("xrhsths", xrhsths.getXrhsKwd());
        List<P1TreeTrims> list = qr.getResultList();
        return list;
    }

}
