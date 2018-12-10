/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.P1CurrentActivity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author anastasios
 */
@Stateless
public class P1CurrentActivityFacade extends AbstractFacade<P1CurrentActivity> {

    @PersistenceContext(unitName = "ChicagoIncidentsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public P1CurrentActivityFacade() {
        super(P1CurrentActivity.class);
    }
    
}
