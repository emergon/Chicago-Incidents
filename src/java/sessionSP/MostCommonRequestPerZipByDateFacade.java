/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionSP;

import entitiesSP.MostCommonRequestPerZipByDate;
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
public class MostCommonRequestPerZipByDateFacade extends AbstractFacade<MostCommonRequestPerZipByDate> {

    @PersistenceContext(unitName = "ChicagoIncidentsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MostCommonRequestPerZipByDateFacade() {
        super(MostCommonRequestPerZipByDate.class);
    }

    public List<MostCommonRequestPerZipByDate> getTotalRequestsPerDayByType(Date dateOfRequest){
        StoredProcedureQuery spqr = em.createStoredProcedureQuery("mostCommonRequestPerZipByDate", "MostCommonRequestPerZipByDateMapping");
        spqr.registerStoredProcedureParameter("dateOfRequest", Date.class, ParameterMode.IN);
        spqr.setParameter("dateOfRequest", dateOfRequest);
        List<MostCommonRequestPerZipByDate> list = spqr.getResultList();
        return list;
    }
}
