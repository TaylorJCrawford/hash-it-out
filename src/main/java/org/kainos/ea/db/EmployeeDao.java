package org.kainos.ea.db;

import org.kainos.ea.cli.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    private DatabaseConnector databaseConnector = new DatabaseConnector();

    public List<Employee> getAllEmployees() throws SQLException {

        Connection c = databaseConnector.getConnection();

        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM employee;");

        List<Employee> employeeList = new ArrayList<>();

        while (rs.next()) {
            Employee employee = new Employee(
                    rs.getInt("id"),
                    rs.getString("f_name"),
                    rs.getString("l_name"),
                    rs.getDouble("salary"),
                    rs.getString("bank_acc_num"),
                    rs.getString("ni_num")
            );

            employeeList.add(employee);
        }

        return employeeList;
    }
}
