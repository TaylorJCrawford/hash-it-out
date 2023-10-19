package org.kainos.ea.core;

import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.db.EmployeeDao;

import java.sql.SQLException;

public class EmployeeValidator {


    // call ViewAllEmployees to get Array and loop through it
    public boolean isValidEmployee(int idToCheck) throws SQLException {

        EmployeeDao employeeDao = new EmployeeDao();

        int[] employeelist = employeeDao.viewAllEmployees();

        for (int id : employeelist) {

            if (id == idToCheck) {

                return true;
            }

        }
        return false;
    }
}
