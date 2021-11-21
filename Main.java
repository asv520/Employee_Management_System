package com.company;
//Database name is 'Employees' and table name is 'EmployeeDetails'

import java.sql.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("EMPLOYEE MANAGEMENT SYSTEM");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DBConnection.getConnection();
        EmployeeOptions dao = new EmployeeOptions();
        System.out.println("Choose Login type:\n1. Admin\n2. Employee");
        int choice = Integer.parseInt(reader.readLine());
        Login l = new Login();

        switch(choice){
            case 1 -> {
                System.out.println("Enter the following to Login: ");
                System.out.print("Enter the username: ");
                String userName = reader.readLine();
                System.out.print("Enter the password: ");
                String password = reader.readLine();

                if(Objects.equals(userName, l.getAdminUserName()) && Objects.equals(password, l.getAdminPassword())) {
                    System.out.println("Login Successful");
                    System.out.println("Select among the following:\n1. Add new employee\n2. Delete an existing employee\n3. View list of all employees\n4. View detailed list\n5. Update details for an Employee");
                    int actionChoice = Integer.parseInt(reader.readLine());
                    switch (actionChoice) {
                        case 1 -> {
                            dao.addEmployee();
                        }
                        case 2 -> {
                            dao.deleteEmployee();
                        }
                        case 3 -> {
                            dao.displayEmployees();
                        }
                        case 4 -> {
                            con = DBConnection.getConnection();
                            PreparedStatement ps = con.prepareStatement("select *from EmployeeDetails order by id");
                            ResultSet rs = ps.executeQuery();
                            DetailedList d = new DetailedList();
                            while(rs.next())
                            d.displayDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                        }
                        case 5 -> {
                            System.out.println("Choose the field to be updated: ");
                            System.out.println("1. ID\n2. First Name\n3. Last Name\n4. Email ID\n5. Salary\n6. Contact Number");
                            EmployeeUpdate eu = new EmployeeUpdate();
                            int options = Integer.parseInt(reader.readLine());
                            switch(options){
                                case 1 -> {
                                    eu.updateId();
                                }
                                case 2 -> {
                                    eu.updateFirstName();
                                }
                                case 3 -> {
                                    eu.updateLastName();
                                }
                                case 4 -> {
                                    eu.updateEmail();
                                }
                                case 5 -> {
                                    eu.updateSalary();
                                }
                                case 6 -> {
                                    eu.updateContact();
                                }
                                default -> {
                                    System.out.println("Invalid choice");
                                }
                            }
                        }
                        default -> {
                            System.out.println("Invalid Input");
                        }
                    }
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

                if(Objects.equals(userName, l.getEmployeeUserName(userName)) && Objects.equals(password, l.getEmployeePassword(password))) {
                    System.out.println("Login Successful");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DBConnection.getConnection();
                    System.out.println("Enter your unique employee id: ");
                    int id = Integer.parseInt(reader.readLine());
                    PreparedStatement ps = con.prepareStatement("select *from EmployeeDetails where id = "+id);
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()) {
                        System.out.println("First Name: "+rs.getString(2)+"\nLast Name: "+rs.getString(3)+"\nEmail ID: "+rs.getString(4)+"\nSalary: "+rs.getString(5)+"\nContact Number: "+rs.getString(6));
                    }
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
