package com.example.alpha.controllers;

import com.example.alpha.responses.AlphaResponse;
import com.example.alpha.services.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/alpha")
public class AlphaController {

    @Autowired
    AlphaService alphaService;

    @GetMapping("/hello")
    public ResponseEntity<AlphaResponse> getGreetings(){
        return ResponseEntity.ok().body(alphaService.getGreetings());
    }

  /*  @GetMapping("/check-beta")
    public ResponseEntity<AlphaResponse> checkBetaStatus(){
        return ResponseEntity.ok(alphaService.checkBetaStatus());
    }
*/

}
