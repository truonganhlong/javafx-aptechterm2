/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class JDBCConnect {
    public static Connection getConnection() {       
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Coffe_Management";
            String username = "sa";
            String password = "long70261209";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(url,username,password);
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Can not connect to database!");
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(JDBCConnect.getConnection());
    }
}
