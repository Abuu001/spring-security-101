package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Exception.EmailAlreadyExistsException;
import com.example.demo.Service.UserServiceImpl;
import com.example.demo.Utils.JwtUtil;
import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody User user) throws EmailAlreadyExistsException {

        Long id = userService.saveUser(user);
        String body = String.format("User %s saved successfully 🤪🤪🤪🤪",id);

        /*return new ResponseEntity<String>(body,HttpStatus.OK);
        or
        */
        return  ResponseEntity.ok(body);
    }

    //validate user and generate token
    @PostMapping("/login")
     public ResponseEntity<UserResponse>  loginUser(@NotNull @RequestBody UserRequest userRequest){

        //TODO : validate usern /pass with db
        String token = jwtUtil.generateToken(userRequest.getUsername());
        return ResponseEntity.ok(new UserResponse(token,"Success 🥳🥳🥳🥳"));
     }
}
