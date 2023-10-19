package org.kainos.ea.client;

public class DeliveryEmployeeCouldNotBeCreatedException extends Throwable {

    @Override
    public String getMessage() {
        return "Could Not Create New Delivery Employee";
    }
}
