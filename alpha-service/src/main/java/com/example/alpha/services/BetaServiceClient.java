package com.example.alpha.services;


import com.example.alpha.responses.BetaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "beta-service")
public interface BetaServiceClient {

    @GetMapping(value = "/api/beta/getStatus")
    BetaResponse getStatus();
}
