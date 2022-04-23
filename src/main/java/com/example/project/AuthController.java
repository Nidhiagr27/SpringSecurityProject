package com.example.project;

import com.example.project.dto.UserDTO;
import com.example.project.exceptions.InvalidUserException;
import com.example.project.models.Roles;
import com.example.project.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/loginWithEmail")
    public ResponseEntity<String> loginWithEmail(@RequestParam("email") String email, @RequestParam("password") String password){
        try{
          UserDTO user= userService.authenticate(email,password);
          Date expirationDate= new Date(System.currentTimeMillis()+1*60*60*1000);
          String secret="HELLO";
          String token= Jwts.builder().setSubject(email)
                  .setAudience(user.getRole())
                  .setExpiration(expirationDate)
                  .signWith(SignatureAlgorithm.HS512,secret.getBytes()).compact();
          return ResponseEntity.status(200).body(token);
        } catch (InvalidUserException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}
