package jsf;

import entities.P1IncidentType;
import entities.P1Incidents;
import entities.P1Status;
import entities.P1Xrhsths;
import jsf.util.JsfUtil;
import jsf.util.JsfUtil.PersistAction;
import session.P1IncidentsFacade;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
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
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@Named("p1IncidentsController")
@SessionScoped
public class P1IncidentsController implements Serializable {

    @EJB
    private session.P1IncidentsFacade ejbFacade;
    private List<P1Incidents> items = null;
    private P1Incidents selected;
    private LazyDataModel<P1Incidents> lazyModel;
    private String address;
    private String zip;
    private List<P1Incidents> itemsByAddress = null;

    @Inject
    private P1AbandonedVehicleController p1AbandonedVehicleController;
    @Inject
    private P1AlleyLightsOutController p1AlleyLightsOutController;
    @Inject
    private P1GarbageCartController p1GarbageCartController;
    @Inject
    private P1GraffitiController p1GraffitiController;
    @Inject
    private P1PotholesController p1PotholesController;
    @Inject
    private P1RodentController p1RodentController;
    @Inject
    private P1SanitationController p1SanitationController;
    @Inject
    private P1StreetLightsAllController p1StreetLightsAllController;
    @Inject
    private P1StreetLightsOneController p1StreetLightsOneController;
    @Inject
    private P1TreeDebrisController p1TreeDebrisController;
    @Inject
    private P1TreeTrimsController p1TreeTrimsController;
    @Inject
    private P1XrhsthActionController p1XrhsthActionController;
//    @PostConstruct
//    public void init() {
//        lazy();
//    }

    public P1IncidentsController() {
    }

    public P1Incidents getSelected() {
        return selected;
    }

    public void setSelected(P1Incidents selected) {
        this.selected = selected;
    }

