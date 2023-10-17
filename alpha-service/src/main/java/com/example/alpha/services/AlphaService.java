package com.example.alpha.services;


import com.example.alpha.entities.PortfolioEntity;
import com.example.alpha.repository.PortfolioRepository;
import com.example.alpha.requests.RequestMapper;
import com.example.alpha.responses.AlphaResponse;
import com.example.alpha.responses.BetaResponse;
import com.example.alpha.responses.PortfolioResponse;
import com.example.alpha.responses.ResponseMapper;
import com.example.alpha.util.PortfolioData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlphaService {

    @Autowired
    protected AlphaResponse alphaResponse;

    @Autowired
    protected PortfolioResponse portfolioResponse;

    @Autowired
    protected BetaServiceClient betaServiceClient;

    @Autowired
    protected PortfolioRepository portfolioRepository;

    public AlphaResponse getGreetings(){
        alphaResponse.setMessage("Hello User! I am alpha!");
        return alphaResponse;
    }

    public AlphaResponse checkBetaStatus() {
        BetaResponse betaResponse = betaServiceClient.getStatus();
        alphaResponse.setMessage(betaResponse.getMessage());
        return alphaResponse;
    }

    public PortfolioResponse getAllData(){
        List<PortfolioEntity> portfolioEntityList = portfolioRepository.findAll();
        ResponseMapper responseMapper = new ResponseMapper();
        portfolioResponse.setPortfolioDataList(responseMapper.mapEntityToList(portfolioEntityList));
        portfolioResponse.setMessage("Portfolio Details are as follows");
        return portfolioResponse;
    }

    public PortfolioResponse putData(List<PortfolioData> portfolioDataList) {
        RequestMapper requestMapper = new RequestMapper();
        ResponseMapper responseMapper = new ResponseMapper();
        List<PortfolioEntity> portfolioEntityList = portfolioRepository.saveAll(requestMapper.mapToEntity(portfolioDataList));
        portfolioResponse.setPortfolioDataList(responseMapper.mapEntityToList(portfolioEntityList));
        portfolioResponse.setMessage("Following Data are saved");
        return portfolioResponse;
    }
}
