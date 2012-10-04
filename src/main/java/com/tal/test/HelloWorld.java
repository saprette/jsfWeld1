package com.tal.test;

import javax.enterprise.inject.Model;

public
@Model
class HelloWorld {
    private final String text = "Hello ";

    private String param;

    private String name = "A name";

    public HelloWorld() {
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getText() {
        return text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
