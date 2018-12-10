package jsf;

//import entities.DmXrhsths;
import entities.P1Xrhsths;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import jsf.util.JsfUtil;
import jsf.util.JsfUtil.PersistAction;
import javax.faces.context.ExternalContext;
import javax.faces.*;
import org.primefaces.PrimeFaces;
import org.primefaces.context.RequestContext;
import session.EisodosFacade;

@Named("eisodosController")
@SessionScoped
public class EisodosController implements Serializable {

    @EJB
    private session.EisodosFacade eisodosFacade;

    private P1Xrhsths selected;

    private boolean loggedIn;
    private int countFailedLogin;
    private String synthimatiko;
    private String temp_synthimatiko1;
    private String temp_synthimatiko2;
    private String timeNow;
    private String pwd;

    @PostConstruct
    public void init() {
        proetoimasiaElegxou();
    }

    public EisodosController() {
        loggedIn = false;
        countFailedLogin = 0;
        synthimatiko = "";
        temp_synthimatiko1 = "";
        temp_synthimatiko2 = "";

    }

    public P1Xrhsths getSelected() {
        return selected;
    }

    public void setSelected(P1Xrhsths selected) {
        this.selected = selected;
    }

    public String getSynthimatiko() {
        return synthimatiko;
    }

    public void setSynthimatiko(String synthimatiko) {
        this.synthimatiko = synthimatiko;
    }

    public String getTemp_synthimatiko1() {
        return temp_synthimatiko1;
    }

    public void setTemp_synthimatiko1(String temp_synthimatiko1) {
        this.temp_synthimatiko1 = temp_synthimatiko1;
    }

    public String getTemp_synthimatiko2() {
        return temp_synthimatiko2;
    }

    public void setTemp_synthimatiko2(String temp_synthimatiko2) {
        this.temp_synthimatiko2 = temp_synthimatiko2;
    }

    public String getTimeNow() {
        return new SimpleDateFormat("ddMMyyyy_HHmmss").format(Calendar.getInstance().getTime());
    }

    public void setTimeNow(String timeNow) {
        this.timeNow = timeNow;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    protected void setEmbeddableKeys() {
    }

    private EisodosFacade getEisodosFacade() {
        return eisodosFacade;
    }

    public P1Xrhsths prepareCreate() {
        selected = new P1Xrhsths();
        //initializeEmbeddableKey();
        return selected;
    }

    public void update() {
        persist(PersistAction.UPDATE, "Επιτυχής Μεταβολή");
    }

    public P1Xrhsths proetoimasiaElegxou() {
        loggedIn = false;
        if (countFailedLogin > 2) {
            countFailedLogin = 0;
        }
        selected = new P1Xrhsths();
        //initializeEmbeddableKey();

        return selected;
    }

    public void resetSession() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
            if (selected != null) {
                System.out.println("<---" + Calendar.getInstance().getTime() + ", ΕΞΟΔΟΣ ΧΡΗΣΤΗ: " + selected.getXrhsKwd() + ", " + selected.getXrhsUsername() + ", " + selected.getXrhsLname());
            }
        } catch (NullPointerException npe) {

        }
        //ΔΙΕΓΡΑΨΕ ΤΗ ΣΥΝΕΔΡΙΑ (SESSION)
        ec.invalidateSession();
        //ΔΙΕΓΡΑΨΕ ΤΗΝ ΙΣΤΟΡΙΑ ΤΩΝ COOKIES ΜΕ ΒΑΣΗ ΤΟ easdm.EasdmFilter (ΒΛΕΠΕ web.xml στο filter tag)
        if (ec.getRequestCookieMap().get("opentoken") != null) {
            ec.addResponseCookie("opentoken", null, Collections.<String, Object>singletonMap("maxAge", 0));
        }
        //ΑΝΑΚΑΤΕΥΘΥΝΕ ΣΤΗΝ ΑΡΧΙΚΗ ΣΕΛΙΔΑ
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(EisodosController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void elegxosXrhsth() {
        short one = 1;
        String path = null;

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext context = facesContext.getExternalContext();
        FacesMessage message = null;

        P1Xrhsths xr = getEisodosFacade().fereLogariasmo(selected.getXrhsUsername(), pwd);
        if (xr != null) {
            selected = xr;
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Καλώς Ήλθατε", selected.getXrhsUsername());
            countFailedLogin = 0;
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Σφάλμα Πρόσβασης", "Μη αποδεκτά συνθηματικά");
            ++countFailedLogin;
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addResponseHeader("loggedIn", Boolean.toString(loggedIn));
        if (loggedIn == true) {
            try {
                HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                httpSession.setAttribute("XRHSTHS", selected);
                FacesContext.getCurrentInstance().getExternalContext().redirect("faces/firstPage.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(EisodosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (loggedIn == false && countFailedLogin > 2) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("faces/adynamia_prosbashs.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(EisodosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void allaghSynthimatikou() {
        System.out.println("*" + synthimatiko + "*, *" + temp_synthimatiko1 + "*, *" + temp_synthimatiko2 + "*");
        if (selected.equals(getEisodosFacade().fereLogariasmo(selected.getXrhsUsername(), synthimatiko)) && temp_synthimatiko1.equals(temp_synthimatiko2)) {
            getEisodosFacade().allaxeSynthimatiko(selected, temp_synthimatiko2);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("ΟΚ! Επιτυχής Αλλαγή Συνθηματικού!"));
        } else if (selected.equals(getEisodosFacade().fereLogariasmo(selected.getXrhsUsername(), synthimatiko)) && !temp_synthimatiko1.equals(temp_synthimatiko2)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Τα νέα συνθηματικά δεν είναι ίδια! Ξαναπροσπαθήστε..."));
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Λάθος Παλαιό Συνθηματικό! Ξαναπροσπαθήστε..."));
        }
    }

    public void arxikopoihshPassword(P1Xrhsths xrhsths) {
        getEisodosFacade().arxikoSynthimatiko(xrhsths);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Το συνθηματικό αρχικοποιήθηκε!"));
    }

    public void elegxosSynedrias() {
        if (loggedIn == false) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("adynamia_prosbashs.html");
            } catch (IOException ex) {
                Logger.getLogger(EisodosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction == PersistAction.UPDATE) {
                    getEisodosFacade().edit(selected);
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Gdy").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Gdy").getString("PersistenceErrorOccured"));
            }
        }
    }

    public P1Xrhsths getP1Xrhsths(Long id) {
        return getEisodosFacade().find(id);
    }

    @FacesConverter(forClass = P1Xrhsths.class)
    public static class EisodosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EisodosController controller = (EisodosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "eisodosController");
            return controller.getP1Xrhsths(getKey(value));
        }

        Long getKey(String value) {
            Long key;
            key = new Long(value);
            return key;
        }

        String getStringKey(Short value) {
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
