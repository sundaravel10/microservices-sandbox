package com.example.alpha.requests;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.stereotype.Component;




@Data
@Component
public class PetRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String ownerName;
}
