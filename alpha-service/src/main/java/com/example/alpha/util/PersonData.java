package com.example.alpha.util;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Component
@Builder
public class PersonData {

    @NotBlank
    String name;

    @NotNull
    List<PetData> petDataList;

}
