package org.kainos.ea.db;

import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.EmployeeRequest;

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

// Add validator to get all employees, loop through array to check if employee is in db
    public Employee getEmployeeByID(int id) throws SQLException{
        Connection c = databaseConnector.getConnection();


        String insertStatement = ("SELECT employee_id, f_name, l_name, salary, bank_acc_num, ni_num" +
                " FROM employee WHERE employee_id=?");

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

                    st.setInt(1, id);

        st.executeQuery();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()){
            Employee employee = new Employee(
                    rs.getInt("employee_id"),
                    rs.getString("f_name"),
                    rs.getString("l_name"),
                    rs.getDouble("salary"),
                    rs.getString("bank_acc_num"),
                    rs.getString("ni_num")
            );
            return employee;
        }
        return null;
    }

    // Getting array of employeeIDs so validator can loop through and check if employee is valid
// public  viewAllEmployees() throws SQLException {
//        Connection c = databaseConnector.getConnection();
//
//        Statement st = c.createStatement();
//
//        ResultSet rs = st.executeQuery("SELECT employee_id FROM employee");
//
//        List<Integer> employeeIds = new ArrayList<>();
//
//        while (rs.next()) {
//            int employeeId = rs.getInt("employee_id");
//            employeeIds.add(employeeId);
//        }
//
//        // Convert the List to an int[] array
//        int[] employeeIdsArray = new int[employeeIds.size()];
//        for (int i = 0; i < employeeIds.size(); i++) {
//            employeeIdsArray[i] = employeeIds.get(i);
//        }
//
//        return employeeIdsArray;
//    }




    public void updateEmployee(int id, EmployeeRequest employee) throws SQLException{

   Connection c = databaseConnector.getConnection();

   String updateStatement = "UPDATE employee SET f_name = ?, l_name = ?, salary = ?, bank_acc_num =? RIGHT JOIN delivery_employee on employee.employee_id = delivery_employee.employee_id WHERE employee_id = ? ";

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setString(1, employee.getF_Name());
        st.setString(2, employee.getL_Name());
        st.setDouble(3, employee.getSalary());
        st.setString(4, employee.getBank_Acc_Num());
        st.setInt(5, id);

        st.executeUpdate();

    }
}
