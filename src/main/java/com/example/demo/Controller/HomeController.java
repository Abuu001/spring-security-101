package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "This is home page";
    }

    @GetMapping("/admin")
    public String admin(){
        return "This is admin page";
    }

}
