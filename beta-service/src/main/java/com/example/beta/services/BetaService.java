package com.example.beta.services;


import com.example.beta.responses.BetaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BetaService {

    private BetaResponse betaResponse;


    public BetaService(@Autowired BetaResponse betaResponse) {
        this.betaResponse = betaResponse;
    }

    public BetaResponse getGreetings(){
        betaResponse.setMessage("Hello User! I am Beta");
        return betaResponse;
    }

    public BetaResponse getStatus() {
        betaResponse.setMessage("Hi! I am Beta! I am good!");
        return betaResponse;
    }
}
