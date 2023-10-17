package com.example.alpha.responses;

import com.example.alpha.entities.PortfolioEntity;
import com.example.alpha.util.PortfolioData;

import java.util.List;
import java.util.stream.Collectors;

public class ResponseMapper {



    public List<PortfolioData> mapEntityToList(List<PortfolioEntity> portfolioEntityList) {
       return portfolioEntityList.stream().map(portfolioEntity -> {
            PortfolioData portfolioData = new PortfolioData();
            portfolioData.setCompanyCode(portfolioEntity.getCompanyCode());
            portfolioData.setQuantity(portfolioEntity.getQuantity());
            portfolioData.setAveragePrice(portfolioEntity.getAveragePrice());
            portfolioData.setCreatedDate(portfolioEntity.getCreatedDate());
            portfolioData.setUpdatedDate(portfolioEntity.getUpdatedDate());
            return portfolioData;
        }).collect(Collectors.toList());
    }
}
