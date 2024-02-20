package com.example.alpha.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenValidationResponse {
    @JsonProperty("active")
    public Boolean isActive;

    public boolean getIsActive(){
        return isActive;
    }

}
