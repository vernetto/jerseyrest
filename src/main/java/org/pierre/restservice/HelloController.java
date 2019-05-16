package org.pierre.restservice;

import org.pierre.ejbservice.HelloService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Path("hello")
public class HelloController {
    @EJB
    HelloService helloService;

    @Produces({ MediaType.TEXT_HTML})
    @GET
    @Path("/{name}")
    public String hello(@PathParam("name") String name) {
        System.out.println(name);
        return helloService.hello(name);
    }
}
