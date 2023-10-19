package org.kainos.ea.api;

import org.kainos.ea.cli.Employee;
import org.kainos.ea.db.EmployeeDao;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDao();

    public List<Employee> getAllEmployee() throws SQLException {

        return employeeDao.getAllEmployees();
    }
}
