package com.example.alpha.requests;

import com.example.alpha.entities.PersonEntity;
import com.example.alpha.entities.PetEntity;
import com.example.alpha.entities.PortfolioEntity;
import com.example.alpha.util.PortfolioData;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class RequestMapper {

    public List<PortfolioEntity> mapPortfolioDataToEntity(List<PortfolioData> portfolioDataList){

        return portfolioDataList.stream().map(portfolioData -> {
            PortfolioEntity portfolioEntity = new PortfolioEntity();
            portfolioEntity.setQuantity(portfolioData.getQuantity());
            portfolioEntity.setCompanyCode(portfolioData.getCompanyCode());
            portfolioEntity.setAveragePrice(portfolioData.getAveragePrice());
            portfolioEntity.setCreatedDate(ZonedDateTime.now());
            portfolioEntity.setUpdatedDate(ZonedDateTime.now());
            return portfolioEntity;
        }).collect(Collectors.toList());

    }

    public PetEntity mapPetRequestToEntity(PetRequest petRequest, PersonEntity person){
        return PetEntity.builder().name(petRequest.getName()).person(person).build();
    }
}
