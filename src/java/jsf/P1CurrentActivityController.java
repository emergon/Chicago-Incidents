package jsf;

import entities.P1CurrentActivity;
import jsf.util.JsfUtil;
import jsf.util.JsfUtil.PersistAction;
import session.P1CurrentActivityFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("p1CurrentActivityController")
@SessionScoped
public class P1CurrentActivityController implements Serializable {

    @EJB
    private session.P1CurrentActivityFacade ejbFacade;
    private List<P1CurrentActivity> items = null;
    private P1CurrentActivity selected;

    public P1CurrentActivityController() {
    }

    public P1CurrentActivity getSelected() {
        return selected;
    }

    public void setSelected(P1CurrentActivity selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private P1CurrentActivityFacade getFacade() {
        return ejbFacade;
    }

    public P1CurrentActivity prepareCreate() {
        selected = new P1CurrentActivity();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("P1CurrentActivityCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("P1CurrentActivityUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("P1CurrentActivityDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<P1CurrentActivity> getItems() {
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

    public P1CurrentActivity getP1CurrentActivity(java.lang.Short id) {
        return getFacade().find(id);
    }

    public List<P1CurrentActivity> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<P1CurrentActivity> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = P1CurrentActivity.class)
    public static class P1CurrentActivityControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            P1CurrentActivityController controller = (P1CurrentActivityController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "p1CurrentActivityController");
            return controller.getP1CurrentActivity(getKey(value));
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
            if (object instanceof P1CurrentActivity) {
                P1CurrentActivity o = (P1CurrentActivity) object;
                return getStringKey(o.getCurrActiId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), P1CurrentActivity.class.getName()});
                return null;
            }
        }

    }

}
