package com.company;
//Database name is 'Credentials' and table name is 'LoginDetails'

import java.sql.*;

public class Login {
    Connection con;

    public String getAdminUserName() throws SQLException, ClassNotFoundException {
        String username = "";
        con = DBConnection.getConnectionForLogin();
        PreparedStatement ps = con.prepareStatement("select * from LoginDetails where ID = 1");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            username = rs.getString("username");
        }
        return username;
    }

    public String getAdminPassword() throws SQLException, ClassNotFoundException {
        String password = "";
        con = DBConnection.getConnectionForLogin();
        PreparedStatement ps = con.prepareStatement("select * from LoginDetails where ID = 1");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            password = rs.getString("password");
        }
        return password;
    }

    public String getEmployeeUserName(String name) throws SQLException, ClassNotFoundException {
        String username = "";
        con = DBConnection.getConnectionForLogin();
        PreparedStatement ps = con.prepareStatement("select * from LoginDetails where username = "+"'"+name+"'");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            username = rs.getString("username");
        }
        return username;
    }

    public String getEmployeePassword(String pass) throws SQLException, ClassNotFoundException {
        String password = "";
        con = DBConnection.getConnectionForLogin();
        PreparedStatement ps = con.prepareStatement("select * from LoginDetails where password = "+"'"+pass+"'");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            password = rs.getString("password");
        }
        return password;
    }
}
