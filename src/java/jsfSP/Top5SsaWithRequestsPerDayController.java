/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsfSP;

import entities.P1Xrhsths;
import entitiesSP.Top5SsaWithRequestsPerDay;
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
import sessionSP.Top5SsaWithRequestsPerDayFacade;

/**
 *
 * @author anastasios
 */
@Named("top5SsaWithRequestsPerDayController")
@SessionScoped
public class Top5SsaWithRequestsPerDayController implements Serializable {

    @EJB
    private Top5SsaWithRequestsPerDayFacade ejbFacade;
    private List<Top5SsaWithRequestsPerDay> itemsTop5SsaWithRequestsPerDay = null;
    private Date dateFrom;
    private Date dateTo;
    @Inject
    private P1XrhsthActionController p1XrhsthActionController;

    public List<Top5SsaWithRequestsPerDay> getItemsTop5SsaWithRequestsPerDay() {
        if (itemsTop5SsaWithRequestsPerDay == null) {
            itemsTop5SsaWithRequestsPerDay = new ArrayList();
        }
        return itemsTop5SsaWithRequestsPerDay;
    }

    public void setItemsTop5SsaWithRequestsPerDay(List<Top5SsaWithRequestsPerDay> itemsTop5SsaWithRequestsPerDay) {
        this.itemsTop5SsaWithRequestsPerDay = itemsTop5SsaWithRequestsPerDay;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    private Top5SsaWithRequestsPerDayFacade getFacade() {
        return ejbFacade;
    }

    public List<Top5SsaWithRequestsPerDay> fereTop5SsaWithRequestsPerDay() {
        itemsTop5SsaWithRequestsPerDay = getFacade().getTop5SsaWithRequestsPerDay(dateFrom, dateTo);
        p1XrhsthActionController.createEggrafh("Top5SsaWithRequestsPerDay from:"+dateFrom+" to:"+dateTo+" searched",fereXrhsth());
        return itemsTop5SsaWithRequestsPerDay;
    }
    
    public P1Xrhsths fereXrhsth() {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        P1Xrhsths xrhsths = (P1Xrhsths) httpSession.getAttribute("XRHSTHS");
        return xrhsths;
    }

}
