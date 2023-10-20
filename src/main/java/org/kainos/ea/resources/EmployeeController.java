package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.EmployeeService;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.client.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

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

    @PUT
    @Path("/employee/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEmployee(@PathParam("id") int id, EmployeeRequest employee) {
        try {
            employeeService.updateEmployee(id, employee);
            return Response.ok().build();
        } catch (InvalidEmployeeException | EmployeeDoesNotExistException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (FailedToUpdateEmployeeException e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/employee/delivery")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmployeesDeliveryEmployees() {
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


