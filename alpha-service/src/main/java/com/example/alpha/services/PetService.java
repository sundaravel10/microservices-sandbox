package com.example.alpha.services;

import com.example.alpha.entities.PersonEntity;
import com.example.alpha.entities.PetEntity;
import com.example.alpha.repository.PetRepository;
import com.example.alpha.requests.PetRequest;
import com.example.alpha.requests.RequestMapper;
import com.example.alpha.responses.ResponseMapper;
import com.example.alpha.util.PetData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public PetData addPet(PetRequest petRequest, PersonEntity person){
        RequestMapper requestMapper = new RequestMapper();
        PetEntity petEntity = requestMapper.mapPetRequestToEntity(petRequest,person);
        PetEntity resultPetEntity = petRepository.save(petEntity);
        ResponseMapper responseMapper = new ResponseMapper();
        return responseMapper.mapPetEntityToPetData(resultPetEntity);
    }
}
