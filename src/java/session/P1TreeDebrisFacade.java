/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.P1TreeDebris;
import entities.P1Incidents;
import entities.P1TreeDebris;
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
public class P1TreeDebrisFacade extends AbstractFacade<P1TreeDebris> {

    @PersistenceContext(unitName = "ChicagoIncidentsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public P1TreeDebrisFacade() {
        super(P1TreeDebris.class);
    }
    
    public int getTreeDebrisTotalCount() {
        Query query = em.createNamedQuery("P1TreeDebris.findTotalCount");
        return ((Long) query.getSingleResult()).intValue();
    }

    public List<P1TreeDebris> getTreeDebrisList(int start, int size) {
        Query query = em.createNamedQuery("P1TreeDebris.findAll");
        query.setFirstResult(start);
        query.setMaxResults(size);
        List<P1TreeDebris> list = query.getResultList();
        return list;
    }
    
    public P1TreeDebris getRowData(int key){
        Query qr = em.createNamedQuery("P1TreeDebris.findByTreeDebrId");
        qr.setParameter("treeDebrId", key);
        return (P1TreeDebris)qr.getSingleResult();
    }
    
    public P1TreeDebris getTreeDebrisByInciKwd(P1Incidents incident){
        Query qr = em.createNativeQuery("Select * from p1_tree_debris where inci_kwd = :inciKwd ", P1TreeDebris.class);
        qr.setParameter("inciKwd", incident.getInciKwd());
        P1TreeDebris v = (P1TreeDebris) qr.getSingleResult();
        return v;
    }
    
    public List<P1TreeDebris> getTreeDebrisByXrhsth(P1Xrhsths xrhsths) {
        Query qr = em.createNativeQuery("select a.* from p1_tree_debris a,"
                + " p1_incidents b where a.inci_kwd=b.inci_kwd and b.xrhs_kwd=:xrhsths", P1TreeDebris.class);
        qr.setParameter("xrhsths", xrhsths.getXrhsKwd());
        List<P1TreeDebris> list = qr.getResultList();
        return list;
    }

}
