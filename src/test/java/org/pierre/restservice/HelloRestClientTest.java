package org.pierre.restservice;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://www.baeldung.com/jersey-jax-rs-client
 */

class HelloRestClientTest {
    private static final int N_THREADS = 10;
    private Logger logger = LoggerFactory.getLogger(HelloRestClientTest.class);

    private  static final String TARGET_URL_WILDFLY = "http://localhost:9080/javaeetests-1.0-SNAPSHOT/api/";
    private  static final String TARGET_URL_WEBLOGIC = "http://localhost:7001/javaeetests-1.0-SNAPSHOT/api/";

    @Test
    void testClient() {
        runInParallel();
    }

    private void invokeOnce() {
        logger.info("invoking service");
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(TARGET_URL_WEBLOGIC);
            WebTarget employeeWebTarget = webTarget.path("employees/1");
            Invocation.Builder invocationBuilder = employeeWebTarget.request(MediaType.APPLICATION_XML);
            Response response = invocationBuilder.get();
            logger.info("done invoking service");
            logger.info(response.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void runInParallel() {
        ExecutorService executorService = Executors.newFixedThreadPool(N_THREADS);
        Runnable runnable = () -> {
            invokeOnce();
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        logger.info("executing runnable");

        IntStream.range(0, N_THREADS).forEach((i) -> executorService.execute(runnable));

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("shutting down executor");
        List<Runnable> notExecutedTasks = executorService.shutdownNow();
        logger.info("done executing runnable");
    }

}