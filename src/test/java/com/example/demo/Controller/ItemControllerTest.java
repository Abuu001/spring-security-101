package com.example.demo.Controller;

import com.example.demo.Entity.Item;
import com.example.demo.Service.ItemBusinesService;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class) //JUnit 5
@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinesService itemBusinesService;

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

    @Test
    void itemFromBusinessService() throws Exception {

        when(itemBusinesService.retrieveHardCodedItem()).thenReturn(new Item(2,"Laptop",77,6,4));

        RequestBuilder request= MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                //   .andExpect(status().isOk())
                 //.andExpect(content().json("{"id":1,"name":"Ball","price":10,"quantity":100}"))
                .andReturn();

        assertEquals("{\"id\":2,\"name\":\"Laptop\",\"price\":77,\"quantity\":6}",result.getResponse().getContentAsString());

    }

    @Test
    void allItems() throws Exception {

        when(itemBusinesService.retrieveAllItems()).thenReturn(
                Arrays.asList(new Item(15,"Pencil",11,20,220))
        );

        RequestBuilder request= MockMvcRequestBuilders
                .get("/all-items-from-dabatase")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                //   .andExpect(status().isOk())
                //.andExpect(content().json("[{"id":15,"name":"Pencil","price":11,"quantity":20,"value":220}]"))
                .andReturn();

        assertEquals("[{\"id\":15,\"name\":\"Pencil\",\"price\":11,\"quantity\":20,\"value\":220}]",result.getResponse().getContentAsString());

    }
}