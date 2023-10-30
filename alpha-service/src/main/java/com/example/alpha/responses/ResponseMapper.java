package com.example.alpha.responses;

import com.example.alpha.entities.PersonEntity;
import com.example.alpha.entities.PetEntity;
import com.example.alpha.entities.PortfolioEntity;
import com.example.alpha.util.PersonData;
import com.example.alpha.util.PetData;
import com.example.alpha.util.PortfolioData;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResponseMapper {



    public List<PortfolioData> mapPortfolioEntityToList(List<PortfolioEntity> portfolioEntityList) {
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

    public PetData mapPetEntityToPetData(PetEntity resultPetEntity) {
            return PetData.builder()
                    .name(resultPetEntity.getName())
                    .ownerName(resultPetEntity.getPerson().getName()).build();
    }

    public List<PetData> mapPetEntityListtoPetDataList(List<PetEntity> petEntities){
        return petEntities.stream().map(petEntity -> PetData.builder()
                .name(petEntity.getName())
                .ownerName(petEntity.getPerson().getName())
                .build()).collect(Collectors.toList());
    }

    public PersonResponse mapToPersonResponse(PersonEntity person) {
        PersonData personData = PersonData.builder()
                .name(person.getName())
                .petDataList(mapPetEntityListtoPetDataList(person.getPets())).build();
        return PersonResponse.builder().message("Details are as follows").personDataList(Collections.singletonList(personData)).build();
    }
}
