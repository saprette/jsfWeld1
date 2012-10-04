package basicajax;

import javax.faces.FacesException;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.io.IOException;

@ManagedBean
@RequestScoped
public class RedirectBean {

    public String redirect() {

        FacesContext ctx = FacesContext.getCurrentInstance();
        ExternalContext extContext = ctx.getExternalContext();
        String url = extContext.encodeActionURL(ctx.getApplication().getViewHandler().getActionURL(ctx, "/ajax/redirecttarget1.xhtml"));
        try {
            extContext.redirect(url);
        } catch (IOException ioe) {
            throw new FacesException(ioe);
        }
        return null;
    }

    public void redirectPage(ValueChangeEvent evt) {

        FacesContext ctx = FacesContext.getCurrentInstance();
        ExternalContext extContext = ctx.getExternalContext();
        ViewHandler viewHandler =  ctx.getApplication().getViewHandler();
                
        // Get the selection value
        String newurl = (String) evt.getNewValue();

        String url = viewHandler.getActionURL(ctx, newurl);

        try {
            extContext.redirect(url);
        } catch (IOException ioe) {
            throw new FacesException(ioe);
        }
    }
}