    public LazyDataModel<P1Incidents> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<P1Incidents> lazyModel) {
        this.lazyModel = lazyModel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public List<P1Incidents> getItemsByAddress() {
        return itemsByAddress;
    }

    public void setItemsByAddress(List<P1Incidents> itemsByAddress) {
        this.itemsByAddress = itemsByAddress;
    }

    public P1AbandonedVehicleController getP1AbandonedVehicleController() {
        return p1AbandonedVehicleController;
    }

    public void setP1AbandonedVehicleController(P1AbandonedVehicleController p1AbandonedVehicleController) {
        this.p1AbandonedVehicleController = p1AbandonedVehicleController;
    }

    public P1AlleyLightsOutController getP1AlleyLightsOutController() {
        return p1AlleyLightsOutController;
    }

    public void setP1AlleyLightsOutController(P1AlleyLightsOutController p1AlleyLightsOutController) {
        this.p1AlleyLightsOutController = p1AlleyLightsOutController;
    }

    public P1GarbageCartController getP1GarbageCartController() {
        return p1GarbageCartController;
    }

    public void setP1GarbageCartController(P1GarbageCartController p1GarbageCartController) {
        this.p1GarbageCartController = p1GarbageCartController;
    }

    public P1GraffitiController getP1GraffitiController() {
        return p1GraffitiController;
    }

    public void setP1GraffitiController(P1GraffitiController p1GraffitiController) {
        this.p1GraffitiController = p1GraffitiController;
    }

    public P1PotholesController getP1PotholesController() {
        return p1PotholesController;
    }

    public void setP1PotholesController(P1PotholesController p1PotholesController) {
        this.p1PotholesController = p1PotholesController;
    }

    public P1RodentController getP1RodentController() {
        return p1RodentController;
    }

    public void setP1RodentController(P1RodentController p1RodentController) {
        this.p1RodentController = p1RodentController;
    }

    public P1SanitationController getP1SanitationController() {
        return p1SanitationController;
    }

    public void setP1SanitationController(P1SanitationController p1SanitationController) {
        this.p1SanitationController = p1SanitationController;
    }

    public P1StreetLightsAllController getP1StreetLightsAllController() {
        return p1StreetLightsAllController;
    }

    public void setP1StreetLightsAllController(P1StreetLightsAllController p1StreetLightsAllController) {
        this.p1StreetLightsAllController = p1StreetLightsAllController;
    }

    public P1StreetLightsOneController getP1StreetLightsOneController() {
        return p1StreetLightsOneController;
    }

    public void setP1StreetLightsOneController(P1StreetLightsOneController p1StreetLightsOneController) {
        this.p1StreetLightsOneController = p1StreetLightsOneController;
    }

    public P1TreeDebrisController getP1TreeDebrisController() {
        return p1TreeDebrisController;
    }

    public void setP1TreeDebrisController(P1TreeDebrisController p1TreeDebrisController) {
        this.p1TreeDebrisController = p1TreeDebrisController;
    }

    public P1TreeTrimsController getP1TreeTrimsController() {
        return p1TreeTrimsController;
    }

    public void setP1TreeTrimsController(P1TreeTrimsController p1TreeTrimsController) {
        this.p1TreeTrimsController = p1TreeTrimsController;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private P1IncidentsFacade getFacade() {
        return ejbFacade;
    }

    public P1Incidents prepareCreate(Integer requestType) {
        selected = new P1Incidents();
        selected.setInciRequestNum("18-" + fereMaxRequestNumber());
        selected.setInciRequestType(new P1IncidentType(requestType.shortValue()));
        selected.setXrhsKwd(fereXrhsth());
        selected.setInciStatus(new P1Status((short) 3));
        selected.setInciKwd(fereMaxInciKwd());
        initializeEmbeddableKey();
        switch (requestType) {
            case 1:
                getP1AbandonedVehicleController().prepareCreate(selected);
                break;
            case 2:
                getP1AlleyLightsOutController().prepareCreate(selected);
                break;
            case 3:
                getP1GarbageCartController().prepareCreate(selected);
                break;
            case 4:
                getP1GraffitiController().prepareCreate(selected);
                break;
            case 5:
                getP1PotholesController().prepareCreate(selected);
                break;
            case 6:
                getP1RodentController().prepareCreate(selected);
                break;
            case 7:
                getP1SanitationController().prepareCreate(selected);
                break;
            case 8:
                getP1StreetLightsAllController().prepareCreate(selected);
                break;
            case 9:
                getP1StreetLightsOneController().prepareCreate(selected);
                break;
            case 10:
                getP1TreeDebrisController().prepareCreate(selected);
                break;
            case 11:
                getP1TreeTrimsController().prepareCreate(selected);
                break;

        }
        return selected;
    }

    public void create() {
        selected.setInciAddress(selected.getInciAddress().toUpperCase());
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("P1IncidentsCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("P1IncidentsUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("P1IncidentsDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void resetValues() {
        setAddress(null);
        setZip(null);
        setItemsByAddress(null);
    }

    public P1Xrhsths fereXrhsth() {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        P1Xrhsths xrhsths = (P1Xrhsths) httpSession.getAttribute("XRHSTHS");
        return xrhsths;
    }

    public List<String> fereZipCodes() {
        return getFacade().getZipCodes();
    }

    public List<String> fereWards() {
        return getFacade().getWards();
    }

    public List<String> ferePoliceDistricts() {
        return getFacade().getPoliceDistricts();
    }

    public List<String> fereCommAreas() {
        return getFacade().getCommAreas();
    }

    public int fereMaxRequestNumber() {
        String tmpNum = getFacade().getMaxRequestNumber();
        int num = Integer.parseInt(tmpNum.substring(3));
        num++;
        return num;
    }

    public int fereMaxInciKwd() {
        int tmpNum = getFacade().getMaxInciKwd();
        tmpNum++;
        return tmpNum;
    }

    public List<String> fereIncidentsZip(String zip) {
        return getFacade().getIncidentsZip(zip);
    }

    public List<P1Incidents> fereIncidentsByAddress() {
        if (zip != null && address != null) {
            itemsByAddress = getFacade().getIncidentsByAddressAndZip(address.toUpperCase(), zip.toUpperCase());
            p1XrhsthActionController.createEggrafh("Incidents by address and zip searched", fereXrhsth());
        } else {
            if (zip != null) {
                itemsByAddress = getFacade().getIncidentsByZip(zip.toUpperCase());
                p1XrhsthActionController.createEggrafh("Incidents by zip searched", fereXrhsth());
            } else if (address != null) {
                itemsByAddress = getFacade().getIncidentsByAddress(address.toUpperCase());
                p1XrhsthActionController.createEggrafh("Incidents by address searched", fereXrhsth());
            }
        }
        return itemsByAddress;
    }

    public void fereIncidentsLazyModel() {
        lazyModel = new LazyDataModel<P1Incidents>() {

            @Override
            public P1Incidents getRowData(String rowKey) {
                return ejbFacade.getRowData(Integer.parseInt(rowKey));
            }

            @Override
            public List<P1Incidents> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
//                lazyModel.setRowCount(ejbFacade.getIncidentsTotalCount());
                return ejbFacade.getIncidentsByAddressList(address, first, pageSize);
            }
        };
        lazyModel.setRowCount(ejbFacade.getIncidentsTotalCountByAddress(address));
    }

    public void lazy() {

        lazyModel = new LazyDataModel<P1Incidents>() {

            @Override
            public P1Incidents getRowData(String rowKey) {
                return ejbFacade.getRowData(Integer.parseInt(rowKey));
            }

            @Override
            public List<P1Incidents> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
//                lazyModel.setRowCount(ejbFacade.getIncidentsTotalCount());
                return ejbFacade.getIncidentsList(first, pageSize);
            }
        };
        lazyModel.setRowCount(ejbFacade.getIncidentsTotalCount());
    }

    public void showIncidentChild() {
        switch (selected.getInciRequestType().getInciTypeId()) {
            case 1:
                getP1AbandonedVehicleController().fereAbandonedVehicleByIncident(selected);
                break;
//            case 2:
//            case 8:
//            case 9:
//                break;
            case 3:
                getP1GarbageCartController().fereGarbageCartByIncident(selected);
                break;
            case 4:
                getP1GraffitiController().fereGraffitiByIncident(selected);
                break;
            case 5:
                getP1PotholesController().ferePotholesByIncident(selected);
                break;
            case 6:
                getP1RodentController().fereRodentByIncident(selected);
                break;
            case 7:
                getP1SanitationController().fereSanitationByIncident(selected);
                break;
            case 10:
                getP1TreeDebrisController().fereTreeDebrisByIncident(selected);
                break;
            case 11:
                getP1TreeTrimsController().fereTreeTrimsByIncident(selected);
                break;
            default:
                break;
        }
    }

    public List<P1Incidents> getItems() {
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

    public P1Incidents getP1Incidents(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<P1Incidents> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<P1Incidents> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = P1Incidents.class)
    public static class P1IncidentsControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            P1IncidentsController controller = (P1IncidentsController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "p1IncidentsController");
            return controller.getP1Incidents(getKey(value));
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
            if (object instanceof P1Incidents) {
                P1Incidents o = (P1Incidents) object;
                return getStringKey(o.getInciKwd());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), P1Incidents.class.getName()});
                return null;
            }
        }

    }

}
