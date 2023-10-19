package org.kainos.ea.client;

public class EmployeeDoesNotExistException extends Throwable {
    @Override
    public String getMessage(){
        return "Sorry this Employee does not exist";
    }
}
