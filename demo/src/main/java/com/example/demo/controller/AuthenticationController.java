package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.net.http.HttpResponse;
import java.util.HashMap;
@RestController
public class AuthenticationController {

    HashMap<String, String> userStateAndCode = new HashMap<>();

    @GetMapping("/")
    String saveUserStateAndCode(@RequestParam(required = false, name = "state") String userState,@RequestParam String code) {
        if(code != null || userState != null){
            userStateAndCode.put(userState, code);
            String valueCode = userStateAndCode.get(userState);
            return "Your code is automatically used to authenticate to Zoom: " + valueCode + "\n You can close this tab now.";
    //        return "user state: " + userState + " - code: " + code;
        }
        return null;
    }

    @GetMapping("/code/{userState}")
    String getCodeByUserState(@PathVariable String userState) {
        if(userState != null){
            if(userStateAndCode.get(userState)==null)
                return "error no code found for given state";
            return userStateAndCode.get(userState);
        }
        return null;
    }
}
