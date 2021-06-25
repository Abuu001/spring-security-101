package com.example.demo.Controller;

import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

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
}
