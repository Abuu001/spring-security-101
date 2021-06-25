package com.example.demo.Controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class) //JUnit 5
@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {

    @Autowired
    private  MockMvc mockMvc;

    @Test
    void helloWorldBasicTest() throws Exception {
        //call GET to /api/v2/hello-world --> application.json format
        RequestBuilder request= MockMvcRequestBuilders
                                .get("/api/v2/hello-world")
                                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                       //   .andExpect(status().isOk())
                       //   .andExpect(content().string("HellWorld2"))
                           .andReturn();

        //verify hello world
        assertEquals("HellWorld2",result.getResponse().getContentAsString());
    }
}
