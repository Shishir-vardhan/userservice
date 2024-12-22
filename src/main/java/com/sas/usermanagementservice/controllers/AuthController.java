package com.sas.usermanagementservice.controllers;

import com.sas.usermanagementservice.dto.LoginRequestDto;
import com.sas.usermanagementservice.dto.LogoutRequestDto;
import com.sas.usermanagementservice.dto.SignUpRequestDto;
import com.sas.usermanagementservice.dto.UserDto;
import com.sas.usermanagementservice.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {


    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpRequestDto request)
    {
        UserDto userDto = authService.singUp(request.getEmail(), request.getPassword());
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> logIn(@RequestBody LoginRequestDto request)
    {
        return authService.logIn(request.getEmail(), request.getPassword());

    }

    @PostMapping("/logout")
    public ResponseEntity<String> logOut(@RequestBody LogoutRequestDto request)
    {
        return authService.logOut(request.getToken(),request.getUserId());
    }
}
