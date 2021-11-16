package controller;

import java.sql.*;
import java.util.LinkedList;
import java.util.logging.*;

public class DatabaseController {
    
    Connection con;

    public DatabaseController() {
    }
    
    public boolean connect(String server, String database, String user, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
            "jdbc:mysql://" + server + "/" + database + "?useSSL=true",
            user,
            password);
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public LinkedList<String> getTables() {
        LinkedList<String> tables = new LinkedList<>();
        DatabaseMetaData metadata;
        try {
            metadata = con.getMetaData();
            String[] types = {"TABLE"};
            ResultSet resultSet = metadata.getTables(null, null, "%", types);
            while (resultSet.next()) {
                tables.add(resultSet.getString("TABLE_NAME"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tables;
    }
    
    public LinkedList<String> getFields(String tableName) {
        LinkedList<String> fields = new LinkedList<>();
        DatabaseMetaData metadata;
        try {
            metadata = con.getMetaData();
            ResultSet resultSet = metadata.getColumns(null, null, tableName, null);
            while (resultSet.next()) {
                fields.add(resultSet.getString("COLUMN_NAME"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fields;
    }
    
    public boolean disconnect() {
        try {
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
