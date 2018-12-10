package jsf;

import entities.P1Xrhsths;
import jsf.util.JsfUtil;
import jsf.util.JsfUtil.PersistAction;
import session.P1XrhsthsFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("p1XrhsthsController")
@SessionScoped
public class P1XrhsthsController implements Serializable {

    @EJB
    private session.P1XrhsthsFacade ejbFacade;
    private List<P1Xrhsths> items = null;
    private P1Xrhsths selected;
    private UIComponent usernameInput;

    public P1XrhsthsController() {
    }

    public P1Xrhsths getSelected() {
        return selected;
    }

    public void setSelected(P1Xrhsths selected) {
        this.selected = selected;
    }

    public UIComponent getUsernameInput() {
        return usernameInput;
    }

    public void setUsernameInput(UIComponent usernameInput) {
        this.usernameInput = usernameInput;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private P1XrhsthsFacade getFacade() {
        return ejbFacade;
    }

    public P1Xrhsths prepareCreate() {
        
        selected = new P1Xrhsths();
        selected.setXrhsType((short)2);
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        
//        if(selected.getXrhsType()==0){
//            System.out.println("fixed type");
//            selected.setXrhsType((short)2);
//        }
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("P1XrhsthsCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("P1XrhsthsUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("P1XrhsthsDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    
    public void checkUsername(){
        List<String> listOfUsernames = getFacade().getUsernames();
        if(listOfUsernames.contains(selected.getXrhsUsername())){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(usernameInput.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "username exists", null));
        }
    }

    public List<P1Xrhsths> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public P1Xrhsths getP1Xrhsths(java.lang.Short id) {
        return getFacade().find(id);
    }

    public List<P1Xrhsths> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<P1Xrhsths> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = P1Xrhsths.class)
    public static class P1XrhsthsControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            P1XrhsthsController controller = (P1XrhsthsController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "p1XrhsthsController");
            return controller.getP1Xrhsths(getKey(value));
        }

        java.lang.Short getKey(String value) {
            java.lang.Short key;
            key = Short.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Short value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof P1Xrhsths) {
                P1Xrhsths o = (P1Xrhsths) object;
                return getStringKey(o.getXrhsKwd());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), P1Xrhsths.class.getName()});
                return null;
            }
        }

    }

}
