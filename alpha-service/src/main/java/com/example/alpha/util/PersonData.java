package com.example.alpha.util;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
public class PersonData {

    @NotBlank
    String name;

    @NotNull
    List<PetData> petDataList;

}
