package basicajax;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;

@ManagedBean(name = "count")
@SessionScoped
public class Count implements Serializable {

    private static final long serialVersionUID = 6499154494910177344L;

    Integer count = 0;

    public Integer getCount() {
        return count;
    }

    public void increment(ActionEvent ae) {
        count++;
    }

    public void reset(ActionEvent ae) {
        count = 0;
    }

    public void multiplyBy2(ActionEvent ae) {
        count = count * 2;
    }
}