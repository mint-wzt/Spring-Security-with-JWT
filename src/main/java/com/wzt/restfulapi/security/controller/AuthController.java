package com.wzt.restfulapi.security.controller;

import com.wzt.restfulapi.security.entity.JwtUser;
import com.wzt.restfulapi.security.entity.LoginUser;
import com.wzt.restfulapi.system.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity responseEntity(@RequestBody Map<String,String> registerUser){
        userService.saveUser(registerUser);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginUser loginUser){
    }
}
