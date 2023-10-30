package com.example.alpha.responses;

import com.example.alpha.util.PersonData;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@Builder
public class PersonResponse {

    @NotBlank
    String message;

    @NotNull
    List<PersonData> personDataList;
}
