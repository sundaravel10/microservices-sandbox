package com.example.alpha.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginCallBackController {

    @GetMapping("/login/oauth2/code/cognito")
    public String handleCallback(@RequestParam("code") String code) {
        // Implement logic to exchange the code for tokens
        // Redirect or respond as needed

        return "redirect:/success";
    }

    @GetMapping("/success")
    public String successPage() {

        return "Login Successful. Hit the required endpoint now with Token";
    }
}
