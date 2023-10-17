package com.example.alpha.util;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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
