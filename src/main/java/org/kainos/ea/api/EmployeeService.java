package org.kainos.ea.api;

import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.client.EmployeeDoesNotExistException;
import org.kainos.ea.client.FailedToGetEmployeeException;
import org.kainos.ea.db.EmployeeDao;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDao();

    public List<Employee> getAllEmployee() throws SQLException {

        return employeeDao.getAllEmployees();
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


    }
