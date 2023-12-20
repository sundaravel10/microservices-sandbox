package com.example.alpha.util;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class PetData {

    @NotBlank
    String name;

    @NotBlank
    String ownerName;

}
