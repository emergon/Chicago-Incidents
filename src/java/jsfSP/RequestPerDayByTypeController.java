/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsfSP;

import entities.P1IncidentType;
import entities.P1Xrhsths;
import entitiesSP.RequestPerDayByType;
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
import sessionSP.RequestPerDayByTypeFacade;

/**
 *
 * @author anastasios
 */
@Named("requestPerDayByTypeController")
@SessionScoped
public class RequestPerDayByTypeController implements Serializable {

    @EJB
    private RequestPerDayByTypeFacade ejbFacade;
    private Date requestPerTypeDateFrom;
    private Date requestPerTypeDateTo;
    private P1IncidentType type;
    private List<RequestPerDayByType> itemsRequestPerDayByType = null;
    @Inject
    private P1XrhsthActionController p1XrhsthActionController;

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

    public P1IncidentType getType() {
        return type;
    }

    public void setType(P1IncidentType type) {
        this.type = type;
    }

    public List<RequestPerDayByType> getItemsRequestPerDayByType() {
        if (itemsRequestPerDayByType == null) {
            itemsRequestPerDayByType = new ArrayList();
        }
        return itemsRequestPerDayByType;
    }

    public void setItemsRequestPerDayByType(List<RequestPerDayByType> itemsRequestPerDayByType) {
        this.itemsRequestPerDayByType = itemsRequestPerDayByType;
    }

    private RequestPerDayByTypeFacade getFacade() {
        return ejbFacade;
    }

    public List<RequestPerDayByType> fereTotalRequestsPerDayByType() {
        itemsRequestPerDayByType = getFacade().getTotalRequestsPerDayByType(requestPerTypeDateFrom, requestPerTypeDateTo, type.getInciTypeId());
        p1XrhsthActionController.createEggrafh("TotalRequestsPerDay from:"+requestPerTypeDateFrom+" to:"+requestPerTypeDateTo+"for type:"+type.getInciTypeName()+" searched",fereXrhsth());
        return itemsRequestPerDayByType;
    }
    
    public P1Xrhsths fereXrhsth() {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        P1Xrhsths xrhsths = (P1Xrhsths) httpSession.getAttribute("XRHSTHS");
        return xrhsths;
    }
    
}
