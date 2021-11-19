package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employees","root","Kronos@7");
        return con;
    }
}