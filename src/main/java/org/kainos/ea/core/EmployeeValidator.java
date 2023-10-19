package org.kainos.ea.core;

import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.db.EmployeeDao;

import java.sql.SQLException;

public class EmployeeValidator {


    public String isValidEmployee(EmployeeRequest idToCheck) throws SQLException {

        try {
            EmployeeDao employeeDao = new EmployeeDao();

            Employee employee = employeeDao.getEmployeeByID(idToCheck);

            return employee != null;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return isValidEmployee(idToCheck);
    }

}
