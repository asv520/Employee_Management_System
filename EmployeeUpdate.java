package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeUpdate {
    Connection con;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public void updateId() throws SQLException, ClassNotFoundException, IOException {
        System.out.println("Enter the employee id");
        int oldid = Integer.parseInt(reader.readLine());
        System.out.println("Enter the new id for this employee");
        int newid = Integer.parseInt(reader.readLine());
        con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("update EmployeeDetails set ID = "+newid+" where id = "+oldid);
        int i = ps.executeUpdate();
        System.out.println(i+" row updated");
    }
    public void updateFirstName() throws IOException, SQLException, ClassNotFoundException {
        System.out.println("Enter the employee id");
        int id = Integer.parseInt(reader.readLine());
        System.out.println("Enter the new first name for this employee");
        String fname = reader.readLine();
        con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("update EmployeeDetails set FirstName = "+fname+" where id = "+id);
        int i = ps.executeUpdate();
        System.out.println(i+" row updated");
    }
    public void updateLastName() throws SQLException, ClassNotFoundException, IOException {
        System.out.println("Enter the employee id");
        int id = Integer.parseInt(reader.readLine());
        System.out.println("Enter the new first name for this employee");
        String lname = reader.readLine();
        con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("update EmployeeDetails set LastName = "+lname+" where id = "+id);
        int i = ps.executeUpdate();
        System.out.println(i+" row updated");
    }
    public void updateEmail() throws IOException, SQLException, ClassNotFoundException {
        System.out.println("Enter the employee id");
        int id = Integer.parseInt(reader.readLine());
        System.out.println("Enter the new email id for this employee");
        String email = reader.readLine();
        con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("update EmployeeDetails set Email = "+email+" where id = "+id);
        int i = ps.executeUpdate();
        System.out.println(i+" row updated");
    }
    public void updateSalary() throws IOException, SQLException, ClassNotFoundException {
        System.out.println("Enter the employee id");
        int id = Integer.parseInt(reader.readLine());
        System.out.println("Enter the new salary for this employee");
        String salary = reader.readLine();
        con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("update EmployeeDetails set Salary = "+salary+" where id = "+id);
        int i = ps.executeUpdate();
        System.out.println(i+" row updated");
    }
    public void updateContact() throws IOException, SQLException, ClassNotFoundException {
        System.out.println("Enter the employee id");
        int id = Integer.parseInt(reader.readLine());
        System.out.println("Enter the new contact number for this employee");
        String contact = reader.readLine();
        con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("update EmployeeDetails set ContactNumber = "+contact+" where id = "+id);
        int i = ps.executeUpdate();
        System.out.println(i+" row updated");
    }
}
