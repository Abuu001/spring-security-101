package com.example.demo.Controller;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JsonAssert {

    @Test
    @DisplayName("checks  if the json strings   match")
    public void shouldReturnJsonString_StrictToTrue() throws JSONException {
        String actualResponse ="{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

        String expectedResponse ="{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

        JSONAssert.assertEquals(expectedResponse,actualResponse,true);
    }

    @Test
    public void shouldReturnJsonString_StrictToFalse() throws JSONException {
        String actualResponse ="{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

        String expectedResponse ="{\"id\":1,\"name\":\"Ball\"}"; //incomplete json

        JSONAssert.assertEquals(expectedResponse,actualResponse,false); //when 3rd param is false you can have json which is not full(completed)
    }

    @Test
    public void workingWithJSON(){
        // JSONPath https://github.com/json-path/JsonPath
        //guide to testing reference http://xunitpatterns.com/

        String responseFromService = "[{\"id\":15,\"name\":\"Pencil\",\"price\":11,\"quantity\":20,\"value\":220}," +
                "{\"id\":16,\"name\":\"Book\",\"price\":6,\"quantity\":21,\"value\":126}," +
                "{\"id\":17,\"name\":\"Ruler\",\"price\":9,\"quantity\":22,\"value\":198}," +
                "{\"id\":18,\"name\":\"Set\",\"price\":4,\"quantity\":33,\"value\":132}]";

        DocumentContext context =JsonPath.parse(responseFromService);
        int length = context.read("$.length()");

        assertThat(length).isEqualTo(4);

        //reading the id's ---> [15,16,17,18]
        System.out.println(context.read("$..id").toString());

        //reading names from id;s  ---> ["Pencil","Book","Ruler","Set"]
        System.out.println(context.read("$..name").toString());


    }
}
