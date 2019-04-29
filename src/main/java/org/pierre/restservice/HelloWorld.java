package org.pierre.restservice;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * http://localhost:7001/javaeetests-1.0-SNAPSHOT/api/helloworld
 */


@Path("helloworld")

public class HelloWorld {
    @Context
    private UriInfo context;

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
    @GET
    @Produces("text/html")
    public String getHtml() {
        System.out.println("getHtml");
        return "<html lang=\"en\"><body><h1>Hello, World!!</h1></body></html>";
    }

    @POST
    @Consumes("text/plain")
    public void postHtml(String message) {
        System.out.println("postHtml " + message);
    }
}
