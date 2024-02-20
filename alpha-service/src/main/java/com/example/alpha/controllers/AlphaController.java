package com.example.alpha.controllers;

import com.example.alpha.requests.PortfolioDataRequest;
import com.example.alpha.responses.AlphaResponse;
import com.example.alpha.responses.PortfolioResponse;
import com.example.alpha.services.AlphaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alpha")
public class AlphaController {

    @Autowired
    AlphaService alphaService;


    @Operation(summary = "Greeting Message URL", description = "Upon request API responds with greeting message")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Greetings received successfully"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/hello")
    public ResponseEntity<AlphaResponse> getGreetings(){
        return ResponseEntity.ok().body(alphaService.getGreetings());
    }

    @GetMapping("/getall/portfolio/data")
    public ResponseEntity<PortfolioResponse> getAllPortfolioData(){
        PortfolioResponse portfolioResponse = alphaService.getAllData();
        return ResponseEntity.ok(portfolioResponse);
    }

    @PostMapping("/put/portfolio/data")
    public ResponseEntity<PortfolioResponse> putPortfolioData(@RequestBody PortfolioDataRequest portfolioDataRequest){
        PortfolioResponse portfolioResponse = alphaService.putData(portfolioDataRequest.getPortfolioDataList());
        return ResponseEntity.ok(portfolioResponse);
    }

}
