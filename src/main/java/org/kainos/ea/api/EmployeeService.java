package org.kainos.ea.api;

import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.client.DeliveryEmployeeDoesNotExistException;
import org.kainos.ea.client.EmployeeDoesNotExistException;
import org.kainos.ea.client.FailedToDeleteEmployeeException;
import org.kainos.ea.client.FailedToGetEmployeeException;
import org.kainos.ea.db.EmployeeDao;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDao();

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

    public void deleteDeliveryEmployee(int id) throws DeliveryEmployeeDoesNotExistException, FailedToDeleteEmployeeException {
        try {
            Employee employeeToDelete = employeeDao.getDeliveryEmployeeById(id);

            if(employeeToDelete == null) {
                throw new DeliveryEmployeeDoesNotExistException();
            }

            employeeDao.deleteDeliveryEmployee(id);
        } catch (SQLException e) {
            throw new FailedToDeleteEmployeeException();
        }

    }


}
