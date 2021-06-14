package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Exception.EmailAlreadyExistsException;

public interface IUserService {
    Long saveUser(User user) throws EmailAlreadyExistsException;

}
