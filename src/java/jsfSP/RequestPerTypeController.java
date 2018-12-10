/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsfSP;

import entities.P1Xrhsths;
import entitiesSP.RequestPerType;
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
import sessionSP.RequestPerTypeFacade;

/**
 *
 * @author anastasios
 */
@Named("requestPerTypeController")
@SessionScoped
public class RequestPerTypeController implements Serializable {

    @EJB
    private RequestPerTypeFacade ejbFacade;
    private List<RequestPerType> itemsRequestPerType = null;
    private List<RequestPerType> itemsAvgCompletionTimePerTypeByDateRange = null;
    private Date requestPerTypeDateFrom;
    private Date requestPerTypeDateTo;
    @Inject
    private P1XrhsthActionController p1XrhsthActionController;

    public List<RequestPerType> getItemsRequestPerType() {
        if (itemsRequestPerType == null) {
            itemsRequestPerType = new ArrayList();
        }
        return itemsRequestPerType;
    }

    public void setItemsRequestPerType(List<RequestPerType> itemsRequestPerType) {
        this.itemsRequestPerType = itemsRequestPerType;
    }

    public Date getRequestPerTypeDateFrom() {
        return requestPerTypeDateFrom;
    }

    public void setRequestPerTypeDateFrom(Date requestPerTypeDateFrom) {
        this.requestPerTypeDateFrom = requestPerTypeDateFrom;
    }

    public Date getRequestPerTypeDateTo() {
        return requestPerTypeDateTo;
    }

    public void setRequestPerTypeDateTo(Date requestPerTypeDateTo) {
        this.requestPerTypeDateTo = requestPerTypeDateTo;
    }

    public List<RequestPerType> getItemsAvgCompletionTimePerTypeByDateRange() {
        if (itemsAvgCompletionTimePerTypeByDateRange == null) {
            itemsAvgCompletionTimePerTypeByDateRange = new ArrayList<>();
        }
        return itemsAvgCompletionTimePerTypeByDateRange;
    }

    public void setItemsAvgCompletionTimePerTypeByDateRange(List<RequestPerType> itemsAvgCompletionTimePerTypeByDateRange) {
        this.itemsAvgCompletionTimePerTypeByDateRange = itemsAvgCompletionTimePerTypeByDateRange;
    }

    private RequestPerTypeFacade getFacade() {
        return ejbFacade;
    }

    public List<RequestPerType> fereTotalRequestsPerTypeByDateRange() {
        itemsRequestPerType = getFacade().getTotalRequestsPerTypeByDateRange(requestPerTypeDateFrom, requestPerTypeDateTo);
        p1XrhsthActionController.createEggrafh("TotalRequestsPerType from:"+requestPerTypeDateFrom+" to:"+requestPerTypeDateTo+" searched",fereXrhsth());
        return itemsRequestPerType;
    }

    public List<RequestPerType> fereAvgCompletionTimePerTypeByDateRange() {
        itemsAvgCompletionTimePerTypeByDateRange = getFacade().getAvgCompletionTimePerTypeByDateRange(requestPerTypeDateFrom, requestPerTypeDateTo);
        return itemsRequestPerType;
    }

    public P1Xrhsths fereXrhsth() {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        P1Xrhsths xrhsths = (P1Xrhsths) httpSession.getAttribute("XRHSTHS");
        return xrhsths;
    }

}
