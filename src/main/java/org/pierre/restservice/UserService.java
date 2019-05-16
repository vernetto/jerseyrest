package org.pierre.restservice;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 http://10.0.75.1:7001/javaeetests-1.0-SNAPSHOT/api/users/get
 */

@Path("/users")
public class UserService {

    @GET
    @Path("/get")
    public Response addUser(@HeaderParam("user-agent") String userAgent) {

        return Response.status(200)
                .entity("addUser is called, userAgent : " + userAgent)
                .build();

    }

    @GET
    @Path("/get2")
    public Response addUser2(@Context HttpHeaders headers) {

        String userAgent = headers.getRequestHeader("user-agent").get(0);

        return Response.status(200)
                .entity("addUser2 is called, userAgent : " + userAgent)
                .build();

    }

    public Response addUser3(@Context HttpServletRequest httpServletRequest ) {
        String userAgent = httpServletRequest .getHeader("user-agent");
        return Response.status(200)
                .entity("addUser3 is called, userAgent : " + userAgent)
                .build();
    }



}
