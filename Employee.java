package com.company;

public class Employee {
    int id;
    String fname, lname, email, salary, contactNumber;

    public Employee(int id, String fname, String lname, String email, String salary, String contactNumber) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.salary = salary;
        this.contactNumber = contactNumber;
    }

    public Employee(){
    }

}
