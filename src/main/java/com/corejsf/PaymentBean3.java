package com.corejsf;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

// or import javax.faces.bean.ManagedBean;
// or import javax.faces.bean.SessionScoped;

@Named("payment3") // or @ManagedBean(name="payment")
@SessionScoped
public class PaymentBean3 implements Serializable {
    @Min(10)
    @Max(10000)
    private double amount;
    @Size(min = 13, message = "{com.corejsf.creditCardLength}")
    @LuhnCheck
    private String card = "";
    @Future
    private Date date = new Date();

    public void setAmount(double newValue) {
        amount = newValue;
    }

    public double getAmount() {
        return amount;
    }

    public void setCard(String newValue) {
        card = newValue;
    }

    public String getCard() {
        return card;
    }

    public void setDate(Date newValue) {
        date = newValue;
    }

    public Date getDate() {
        return date;
    }
}
