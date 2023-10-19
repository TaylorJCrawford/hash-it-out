package org.kainos.ea.api;

import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.client.EmployeeDoesNotExistException;
import org.kainos.ea.client.FailedToUpdateEmployeeException;
import org.kainos.ea.client.InvalidEmployeeException;
import org.kainos.ea.core.EmployeeValidator;
import org.kainos.ea.db.EmployeeDao;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    private EmployeeValidator employeeValidator = new EmployeeValidator();
    private EmployeeDao employeeDao = new EmployeeDao();

    public List<Employee> getAllEmployee() throws SQLException {

        return employeeDao.getAllEmployees();
    }

public void updateEmployee(int id, EmployeeRequest employee) throws InvalidEmployeeException, EmployeeDoesNotExistException, FailedToUpdateEmployeeException {

        try{
            String validation = employeeValidator.isValidEmployee(employee);

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
