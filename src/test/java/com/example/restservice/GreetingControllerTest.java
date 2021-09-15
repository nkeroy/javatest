package com.example.restservice;

import org.apache.catalina.filters.ExpiresFilter;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(GreetingController.class)
class GreetingControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private GreetingController controller;

    @BeforeEach
    void setUp() {
        this.controller = new GreetingController();
    }


    @AfterEach
    void tearDown() {
        System.out.println("Test over");
    }

    @Test
    void defaultGreetingTest() throws Exception {
        //Greeting greeting = controller.greeting(null);
        mvc.perform(get("/greeting")).andExpect(content().string(containsString("Hello, World")));
    }
}