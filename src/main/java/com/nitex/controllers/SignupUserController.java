package com.nitex.controllers;

import com.nitex.dtos.SignupRequest;
import com.nitex.dtos.UserDTO;
import com.nitex.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupUserController {

    @Autowired
    private AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> createUser(@RequestBody SignupRequest signupRequest) {
        UserDTO createdUser = authService.createUser(signupRequest);

        if(createdUser == null)
            return new ResponseEntity<>("User is not created", HttpStatus.BAD_REQUEST);


        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
