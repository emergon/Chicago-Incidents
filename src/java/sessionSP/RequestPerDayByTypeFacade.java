/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionSP;

import entitiesSP.RequestPerDayByType;
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
public class RequestPerDayByTypeFacade extends AbstractFacade<RequestPerDayByType> {

    @PersistenceContext(unitName = "ChicagoIncidentsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RequestPerDayByTypeFacade() {
        super(RequestPerDayByType.class);
    }

    public List<RequestPerDayByType> getTotalRequestsPerDayByType(Date dateFrom, Date dateTo, int type){
        StoredProcedureQuery spqr = em.createStoredProcedureQuery("totalRequestsPerDayByType", "RequestPerDayByTypeMapping");
        spqr.registerStoredProcedureParameter("dateFrom", Date.class, ParameterMode.IN);
        spqr.registerStoredProcedureParameter("dateTo", Date.class, ParameterMode.IN);
        spqr.registerStoredProcedureParameter("requestType", Integer.class, ParameterMode.IN);
        spqr.setParameter("dateFrom", dateFrom);
        spqr.setParameter("dateTo", dateTo);
        spqr.setParameter("requestType", type);
        List<RequestPerDayByType> list = spqr.getResultList();
        return list;
    }
}
