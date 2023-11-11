package com.billionairestore.authservice.controllers;

import com.billionairestore.authservice.entities.AuthRequest;
import com.billionairestore.authservice.entities.AuthResponse;
import com.billionairestore.authservice.entities.UserAuthRepository;
import com.billionairestore.authservice.entities.UserEntity;
import com.billionairestore.authservice.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    private final AuthService authService;
    private final UserAuthRepository userAuthRepository;
    @Autowired
    public AuthController(final AuthService authService, final UserAuthRepository userAuthRepository){
        this.authService = authService;
        this.userAuthRepository = userAuthRepository;
    }
    @PostMapping(value = "/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        UserEntity result = userAuthRepository.findByUsernameAndPassword(authRequest.getUsername(), authRequest.getPassword());
        if (result != null){
            return ResponseEntity.ok(authService.logIn(result));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
