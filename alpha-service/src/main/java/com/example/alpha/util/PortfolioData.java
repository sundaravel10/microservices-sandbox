package com.example.alpha.util;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.stereotype.Component;


import java.time.ZonedDateTime;

@Data
@Component
public class PortfolioData {

    @NotBlank
    String companyCode;

    @Min(value = 0)
    Double averagePrice;

    @Min(value = 0)
    Integer quantity;

    ZonedDateTime createdDate;

    ZonedDateTime updatedDate;

}
