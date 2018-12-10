/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.P1Xrhsths;
import java.util.ArrayList;
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
public class P1XrhsthsFacade extends AbstractFacade<P1Xrhsths> {

    @PersistenceContext(unitName = "ChicagoIncidentsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public P1XrhsthsFacade() {
        super(P1Xrhsths.class);
    }
    
    public List<String> getUsernames(){
        List<String> list = new ArrayList();
        Query qr = em.createNativeQuery("select xrhs_username from p1_xrhsths");
        list = qr.getResultList();
        //System.out.println("list ==== "+list);
        return list;
    }
    
}
