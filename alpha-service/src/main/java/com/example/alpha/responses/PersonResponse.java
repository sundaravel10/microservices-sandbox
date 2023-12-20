package com.example.alpha.responses;

import com.example.alpha.util.PersonData;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class PersonResponse {

    @NotBlank
    String message;

    @NotNull
    List<PersonData> personDataList;
}
