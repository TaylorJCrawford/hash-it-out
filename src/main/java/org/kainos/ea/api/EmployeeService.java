package org.kainos.ea.api;

import org.kainos.ea.cli.Employee;
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

    public List<Employee> getAllEmployee() throws SQLException {

        return employeeDao.getAllEmployees();
    }

    public int createNewEmployee(EmployeeRequest employeeRequest) throws EmployeeRequestIsNotValid, SQLException {

        try {
            String isEmployeeRequestValid = employeeRequestValidator.isEmployeeValid(employeeRequest);

            if (isEmployeeRequestValid != null) {
                throw new EmployeeRequestIsNotValid(isEmployeeRequestValid);
            }
            return employeeDao.createNewEmployee(employeeRequest);
        } catch (DeliveryEmployeeCouldNotBeCreatedException e) {
            throw new EmployeeRequestIsNotValid(e.getMessage());
        }
    }
}
