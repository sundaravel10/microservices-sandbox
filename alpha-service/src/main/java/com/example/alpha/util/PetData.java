package com.example.alpha.util;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class PetData {

    @NotBlank
    String name;

    @NotBlank
    String ownerName;

}
