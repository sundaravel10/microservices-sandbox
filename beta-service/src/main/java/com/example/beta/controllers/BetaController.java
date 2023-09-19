package com.example.beta.controllers;

import com.example.beta.responses.BetaResponse;
import com.example.beta.services.BetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/beta")
public class BetaController {

    private final BetaService betaService;

    public BetaController(@Autowired BetaService betaService) {
        this.betaService = betaService;
    }

    @GetMapping("/hello")
    public ResponseEntity<BetaResponse> getGreetings(){
        return ResponseEntity.ok().body(betaService.getGreetings());
    }

    @GetMapping("/getStatus")
    public ResponseEntity<BetaResponse> getStatus(){
        return ResponseEntity.ok().body(betaService.getStatus());
    }
}
