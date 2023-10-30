package com.example.alpha.requests;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Data
@Component
public class PetRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String ownerName;
}
