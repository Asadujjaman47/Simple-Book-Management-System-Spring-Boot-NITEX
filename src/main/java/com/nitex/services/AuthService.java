package com.nitex.services;

import com.nitex.dtos.SignupRequest;
import com.nitex.dtos.UserDTO;

public interface AuthService {
    UserDTO createUser(SignupRequest signupRequest);
}
