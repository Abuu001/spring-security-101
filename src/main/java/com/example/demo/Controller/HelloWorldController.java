package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "HellWorld2";
    }


}
