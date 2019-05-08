package org.pierre.ejbservice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloServiceTest {

    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    void hello1() {
        HelloService helloService = new HelloService();
        System.out.println(helloService.hello());
    }

    @Test
    void hello2() {
        HelloService helloService = new HelloService();
        System.out.println(helloService.hello());
    }
}