package com.solid_principles.single_responsibility.goodExample;

public class PayslipGenerator {
    public void generatePayslip(Employee employee) {
        System.out.println("Generating payslip for " + employee.getName());
    }
}
