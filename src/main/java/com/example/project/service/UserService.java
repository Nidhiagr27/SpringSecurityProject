package com.example.project.service;

import com.example.project.accessor.UserAccessor;
import com.example.project.dto.UserDTO;
import com.example.project.exceptions.InvalidUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserService {
    @Autowired
    private UserAccessor userAccessor;

    public UserDTO authenticate(String email, String password) throws InvalidUserException {
        UserDTO user= userAccessor.findByEmail(email);
        if(user != null){
            if(user.getPassword().equals(password)){
                return user;
            }
            else{
              throw new InvalidUserException("User with "+ email+" has wrong password");
            }
        }
        else{
            throw new InvalidUserException("User with "+email+" doesn't exist");
        }
    }
}
