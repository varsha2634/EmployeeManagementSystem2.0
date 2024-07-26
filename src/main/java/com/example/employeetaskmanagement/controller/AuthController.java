package com.example.employeetaskmanagement.controller;

import com.example.employeetaskmanagement.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public boolean login(@RequestParam String email, @RequestParam String password) {
        return authService.authenticate(email, password);
    }
}
