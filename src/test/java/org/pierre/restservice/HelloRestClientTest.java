package org.pierre.restservice;

import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://www.baeldung.com/jersey-jax-rs-client
 */

class HelloRestClientTest {

    @Test
    public void testClient() {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:7001//javaeetests-1.0-SNAPSHOT/api/");
        WebTarget employeeWebTarget = webTarget.path("employees/1");
        Invocation.Builder invocationBuilder = employeeWebTarget.request(MediaType.TEXT_HTML);
        Response response = invocationBuilder.get();
        System.out.println(response);

    }
}