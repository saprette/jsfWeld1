package com.corejsf;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

// or import javax.faces.bean.ManagedBean;
// or import javax.faces.bean.SessionScoped;

@Named("payment2") // or @ManagedBean(name="payment")
@SessionScoped
public class PaymentBean2 implements Serializable {
    private double amount;
    private CreditCard card = new CreditCard("");
    private Date date = new Date();

    public void setAmount(double newValue) {
        amount = newValue;
    }

    public double getAmount() {
        return amount;
    }

    public void setCard(CreditCard newValue) {
        card = newValue;
    }

    public CreditCard getCard() {
        return card;
    }

    public void setDate(Date newValue) {
        date = newValue;
    }

    public Date getDate() {
        return date;
    }
}
