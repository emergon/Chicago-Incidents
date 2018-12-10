/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsfSP;

import entities.P1Incidents;
import entities.P1Xrhsths;
import entitiesSP.PlatesMoreThanOnce;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import jsf.P1XrhsthActionController;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import sessionSP.PlatesMoreThanOnceFacade;

/**
 *
 * @author anastasios
 */
@Named("platesMoreThanOnceController")
@SessionScoped
public class PlatesMoreThanOnceController implements Serializable {

    @EJB
    private PlatesMoreThanOnceFacade ejbFacade;
    private List<PlatesMoreThanOnce> itemsPlatesMoreThanOnce = null;
    private LazyDataModel<PlatesMoreThanOnce> lazyModel;
    @Inject
    private P1XrhsthActionController p1XrhsthActionController;

//    @PostConstruct
//    public void init() {
//        lazy();
//    }
    public PlatesMoreThanOnceController() {

    }

    public List<PlatesMoreThanOnce> getItemsPlatesMoreThanOnce() {
        return itemsPlatesMoreThanOnce;
    }

    public void setItemsPlatesMoreThanOnce(List<PlatesMoreThanOnce> itemsPlatesMoreThanOnce) {
        this.itemsPlatesMoreThanOnce = itemsPlatesMoreThanOnce;
    }

    public PlatesMoreThanOnceFacade getFacade() {
        return ejbFacade;
    }

    public List<PlatesMoreThanOnce> ferePlatesMoreThanOnce() {
        if (itemsPlatesMoreThanOnce == null) {
            p1XrhsthActionController.createEggrafh("PlatesMoreThanOnce searched",fereXrhsth());
            itemsPlatesMoreThanOnce = getFacade().getPlatesMoreThanOnce();
        }
        return itemsPlatesMoreThanOnce;
    }

    public LazyDataModel<PlatesMoreThanOnce> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<PlatesMoreThanOnce> lazyModel) {
        this.lazyModel = lazyModel;
    }

    public void lazy() {

        lazyModel = new LazyDataModel<PlatesMoreThanOnce>() {

            @Override
            public PlatesMoreThanOnce getRowData(String rowKey) {
                return ejbFacade.getRowData(rowKey);
            }

            @Override
            public List<PlatesMoreThanOnce> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
//                lazyModel.setRowCount(ejbFacade.getIncidentsTotalCount());
                return ejbFacade.getPlatesMoreThanOnceList(first, pageSize);
            }
        };
        lazyModel.setRowCount(ejbFacade.getPlatesMoreThanOnceCount());
    }
    
    public P1Xrhsths fereXrhsth() {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        P1Xrhsths xrhsths = (P1Xrhsths) httpSession.getAttribute("XRHSTHS");
        return xrhsths;
    }
    
}
