package com.example.alpha.util;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PersonData {

    @NotBlank
    String name;

    @NotNull
    List<PetData> petDataList;

}
