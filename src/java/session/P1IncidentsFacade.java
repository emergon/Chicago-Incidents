/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.P1Incidents;
import java.math.BigInteger;
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
public class P1IncidentsFacade extends AbstractFacade<P1Incidents> {

    @PersistenceContext(unitName = "ChicagoIncidentsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public P1IncidentsFacade() {
        super(P1Incidents.class);
    }

/////START OF LAZY MODEL METHODS
    public int getIncidentsTotalCount() {
        Query query = em.createNamedQuery("P1Incidents.findTotalCount");
        return ((Long) query.getSingleResult()).intValue();
    }

    public List<P1Incidents> getIncidentsList(int start, int size) {
        Query query = em.createNamedQuery("P1Incidents.findAll");
        query.setFirstResult(start);
        query.setMaxResults(size);
        List<P1Incidents> list = query.getResultList();
        return list;
    }

    public P1Incidents getRowData(int key) {
        Query qr = em.createNamedQuery("P1Incidents.findByInciKwd");
        qr.setParameter("inciKwd", key);
        return (P1Incidents) qr.getSingleResult();
    }
/////ENDING OF LAZY MODEL METHODS    

    public int getIncidentsTotalCountByAddress(String address) {
        Query query = em.createNativeQuery("Select count(*) from p1_Incidents where inci_address like :address");
        query.setParameter("address", "%" + address + "%");
        return ((BigInteger) query.getSingleResult()).intValue();
    }

    public List<P1Incidents> getIncidentsByAddressList(String address, int start, int size) {
        Query query = em.createNativeQuery("Select * from p1_Incidents where inci_address like :address");
        query.setParameter("address", "%" + address + "%");
        query.setFirstResult(start);
        query.setMaxResults(size);
        List<P1Incidents> list = query.getResultList();
        return list;
    }

    public List<P1Incidents> getIncidentsByAddress(String address) {
        Query query = em.createNativeQuery("Select INCI_KWD, INCI_CREATION_DATE, "
                + "INCI_STATUS, INCI_COMPLETION_DATE, INCI_REQUEST_NUM, "
                + "INCI_REQUEST_TYPE,\n"
                + "INCI_ADDRESS, INCI_ZIP, INCI_X, INCI_Y, INCI_WARD, "
                + "INCI_POLICE_DISTRICT, INCI_COMM_AREA, INCI_LATITUDE, "
                + "INCI_LONGITUDE, XRHS_KWD "
                + "from p1_Incidents "
                + "where inci_address like :address", P1Incidents.class);
        //Query query = em.createNamedQuery("P1Incidents.findLikeAddress");
        query.setParameter("address", "%" + address + "%");
        List<P1Incidents> list = query.getResultList();
        return list;
    }
    
    public List<P1Incidents> getIncidentsByZip(String zip) {
        Query query = em.createNativeQuery("Select INCI_KWD, INCI_CREATION_DATE, "
                + "INCI_STATUS, INCI_COMPLETION_DATE, INCI_REQUEST_NUM, "
                + "INCI_REQUEST_TYPE,\n"
                + "INCI_ADDRESS, INCI_ZIP, INCI_X, INCI_Y, INCI_WARD, "
                + "INCI_POLICE_DISTRICT, INCI_COMM_AREA, INCI_LATITUDE, "
                + "INCI_LONGITUDE, XRHS_KWD "
                + "from p1_Incidents "
                + "where INCI_ZIP like :zip", P1Incidents.class);
        //Query query = em.createNamedQuery("P1Incidents.findLikeAddress");
        query.setParameter("zip", "%" + zip + "%");
        List<P1Incidents> list = query.getResultList();
        return list;
    }
    public List<P1Incidents> getIncidentsByAddressAndZip(String address, String zip) {
        Query query = em.createNativeQuery("Select INCI_KWD, INCI_CREATION_DATE, "
                + "INCI_STATUS, INCI_COMPLETION_DATE, INCI_REQUEST_NUM, "
                + "INCI_REQUEST_TYPE,\n"
                + "INCI_ADDRESS, INCI_ZIP, INCI_X, INCI_Y, INCI_WARD, "
                + "INCI_POLICE_DISTRICT, INCI_COMM_AREA, INCI_LATITUDE, "
                + "INCI_LONGITUDE, XRHS_KWD "
                + "from p1_Incidents "
                + "where INCI_ZIP like :zip and INCI_ADDRESS like :address", P1Incidents.class);
        //Query query = em.createNamedQuery("P1Incidents.findLikeAddress");
        query.setParameter("address", "%" + address + "%");
        query.setParameter("zip", "%" + zip + "%");
        List<P1Incidents> list = query.getResultList();
        return list;
    }
    
    public List<String> getIncidentsZip(String lektiko){
        List<String> arr = new ArrayList();
        Query qr = em.createNativeQuery("select distinct inci_zip from p1_incidents where inci_zip like :zip");
        qr.setParameter("zip", "%" + lektiko + "%");
        arr = qr.getResultList();
        return arr;
    }
    
    public List<String> getZipCodes(){
        List<String> arr;
        Query qr = em.createNativeQuery("select distinct inci_zip from p1_incidents where inci_zip is not null  order by 1");
        arr = qr.getResultList();
        return arr;
    }
    public List<String> getWards(){
        List<String> arr;
        Query qr = em.createNativeQuery("select distinct inci_ward from p1_incidents where inci_ward is not null order by 1");
        arr = qr.getResultList();
        return arr;
    }
    public List<String> getPoliceDistricts(){
        List<String> arr;
        Query qr = em.createNativeQuery("select distinct inci_police_district from p1_incidents where inci_police_district is not null  order by 1");
        arr = qr.getResultList();
        return arr;
    }
    public List<String> getCommAreas(){
        List<String> arr;
        Query qr = em.createNativeQuery("select distinct inci_comm_area from p1_incidents where inci_comm_area is not null  order by 1");
        arr = qr.getResultList();
        return arr;
    }
    
    public String getMaxRequestNumber(){
        String number;
        Query qr = em.createNativeQuery("select max(inci_request_num) from p1_incidents where inci_request_num like '18%'");
        number = (String)qr.getSingleResult();
        return number;
    }
    
    
    public int getMaxInciKwd(){
        int number;
        Query qr = em.createNativeQuery("select max(inci_kwd) from p1_incidents");
        number = (Integer)qr.getSingleResult();
        return number;
    }
}
