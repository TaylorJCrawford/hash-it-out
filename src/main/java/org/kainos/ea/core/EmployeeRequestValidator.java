package org.kainos.ea.core;

import org.kainos.ea.cli.EmployeeRequest;

public class EmployeeRequestValidator {


    public String isEmployeeValid (EmployeeRequest employeeRequest) {

        System.out.println(employeeRequest.getfName());
        System.out.println(employeeRequest.getlName());
        System.out.println(employeeRequest.getNiNum());
        System.out.println(employeeRequest.getSalary());

        if (employeeRequest.getfName().length() > 50) {
            return "Name is greater than 50 Chars.";
        }

        if (employeeRequest.getlName().length() > 50) {
            return "Name is greater than 50 Chars.";
        }

        if (employeeRequest.getNiNum().length() == 9) {
            return "National isn num is not equal";
        }

        if (employeeRequest.getSalary() < 0) {
            return "Price is less than £0";
        }

        return null;
    }
}
