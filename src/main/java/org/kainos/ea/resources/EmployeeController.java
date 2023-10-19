package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.EmployeeService;
import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.client.EmployeeDoesNotExistException;
import org.kainos.ea.client.FailedToUpdateEmployeeException;
import org.kainos.ea.client.InvalidEmployeeException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Api("Engineering Academy Hash It Out Employee")
@Path("/api")
public class EmployeeController {

    private EmployeeService employeeService = new EmployeeService();

    @GET
    @Path("/employee")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmployees () {
        try {
            return Response.ok().entity(employeeService.getAllEmployee()).build();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/employee/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEmployee(@PathParam("id") int id, EmployeeRequest employee){
        try{
            employeeService.updateEmployee(id, employee);
            return Response.ok().build();
        } catch (InvalidEmployeeException | EmployeeDoesNotExistException e){
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (FailedToUpdateEmployeeException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }
    }
}


