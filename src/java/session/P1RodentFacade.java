/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.P1Rodent;
import entities.P1Incidents;
import entities.P1Rodent;
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
public class P1RodentFacade extends AbstractFacade<P1Rodent> {

    @PersistenceContext(unitName = "ChicagoIncidentsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public P1RodentFacade() {
        super(P1Rodent.class);
    }
    ///START OF LAZY MODEL
    public int getRodentTotalCount() {
        Query query = em.createNamedQuery("P1Rodent.findTotalCount");
        return ((Long) query.getSingleResult()).intValue();
    }

    public List<P1Rodent> getRodentList(int start, int size) {
        Query query = em.createNamedQuery("P1Rodent.findAll");
        query.setFirstResult(start);
        query.setMaxResults(size);
        List<P1Rodent> list = query.getResultList();
        return list;
    }
    
    public P1Rodent getRowData(int key){
        Query qr = em.createNamedQuery("P1Rodent.findByRodeId");
        qr.setParameter("rodeId", key);
        return (P1Rodent)qr.getSingleResult();
    }
    //END OF LAZY MODEL
    
//    public List<P1Rodent> getRodentPremisesBaited(int arithmos, int start, int size){
//        StoredProcedureQuery spqr = em.createStoredProcedureQuery("rodentPremisesBaited",P1Rodent.class);
//        spqr.registerStoredProcedureParameter("arithmos", Integer.class, ParameterMode.IN);
//        spqr.setFirstResult(start);
//        spqr.setMaxResults(size);
//        spqr.setParameter("arithmos", arithmos);
//        System.out.println("arithmos="+arithmos+", start="+start+", size"+size);
//        List<P1Rodent> list = spqr.getResultList();
//        System.out.println("after list---------------------");
//        return list;
//    }
//     public int getRodentPremisesBaitedTotalCount(int arithmos) {
//        Query query = em.createNativeQuery("select count(*) from rodentPremisesBaited(:arithmos)");
//        query.setParameter("arithmos", arithmos);
//         System.out.println("query====="+query.toString());
//        return ((BigInteger) query.getSingleResult()).intValue();
//    }
    
    public P1Rodent getRodentByInciKwd(P1Incidents incident){
        Query qr = em.createNativeQuery("Select * from p1_rodent where inci_kwd = :inciKwd ", P1Rodent.class);
        qr.setParameter("inciKwd", incident.getInciKwd());
        P1Rodent v = (P1Rodent) qr.getSingleResult();
        return v;
    }

    public List<P1Rodent> getRodentByXrhsth(P1Xrhsths xrhsths) {
        Query qr = em.createNativeQuery("select a.* from p1_rodent a,"
                + " p1_incidents b where a.inci_kwd=b.inci_kwd and b.xrhs_kwd=:xrhsths", P1Rodent.class);
        qr.setParameter("xrhsths", xrhsths.getXrhsKwd());
        List<P1Rodent> list = qr.getResultList();
        return list;
    }
}
