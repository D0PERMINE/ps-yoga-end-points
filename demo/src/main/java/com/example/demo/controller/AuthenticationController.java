package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class AuthenticationController {

    HashMap<String, String> userStateAndCode = new HashMap<>();

    @GetMapping()
    String saveUserStateAndCode(@RequestParam(required = false, name = "state") String userState,@RequestParam(required = false) String code) {
        if(code != null || userState != null){
            userStateAndCode.put(userState, code);
            String valueCode = userStateAndCode.get(userState);
            return valueCode;
    //        return "user state: " + userState + " - code: " + code;
        }
        return null;
    }

    @GetMapping("/{userState}")
    String getCodeByUserState(@PathVariable String userState) {
        if(userState != null){
            return userStateAndCode.get(userState);
        }
        return null;
    }
}
