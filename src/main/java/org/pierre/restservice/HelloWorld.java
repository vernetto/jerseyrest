package org.pierre.restservice;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * Inspired by this article https://www.baeldung.com/jersey-rest-api-with-spring
 * Endpoint is http://10.0.75.1:7001/javaeetests-1.0-SNAPSHOT/api/employees/2
 */


@Path("/employees")
public class HelloWorld {
    @Context
    private UriInfo context;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd:HHmmss");

    /**
     * Creates a new instance of HelloWorld
     */
    public HelloWorld() {
    }

  

    /**
     * Retrieves representation of an instance of helloWorld.HelloWorld
     *
     * @return an instance of java.lang.String
     */


    //@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_XML })
    @GET
    @Path("/{id}")
    public Employee getEmployee(@PathParam("id") int id) {
        System.out.println(simpleDateFormat.format(new Date()) + "getEmployee " + id);
        Employee employee = new Employee(id, "pierre" + id);
        System.out.println("returning " + employee);
        return employee;
    }

}
