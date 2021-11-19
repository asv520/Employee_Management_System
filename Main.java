package com.company;
//Database name is 'Employees' and table name is 'EmployeeDetails'

import java.sql.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Choose Login type:\n1. Admin\n2. Employee");
        int choice = Integer.parseInt(reader.readLine());

        switch(choice){
            case 1 -> {
                System.out.println("Enter the following to Login: ");
                System.out.print("Enter the username: ");
                String userName = reader.readLine();
                System.out.print("Enter the password: ");
                String password = reader.readLine();

                if(Objects.equals(userName, "admin") && Objects.equals(password, "admin256")) {
                    System.out.println("Login Successful");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employees", "root", "Kronos@7");
                    System.out.println("Select among the following:\n1. Add new employee\n2. Delete an existing employee\n3. View list of all employees");
                    int actionChoice = Integer.parseInt(reader.readLine());
                    switch (actionChoice) {
                        case 1 -> {
                            System.out.println("Enter the following to add new employee: ");
                            System.out.println("id, first name, last name, email-id, contact number");
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
                        case 2 -> {
                            System.out.println("Enter the employee id to delete an existing employee");
                            int id = Integer.parseInt(reader.readLine());

                            PreparedStatement ps = con.prepareStatement("delete from EmployeeDetails where id = "+id);

                            int i = ps.executeUpdate();
                            System.out.println(i+" record deleted");
                            ps.close();
                        }
                        case 3 -> {
                            System.out.println("List of Employees: ");
                            PreparedStatement ps = con.prepareStatement("select *from EmployeeDetails order by id");
                            ResultSet rs = ps.executeQuery();
                            while (rs.next()) {
                                System.out.println(rs.getString("FirstName")+" "+rs.getString("LastName"));
                            }
                            ps.close();
                            rs.close();
                        }
                    }
                    con.close();
                }
                else{
                    System.out.println("Invalid credentials");
                }
            }
            case 2 -> {
                System.out.println("Enter the following to Login: ");
                System.out.print("Enter the username: ");
                String userName = reader.readLine();
                System.out.print("Enter the password: ");
                String password = reader.readLine();

                if(Objects.equals(userName, "user") && Objects.equals(password, "user123")) {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Details", "root", "Kronos@7");
                    System.out.println("Enter your unique employee id: ");
                    int id = Integer.parseInt(reader.readLine());
                    PreparedStatement ps = con.prepareStatement("select *from EmployeeDetails where id = "+id);
                    ResultSet rs = ps.executeQuery();
                    System.out.format("%s %10s %10s %10s %10s %10s\n", "ID","FName","LName","Email", "Salary", "Mobile");
                    System.out.format("%d %10s %10s %10s %10s %10s\n",rs.getInt("ID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Email"), rs.getString("Salary"), rs.getString("ContactNumber"));
                    con.close();
                    ps.close();
                    rs.close();
                }
                else{
                    System.out.println("Invalid credentials");
                }
            }
            default -> {
                System.out.println("Invalid Input! Please retry...");
            }
        }
    }
}
