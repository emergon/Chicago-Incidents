/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionSP;

import entitiesSP.RequestPerType;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import session.AbstractFacade;

/**
 *
 * @author anastasios
 */
@Stateless
public class RequestPerTypeFacade extends AbstractFacade<RequestPerType>  {
    @PersistenceContext(unitName = "ChicagoIncidentsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RequestPerTypeFacade() {
        super(RequestPerType.class);
    }
    
    public List<RequestPerType> getTotalRequestsPerTypeByDateRange(Date dateFrom, Date dateTo) {
        StoredProcedureQuery spqr = em.createStoredProcedureQuery("totalRequestsPerTypeByRange", "RequestPerTypeMapping");
        spqr.registerStoredProcedureParameter("dateFrom", Date.class, ParameterMode.IN);
        spqr.registerStoredProcedureParameter("dateTo", Date.class, ParameterMode.IN);
        spqr.setParameter("dateFrom", dateFrom);
        spqr.setParameter("dateTo", dateTo);
        List<RequestPerType> list = spqr.getResultList();
        return list;
    }
    
    public List<RequestPerType> getAvgCompletionTimePerTypeByDateRange(Date dateFrom, Date dateTo) {
        StoredProcedureQuery spqr = em.createStoredProcedureQuery("avgCompletionTimePerTypeByDateRange", "RequestPerTypeMapping");
        spqr.registerStoredProcedureParameter("dateFrom", Date.class, ParameterMode.IN);
        spqr.registerStoredProcedureParameter("dateTo", Date.class, ParameterMode.IN);
        spqr.setParameter("dateFrom", dateFrom);
        spqr.setParameter("dateTo", dateTo);
        List<RequestPerType> list = spqr.getResultList();
        return list;
    }
    
}
