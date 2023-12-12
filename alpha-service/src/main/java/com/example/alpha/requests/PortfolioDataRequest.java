package com.example.alpha.requests;


import com.example.alpha.util.PortfolioData;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.stereotype.Component;


import java.util.List;

@Data
@Component
public class PortfolioDataRequest {

    @NotNull
    List<PortfolioData> portfolioDataList;
}
