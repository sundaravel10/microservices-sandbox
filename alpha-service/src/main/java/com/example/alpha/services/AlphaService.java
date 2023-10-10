package com.example.alpha.services;


import com.example.alpha.responses.AlphaResponse;
import com.example.alpha.responses.BetaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlphaService {

    @Autowired
    private AlphaResponse alphaResponse;

   /* @Autowired
    private BetaServiceClient betaServiceClient;*/

    public AlphaResponse getGreetings(){
        alphaResponse.setMessage("Hello User! I am alpha!");
        return alphaResponse;
    }

  /*  public AlphaResponse checkBetaStatus() {
        BetaResponse betaResponse = betaServiceClient.getStatus();
        alphaResponse.setMessage(betaResponse.getMessage());
        return alphaResponse;
    }*/
}
