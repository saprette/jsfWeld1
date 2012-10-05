package com.corejsf;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// or import javax.faces.bean.ManagedBean;
// or import javax.faces.bean.RequestScoped;

@Named // or @ManagedBean
@RequestScoped
public class CustomerBean {
    @Resource(name = "MyOracleDS", lookup = "java:/jdbc/MyOracleDS")
    private DataSource ds;

    public ResultSet getAll() throws SQLException {
        Connection conn = ds.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM JSF3_DATATABLE");
            // return ResultSupport.toResult(result);
            CachedRowSet crs = new com.sun.rowset.CachedRowSetImpl();
            // or use an implementation from your database vendor
            crs.populate(result);
            return crs;
        } finally {
            conn.close();
        }
    }
}
