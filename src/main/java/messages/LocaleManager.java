package messages;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

@Named
@SessionScoped
public class LocaleManager implements Serializable {

    private String localeCode;
    private ResourceBundle bundle;
    private Map<String, Object> countries = new ConcurrentHashMap<String, Object>();

    @PostConstruct
    public void init() {
        localeCode = FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage();
        System.out.println(localeCode);
        refreshCountries();
    }

    public void refreshCountries() {
        countries.clear();
        countries.put(getBundle().getString("english"), Locale.ENGLISH);
        countries.put(getBundle().getString("french"), Locale.FRENCH);
    }

    public Map<String, Object> getCountries() {
        return countries;
    }

    public ResourceBundle getBundle() {
        if (bundle == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            bundle = context.getApplication().getResourceBundle(context, "msgs");
        }
        return bundle;
    }

    public String getLocaleCode() {
        return localeCode;
    }


    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    public void countryLocaleCodeChanged(ValueChangeEvent e) {
        String newLocaleValue = e.getNewValue().toString();
        for (Map.Entry<String, Object> entry : countries.entrySet()) {
            if (entry.getValue().toString().equals(newLocaleValue)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.getViewRoot().setLocale((Locale) entry.getValue());
                bundle = context.getApplication().getResourceBundle(context, "msgs");
                refreshCountries();
                return;
            }
        }
    }
}
