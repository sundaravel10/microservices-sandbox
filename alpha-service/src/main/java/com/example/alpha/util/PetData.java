package com.example.alpha.util;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
@Builder
public class PetData {

    @NotBlank
    String name;

    @NotBlank
    String ownerName;

}
