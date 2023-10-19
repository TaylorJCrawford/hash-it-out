package org.kainos.ea.db;

import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.client.DeliveryEmployeeCouldNotBeCreatedException;

import java.sql.*;
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

    public int createNewEmployee(EmployeeRequest employeeRequest) throws SQLException, DeliveryEmployeeCouldNotBeCreatedException {

        try {
            Connection c = databaseConnector.getConnection();

            String insertStatement = "INSERT INTO employee (f_name, l_name, salary, bank_acc_num, ni_num) " +
                    "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, employeeRequest.getfName());
            st.setString(2, employeeRequest.getlName());
            st.setDouble(3, employeeRequest.getSalary());
            st.setString(4, employeeRequest.getBankAccNum());
            st.setString(5, employeeRequest.getNiNum());

            st.executeUpdate();

            ResultSet rs = st.getGeneratedKeys();


            if (rs.next()) {

                System.out.println("Adding New Employee Delivery.");

                // Add New Create ID To Employee_delivery Table
                int newlyCreatedIDEmployeeTable = rs.getInt(1);
                ResultSet rsEmployeeDelivery;

                insertStatement = "INSERT INTO delivery_employee (employee_id) " +
                        "VALUES (?)";

                st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

                st.setInt(1, newlyCreatedIDEmployeeTable);

                rsEmployeeDelivery = st.getGeneratedKeys();

                if (rsEmployeeDelivery != null) {
                    return newlyCreatedIDEmployeeTable;
                }

                // Failed to add employee to delivery_employee
                System.err.println("Delivery Employee Could Not Be Added. Removing From Employee Table.");

                // Need to remove employee from table.
                String deleteStatement = "DELETE FROM employee WHERE employee_id = ?";
                st = c.prepareStatement(deleteStatement);
                st.setInt(1, newlyCreatedIDEmployeeTable);
                st.executeUpdate();
                throw new DeliveryEmployeeCouldNotBeCreatedException();
            }

            // Error - Could not add employee to table.
            throw new DeliveryEmployeeCouldNotBeCreatedException();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new SQLException();
        }
    }

    public List<EmployeeRequest> getAllDeliveryEmployees() throws SQLException {

        Connection c = databaseConnector.getConnection();

        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT f_name, l_name, salary, bank_acc_num, ni_num FROM employee " +
                "INNER JOIN delivery_employee " +
                "ON employee.employee_id = delivery_employee.employee_id;");

        List<EmployeeRequest> deliveryEmployeeList = new ArrayList<>();

        while (rs.next()) {
            EmployeeRequest employee = new EmployeeRequest(
                    rs.getString("f_name"),
                    rs.getString("l_name"),
                    rs.getDouble("salary"),
                    rs.getString("bank_acc_num"),
                    rs.getString("ni_num")
            );

            deliveryEmployeeList.add(employee);
        }

        return deliveryEmployeeList;
    }

}