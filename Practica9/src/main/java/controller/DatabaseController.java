package controller;

import java.sql.*;
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
            DatabaseMetaData md = con.getMetaData();
            String[] types = {"TABLE"};
            ResultSet rs = md.getTables(null, null, "%", types);
            while (rs.next()) {
                String nombreTabla = rs.getString("TABLE_NAME");
                System.out.println("Tabla: " + nombreTabla);
                ResultSet rs2 = md.getColumns(null, null, nombreTabla, null);
                while (rs2.next()) {
                    String nombreCampo = rs2.getString("COLUMN_NAME");
                    System.out.println(" Campo: " + nombreCampo);
                }
            }
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
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
