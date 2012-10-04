package com.tal.test;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "calc")
@SessionScoped
public class Calculator implements Serializable {

    private Integer nb1 = 1;
    private Integer nb2 = 2;
    private Integer result = 3;

    public void process() {
        result = nb1 + nb2;
    }

    public Integer getNb1() {
        return nb1;
    }

    public void setNb1(Integer nb1) {
        this.nb1 = nb1;
    }

    public Integer getNb2() {
        return nb2;
    }

    public void setNb2(Integer nb2) {
        this.nb2 = nb2;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
