/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionSP;

import entitiesSP.Top5SsaWithRequestsPerDay;
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
public class Top5SsaWithRequestsPerDayFacade extends AbstractFacade<Top5SsaWithRequestsPerDay>  {
    @PersistenceContext(unitName = "ChicagoIncidentsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Top5SsaWithRequestsPerDayFacade() {
        super(Top5SsaWithRequestsPerDay.class);
    }
    
    public List<Top5SsaWithRequestsPerDay> getTop5SsaWithRequestsPerDay(Date dateFrom, Date dateTo) {
        StoredProcedureQuery spqr = em.createStoredProcedureQuery("top5SsaWithRequestsPerDay", "Top5SsaWithRequestsPerDayMapping");
        spqr.registerStoredProcedureParameter("dateFrom", Date.class, ParameterMode.IN);
        spqr.registerStoredProcedureParameter("dateTo", Date.class, ParameterMode.IN);
        spqr.setParameter("dateFrom", dateFrom);
        spqr.setParameter("dateTo", dateTo);
        List<Top5SsaWithRequestsPerDay> list = spqr.getResultList();
        return list;
    }
    
    
    
}
