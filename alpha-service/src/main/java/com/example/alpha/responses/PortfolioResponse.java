package com.example.alpha.responses;

import com.example.alpha.util.PortfolioData;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Component
public class PortfolioResponse {

    @NotBlank
    String message;

    List<PortfolioData> portfolioDataList;
}
