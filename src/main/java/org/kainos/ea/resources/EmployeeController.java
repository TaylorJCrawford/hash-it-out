package org.kainos.ea.resources;

import org.kainos.ea.api.EmployeeService;
import org.kainos.ea.cli.Employee;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/api")
public class EmployeeController {

    private EmployeeService employeeService = new EmployeeService();

    @GET
    @Path("/employee")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmployees () {
        try {
            List<Employee> employeeList = employeeService.getAllEmployee();
            Response.ok(employeeList).build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}


