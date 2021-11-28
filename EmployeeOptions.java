package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeOptions {
    Connection con;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void addEmployee() throws ClassNotFoundException, SQLException, IOException {
        con = DBConnection.getConnection();
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Enter the following to add new employee: ");
        System.out.println("id, first name, last name, email-id, salary, contact number");
        System.out.println("WARNING: ID can not be null");
        int id = Integer.parseInt(reader.readLine());
        String fname = reader.readLine();
        String lname = reader.readLine();
        String email = reader.readLine();
        String salary = reader.readLine();
        String contact = reader.readLine();

        PreparedStatement ps = con.prepareStatement("insert into EmployeeDetails values(?,?,?,?,?,?)");
        ps.setInt(1, id);
        ps.setString(2, fname);
        ps.setString(3, lname);
        ps.setString(4, email);
        ps.setString(5, salary);
        ps.setString(6, contact);

        int i = ps.executeUpdate();
        System.out.println(i+" row(s) added");
        ps.close();
    }
    public void deleteEmployee() throws IOException, SQLException, ClassNotFoundException {
        System.out.println("Enter the employee id to delete an existing employee");
        int id = Integer.parseInt(reader.readLine());

        con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("delete from EmployeeDetails where id = "+id);

        int i = ps.executeUpdate();
        System.out.println(i+" record deleted");
        ps.close();
    }
    public void displayEmployees() throws SQLException, ClassNotFoundException {
        con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("select *from EmployeeDetails order by id");
        System.out.println("List of Employees: ");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("FirstName")+" "+rs.getString("LastName"));
        }
        ps.close();
        rs.close();
    }
}
