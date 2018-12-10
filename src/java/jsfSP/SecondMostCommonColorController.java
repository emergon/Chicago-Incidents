/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsfSP;

import entities.P1Xrhsths;
import entitiesSP.SecondMostCommonColor;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import jsf.P1XrhsthActionController;
import sessionSP.SecondMostCommonColorFacade;

/**
 *
 * @author anastasios
 */
@Named("secondMostCommonColorController")
@SessionScoped
public class SecondMostCommonColorController implements Serializable {

    @EJB
    private SecondMostCommonColorFacade ejbFacade;
    private List<SecondMostCommonColor> itemsSecondMostCommonColor = null;
    @Inject
    private P1XrhsthActionController p1XrhsthActionController;

    public SecondMostCommonColorController() {

    }

    public List<SecondMostCommonColor> getItemsSecondMostCommonColor() {
        return itemsSecondMostCommonColor;
    }

    public void setItemsSecondMostCommonColor(List<SecondMostCommonColor> itemsSecondMostCommonColor) {
        this.itemsSecondMostCommonColor = itemsSecondMostCommonColor;
    }

    public SecondMostCommonColorFacade getFacade() {
        return ejbFacade;
    }

    public List<SecondMostCommonColor> fereSecondMostCommonColor() {
        if (itemsSecondMostCommonColor == null) {
            itemsSecondMostCommonColor = getFacade().getSecondMostCommonColor();
            p1XrhsthActionController.createEggrafh("SecondMostCommonColor searched",fereXrhsth());
        }
        return itemsSecondMostCommonColor;
    }
    
    public P1Xrhsths fereXrhsth() {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        P1Xrhsths xrhsths = (P1Xrhsths) httpSession.getAttribute("XRHSTHS");
        return xrhsths;
    }
    

}
