package org.kainos.ea.api;

import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.client.*;
import org.kainos.ea.core.EmployeeRequestValidator;
import org.kainos.ea.core.EmployeeValidator;
import org.kainos.ea.db.EmployeeDao;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    private EmployeeValidator employeeValidator = new EmployeeValidator();
    private EmployeeDao employeeDao = new EmployeeDao();
    private EmployeeRequestValidator employeeRequestValidator = new EmployeeRequestValidator();

     public List<EmployeeRequest> getAllDeliveryEmployees() throws FailedToGetEmployeeException {
        List<EmployeeRequest> deliveryEmployeeList = null;
        try {
            deliveryEmployeeList = employeeDao.getAllDeliveryEmployees();



        } catch (SQLException e) {
            System.out.println(e.getMessage());

            throw new FailedToGetEmployeeException();
        }
         return deliveryEmployeeList;
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


    public int createNewEmployee(EmployeeRequest employeeRequest) throws EmployeeRequestIsNotValid, SQLException, DeliveryEmployeeCouldNotBeCreatedException {


         String isEmployeeRequestValid = employeeRequestValidator.isEmployeeValid(employeeRequest);
         if (isEmployeeRequestValid != null) {
                throw new EmployeeRequestIsNotValid(isEmployeeRequestValid);
            }
            return employeeDao.createNewEmployee(employeeRequest);

    }


    public EmployeeRequest getDeliveryEmployeeByID(int id) throws FailedToGetEmployeeException, EmployeeDoesNotExistException {
        try {
            EmployeeRequest employee = employeeDao.getDeliveryEmployeeByID(id);

            if (employee == null) {
                throw new EmployeeDoesNotExistException();
            }
            return employee;
        } catch (SQLException e) {

            System.err.println(e.getMessage());
            throw new FailedToGetEmployeeException();


        }
    }

    public void updateEmployee(int id, EmployeeRequest employee) throws InvalidEmployeeException, EmployeeDoesNotExistException, FailedToUpdateEmployeeException {

        try{
            String validation = employeeValidator.isValidEmployee(id);

            if (validation!=null){
                throw new InvalidEmployeeException(validation);
            }

            Employee employeeToUpdate = employeeDao.getEmployeeByID(id);

            if (employeeToUpdate == null){
                throw new EmployeeDoesNotExistException();
            }
            employeeDao.updateEmployee(id, employee);

        } catch (SQLException e){
            System.err.println(e.getMessage());

            throw new FailedToUpdateEmployeeException();
        }
    }
}
