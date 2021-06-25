package com.example.demo.Controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
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
@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void dummyItem() throws Exception {
        //call GET to /api/v2/hello-world --> application.json format
        RequestBuilder request= MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                //   .andExpect(status().isOk())
               // .andExpect(content().json("{"id":1,"name":"Ball","price":10,"quantity":100}"))
                .andReturn();

        //verify hello world
        assertEquals("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}",result.getResponse().getContentAsString());

    }

}