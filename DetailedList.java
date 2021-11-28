package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class DetailedList {
    public void displayDetails(int id, String fname, String lname, String email, String salary, String contact) throws IOException {
        //An arraylist is created and Employee objects are added to it
        ArrayList<Employee> list = new ArrayList<>();
        Employee emp = new Employee(id, fname, lname, email, salary, contact);
        list.add(emp);

        //The list is being traversed using 'advanced-for' loop
        for(Employee e : list){
            System.out.println();
            System.out.println("First Name: "+e.fname);
            System.out.println("Last Name: "+e.lname);
            System.out.println("Email ID: "+e.email);
            System.out.println("Salary: "+e.salary);
            System.out.println("Contact Number: "+e.contactNumber);
        }
    }
}
