package com.company;
//Database name is 'Employees' and table name is 'EmployeeDetails'

import java.sql.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DBConnection.getConnection();
        EmployeeOptions dao = new EmployeeOptions();
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
                    System.out.println("Select among the following:\n1. Add new employee\n2. Delete an existing employee\n3. View list of all employees");
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

                if(Objects.equals(userName, "user") && Objects.equals(password, "user123")) {
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
