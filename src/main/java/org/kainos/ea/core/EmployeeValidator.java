package org.kainos.ea.core;

import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.db.EmployeeDao;

import java.sql.SQLException;

public class EmployeeValidator {


    public String isValidEmployee(int id) throws SQLException {
        EmployeeDao employeeDao = new EmployeeDao();

        Employee employee = employeeDao.getEmployeeByID(id);

        if (employee == null) {
            return "EmployeeID invalid";
        }

        return null;
    }

}
