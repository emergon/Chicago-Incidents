package jsf;

import entities.P1Incidents;
import entities.P1Potholes;
import entities.P1Xrhsths;
import jsf.util.JsfUtil;
import jsf.util.JsfUtil.PersistAction;
import session.P1PotholesFacade;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@Named("p1PotholesController")
@SessionScoped
public class P1PotholesController implements Serializable {

    @EJB
    private session.P1PotholesFacade ejbFacade;
    private List<P1Potholes> items = null;
    private P1Potholes selected;
    private LazyDataModel<P1Potholes> lazyModel;
    @Inject
    private P1IncidentsController p1IncidentsController;
    @Inject
    private P1XrhsthActionController p1XrhsthActionController;
//    @PostConstruct
//    public void init() {
//        lazy();
//    }

    public P1PotholesController() {
    }

    public P1Potholes getSelected() {
        return selected;
    }

    public void setSelected(P1Potholes selected) {
        this.selected = selected;
    }

    public LazyDataModel<P1Potholes> getLazyModel() {
        return lazyModel;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private P1PotholesFacade getFacade() {
        return ejbFacade;
    }

    public P1IncidentsController getP1IncidentsController() {
        return p1IncidentsController;
    }

    public void setP1IncidentsController(P1IncidentsController p1IncidentsController) {
        this.p1IncidentsController = p1IncidentsController;
    }

    public P1Potholes prepareCreate(P1Incidents incident) {
        selected = new P1Potholes();
        selected.setInciKwd(incident);
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        getP1IncidentsController().create();
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("P1PotholesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        p1XrhsthActionController.createEggrafh("Pothole Incident created", fereXrhsth());
    }

    public void prepareUpdate() {
        getP1IncidentsController().setSelected(selected.getInciKwd());
    }

    public void update() {
        getP1IncidentsController().update();
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("P1PotholesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("P1PotholesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public P1Xrhsths fereXrhsth() {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        P1Xrhsths xrhsths = (P1Xrhsths) httpSession.getAttribute("XRHSTHS");
        return xrhsths;
    }

    public void lazy() {

        lazyModel = new LazyDataModel<P1Potholes>() {

            @Override
            public P1Potholes getRowData(String rowKey) {
                return ejbFacade.getRowData(Integer.parseInt(rowKey));
            }

            @Override
            public List<P1Potholes> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
//                lazyModel.setRowCount(ejbFacade.getPotholesTotalCount());
                return ejbFacade.getPotholesList(first, pageSize);
            }
        };
        lazyModel.setRowCount(ejbFacade.getPotholesTotalCount());
    }

    public List<P1Potholes> getItems() {
        if (items == null) {
            items = getFacade().getPotholesByXrhsth(fereXrhsth());
        }
        return items;
    }

    public void ferePotholesByIncident(P1Incidents incident) {
        selected = getFacade().getPotholesByInciKwd(incident);
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

    public P1Potholes getP1Potholes(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<P1Potholes> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<P1Potholes> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = P1Potholes.class)
    public static class P1PotholesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            P1PotholesController controller = (P1PotholesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "p1PotholesController");
            return controller.getP1Potholes(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof P1Potholes) {
                P1Potholes o = (P1Potholes) object;
                return getStringKey(o.getPothId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), P1Potholes.class.getName()});
                return null;
            }
        }

    }

}
