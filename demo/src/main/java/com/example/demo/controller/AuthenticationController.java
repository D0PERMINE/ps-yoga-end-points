package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @GetMapping("/authenticationHello")
    String helloAuth() {
        return "Hello AuthenticationController!";
    }

    @GetMapping("/authenticationBye")
    String byeAuth() {
        return "Bye AuthenticationController!";
    }
}
