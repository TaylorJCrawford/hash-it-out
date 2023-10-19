package org.kainos.ea.db;

import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.EmployeeRequest;

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
                    rs.getInt("employee_id"),
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

    /*Query the database using given ID to view name, salary, bank account number and national insurance number of
    * a delivery employee.*/
    public EmployeeRequest getDeliveryEmployeeByID(int id) throws SQLException {

        Connection c = databaseConnector.getConnection();

        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT f_name, l_name, salary, bank_acc_num, ni_num FROM employee INNER JOIN delivery_employee ON employee.employee_id= delivery_employee.employee_id WHERE delivery_employee.employee_id="+id);


        //While there are very valid results add them to an EmployeeRequest object. Otherwise return null.
        while (rs.next()) {
            return new EmployeeRequest(

                    rs.getString("f_name"),
                    rs.getString("l_name"),
                    rs.getDouble("salary"),
                    rs.getString("bank_acc_num"),
                    rs.getString("ni_num")

            );

        }

        return null;
    }


}
