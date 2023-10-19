package org.kainos.ea.client;

public class DeliveryEmployeeDoesNotExistException extends Throwable {
    @Override
    public String getMessage() {
        return "Delivery employee does not exist";
    }
}
