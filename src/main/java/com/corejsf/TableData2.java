package com.corejsf;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Comparator;

// or import javax.faces.bean.ManagedBean;
// or import javax.faces.bean.SessionScoped;

@Named // or @ManagedBean
@SessionScoped
public class TableData2 implements Serializable {
    private SortFilterModel<Name> filterModel;
    private static final Name[] names = {
            new Name("Anna", "Keeney"),
            new Name("John", "Wilson"),
            new Name("Mariko", "Randor"),
            new Name("William", "Dupont"),
    };

    public TableData2() {
        filterModel = new SortFilterModel<Name>(new ArrayDataModel<Name>(names));
    }

    public DataModel<Name> getNames() {
        return filterModel;
    }

    public String sortByFirst() {
        filterModel.sortBy(new Comparator<Name>() {
            public int compare(Name n1, Name n2) {
                return n1.getFirst().compareTo(n2.getFirst());
            }
        });
        return null;
    }

    public String sortByLast() {
        filterModel.sortBy(new Comparator<Name>() {
            public int compare(Name n1, Name n2) {
                return n1.getLast().compareTo(n2.getLast());
            }
        });
        return null;
    }
}