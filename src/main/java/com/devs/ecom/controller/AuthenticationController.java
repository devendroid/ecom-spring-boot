package com.devs.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devs.ecom.dto.LoginRespDto;
import com.devs.ecom.dto.UserLoginReqDto;
import com.devs.ecom.dto.UserRegisterReqDto;
import com.devs.ecom.entity.User;
import com.devs.ecom.entity.UserPrincipal;
import com.devs.ecom.service.AuthenticationService;
import com.devs.ecom.service.JwtService;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    private final JwtService jwtService;
    
    public AuthenticationController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody UserRegisterReqDto userRegisterReqDto) {
        User registeredUser = authenticationService.signup(userRegisterReqDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginRespDto> authenticate(@RequestBody UserLoginReqDto userLoginReqDto) {
        User authenticatedUser = authenticationService.authenticate(userLoginReqDto);

        String jwtToken = jwtService.generateToken(new UserPrincipal(authenticatedUser));

        LoginRespDto loginResponse = new LoginRespDto().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}