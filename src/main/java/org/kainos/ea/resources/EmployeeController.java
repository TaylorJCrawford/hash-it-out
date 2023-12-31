package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.EmployeeService;
import org.kainos.ea.cli.Employee;
import org.kainos.ea.client.EmployeeDoesNotExistException;
import org.kainos.ea.client.FailedToGetEmployeeException;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.client.DeliveryEmployeeCouldNotBeCreatedException;
import org.kainos.ea.client.EmployeeRequestIsNotValid;
import org.kainos.ea.client.FailedToGetEmployeeException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
        } catch (FailedToGetEmployeeException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/employee/delivery")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmployeesDeliveryEmployees () {
        try {
            return Response.ok().entity(employeeService.getAllDeliveryEmployees()).build();
        } catch (FailedToGetEmployeeException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/employee/delivery")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNewEmployee (EmployeeRequest employeeRequest) {

        try {
            return Response.ok().entity(employeeService.createNewEmployee(employeeRequest)).build();
        } catch (EmployeeRequestIsNotValid e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (DeliveryEmployeeCouldNotBeCreatedException | SQLException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/employee/delivery/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeliveryEmployeeByID (@PathParam("id") int id) {
        try {
            return Response.ok().entity(employeeService.getDeliveryEmployeeByID(id)).build();

        }catch (EmployeeDoesNotExistException e){
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (FailedToGetEmployeeException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }
    }

}


