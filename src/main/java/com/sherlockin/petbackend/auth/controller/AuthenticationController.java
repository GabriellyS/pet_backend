package com.sherlockin.petbackend.auth.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sherlockin.petbackend.auth.service.AuthenticationService;
import com.sherlockin.petbackend.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserService userService;

    public AuthenticationController(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(Authentication authentication) {
        return ResponseEntity.ok(authenticationService.authenticate(authentication));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserRecord registerUserRecord) {
        userService.registerUser(
                registerUserRecord.email(),
                registerUserRecord.document(),
                registerUserRecord.firstName(),
                registerUserRecord.lastName(),
                registerUserRecord.password(),
                registerUserRecord.phone(),
                registerUserRecord.address()
            );
        return ResponseEntity.ok().build();
    }

}
