package com.corejsf;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// or import javax.faces.bean.ManagedBean;
// or import javax.faces.bean.SessionScoped;

@Named // or @ManagedBean
@SessionScoped
public class TableData implements Serializable {
    private List<Name> names = new ArrayList<Name>(Arrays.asList(new Name("William", "Dupont"),
            new Name("Anna", "Keeney"),
            new Name("Mariko", "Randor"),
            new Name("John", "Wilson")));

    public List<Name> getNames() {
        return names;
    }

    public String save() {
        for (Name name : names) name.setEditable(false);
        return null;
    }

    public String deleteRow(Name nameToDelete) {
        names.remove(nameToDelete);
        return "/dataTable/deleting?faces-redirect=true";
    }
}