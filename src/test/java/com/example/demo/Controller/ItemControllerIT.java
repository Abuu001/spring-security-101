package com.example.demo.Controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public  void contextLoads() throws JSONException {
      String response = this.testRestTemplate.getForObject("/all-items-from-dabatase",String.class);

        JSONAssert.assertEquals("[{id:15},{id:16},{id:17}]",response,false);

    }
}
