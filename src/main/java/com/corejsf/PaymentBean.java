package com.corejsf;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

// or import javax.faces.bean.ManagedBean;
// or import javax.faces.bean.SessionScoped;

@Named("payment") // or @ManagedBean(name="payment")
@SessionScoped
public class PaymentBean implements Serializable {
    private double amount;
    private String card = "";
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