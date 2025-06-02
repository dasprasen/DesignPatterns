package com.solid_principles.single_responsibility;

// A class should have only one reason to change, meaning it should have only one responsibility or job.
public class Employee_Bad {
    private String name;
    private double salary;

    // Responsibility 1: Data management
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Responsibility 2: Database operations
    public void saveEmployee() {
        System.out.println("saving emp to DB..");
    }

    // Responsibility 3: Report generation
    public void generatePayslip() {
        System.out.println("generating payslip for: " + name);
    }

}
