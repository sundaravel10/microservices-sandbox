package com.example.alpha.responses;

import com.example.alpha.util.PortfolioData;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class PortfolioResponse {

    @NotBlank
    String message;

    List<PortfolioData> portfolioDataList;
}
