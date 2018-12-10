/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsfSP;

import entities.P1Xrhsths;
import entitiesSP.MostCommonRequestPerZipByDate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import jsf.P1XrhsthActionController;
import sessionSP.MostCommonRequestPerZipByDateFacade;

/**
 *
 * @author anastasios
 */
@Named("mostCommonRequestPerZipByDateController")
@SessionScoped
public class MostCommonRequestPerZipByDateController implements Serializable {

    @EJB
    private MostCommonRequestPerZipByDateFacade ejbFacade;
    private Date requestDate;
    private List<MostCommonRequestPerZipByDate> itemsMostCommonRequestPerZipByDate = null;
    @Inject
    private P1XrhsthActionController p1XrhsthActionController;

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public List<MostCommonRequestPerZipByDate> getItemsMostCommonRequestPerZipByDate() {
        if (itemsMostCommonRequestPerZipByDate == null) {
            itemsMostCommonRequestPerZipByDate = new ArrayList();
        }
        return itemsMostCommonRequestPerZipByDate;
    }

    public void setItemsMostCommonRequestPerZipByDate(List<MostCommonRequestPerZipByDate> itemsMostCommonRequestPerZipByDate) {
        this.itemsMostCommonRequestPerZipByDate = itemsMostCommonRequestPerZipByDate;
    }

    private MostCommonRequestPerZipByDateFacade getFacade() {
        return ejbFacade;
    }

    public List<MostCommonRequestPerZipByDate> fereMostCommonRequestPerZipByDate() {
        itemsMostCommonRequestPerZipByDate = getFacade().getTotalRequestsPerDayByType(requestDate);
        p1XrhsthActionController.createEggrafh("MostCommonRequestPerZip for:"+requestDate+" searched",fereXrhsth());
        return itemsMostCommonRequestPerZipByDate;
    }
    
    public P1Xrhsths fereXrhsth() {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        P1Xrhsths xrhsths = (P1Xrhsths) httpSession.getAttribute("XRHSTHS");
        return xrhsths;
    }
}
