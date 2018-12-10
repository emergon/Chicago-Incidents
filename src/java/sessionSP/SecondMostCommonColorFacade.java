/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionSP;

import entitiesSP.SecondMostCommonColor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import session.AbstractFacade;

/**
 *
 * @author anastasios
 */
@Stateless
public class SecondMostCommonColorFacade extends AbstractFacade<SecondMostCommonColor> {
    @PersistenceContext(unitName = "ChicagoIncidentsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SecondMostCommonColorFacade() {
        super(SecondMostCommonColor.class);
    }

    public List<SecondMostCommonColor> getSecondMostCommonColor(){
        StoredProcedureQuery spqr = em.createStoredProcedureQuery("secondMostCommonColor", "SecondMostCommonColorMapping");
        List<SecondMostCommonColor> list = spqr.getResultList();
        return list;
    }
}
