package org.kainos.ea.client;

public class EmployeeRequestIsNotValid extends Throwable {
    public EmployeeRequestIsNotValid(String isEmployeeRequestValid) {
        super(isEmployeeRequestValid);
    }
}
