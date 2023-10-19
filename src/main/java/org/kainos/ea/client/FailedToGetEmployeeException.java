package org.kainos.ea.client;

public class FailedToGetEmployeeException extends Throwable {
    @Override
    public String getMessage(){
        return "Failed to get Employee from the database";
    }
}
