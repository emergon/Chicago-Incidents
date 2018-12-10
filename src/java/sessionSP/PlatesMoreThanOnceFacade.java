/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionSP;

import entities.P1Incidents;
import entitiesSP.PlatesMoreThanOnce;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import session.AbstractFacade;

/**
 *
 * @author anastasios
 */
@Stateless
public class PlatesMoreThanOnceFacade extends AbstractFacade<PlatesMoreThanOnce>  {
    @PersistenceContext(unitName = "ChicagoIncidentsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlatesMoreThanOnceFacade() {
        super(PlatesMoreThanOnce.class);
    }
    
    /////START OF LAZY MODEL METHODS
    public int getPlatesMoreThanOnceCount() {
        Query query = em.createNativeQuery("select count(*) from platesmorethanonce()");
        //System.out.println("================"+((BigInteger) query.getSingleResult()).intValue());
        return ((BigInteger) query.getSingleResult()).intValue();
    }

    public List<PlatesMoreThanOnce> getPlatesMoreThanOnceList(int start, int size) {
        Query query = em.createNativeQuery("select * from platesmorethanonce()");
        query.setFirstResult(start);
        query.setMaxResults(size);
        List<PlatesMoreThanOnce> list = query.getResultList();
        //System.out.println("++++++++++++++++"+list);
        return list;
    }

    public PlatesMoreThanOnce getRowData(String key) {
        Query qr = em.createNativeQuery("select * from platesmorethanonce() where plate = :plate");
        qr.setParameter("plate", key);
        //System.out.println("---------------------"+(PlatesMoreThanOnce) qr.getSingleResult());
        return (PlatesMoreThanOnce) qr.getSingleResult();
    }
/////ENDING OF LAZY MODEL METHODS   
    
    public List<PlatesMoreThanOnce> getPlatesMoreThanOnce() {
        StoredProcedureQuery spqr = em.createStoredProcedureQuery("platesMoreThanOnce", "PlatesMoreThanOnceMapping");
        List<PlatesMoreThanOnce> list = spqr.getResultList();
        return list;
    }
    
    
}
