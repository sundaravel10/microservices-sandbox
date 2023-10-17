package com.example.alpha.requests;


import com.example.alpha.util.PortfolioData;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Component
public class PortfolioDataRequest {

    @NotNull
    List<PortfolioData> portfolioDataList;
}
