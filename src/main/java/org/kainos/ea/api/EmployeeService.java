package org.kainos.ea.api;

import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.client.DeliveryEmployeeCouldNotBeCreatedException;
import org.kainos.ea.client.EmployeeRequestIsNotValid;
import org.kainos.ea.client.FailedToGetEmployeeException;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.client.DeliveryEmployeeCouldNotBeCreatedException;
import org.kainos.ea.client.EmployeeRequestIsNotValid;
import org.kainos.ea.core.EmployeeRequestValidator;
import org.kainos.ea.db.EmployeeDao;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDao();
    private EmployeeRequestValidator employeeRequestValidator = new EmployeeRequestValidator();

     public List<EmployeeRequest> getAllDeliveryEmployees() throws FailedToGetEmployeeException {
        List<EmployeeRequest> deliveryEmployeeList = null;
        try {
            deliveryEmployeeList = employeeDao.getAllDeliveryEmployees();

            return deliveryEmployeeList;

        } catch (SQLException e) {
            System.out.println(e.getMessage());

            throw new FailedToGetEmployeeException();
        }

    }

    public List<Employee> getAllEmployee() throws FailedToGetEmployeeException {

         List<Employee> employeeList = null;

        try {
            employeeList = employeeDao.getAllEmployees();
        } catch (SQLException e) {
            throw new FailedToGetEmployeeException();
        }

        return employeeList;
    }


    public int createNewEmployee(EmployeeRequest employeeRequest) throws EmployeeRequestIsNotValid, SQLException {

        try {
            String isEmployeeRequestValid = employeeRequestValidator.isEmployeeValid(employeeRequest);
            System.out.println("--------------------- TAYLOR HERE");
            if (isEmployeeRequestValid != null) {
                System.out.println("--------------------- TAYLOR22 HERE");
                throw new EmployeeRequestIsNotValid(isEmployeeRequestValid);
            }
            return employeeDao.createNewEmployee(employeeRequest);
        } catch (DeliveryEmployeeCouldNotBeCreatedException e) {
            throw new EmployeeRequestIsNotValid(e.getMessage());
        }
    }
}
