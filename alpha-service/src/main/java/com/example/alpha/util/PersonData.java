package com.example.alpha.util;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Data
@Builder
public class PersonData {

    @NotBlank
    String name;

    @NotNull
    List<PetData> petDataList;

}
