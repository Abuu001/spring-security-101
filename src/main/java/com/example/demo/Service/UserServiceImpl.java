package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Exception.EmailAlreadyExistsException;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder pwdEncoder;

    @Override
    public Long saveUser(User user) throws EmailAlreadyExistsException {
        //TODO : Encode password
        user.setPassword(pwdEncoder.encode(user.getPassword()));

        String email = userRepository.findByEmail(user.getEmail());

        if(user.getEmail().equals(email)){
            throw new EmailAlreadyExistsException("Email is already taken 🚫🚫🚫");
        }

        return userRepository.save(user).getId();
    }
}
