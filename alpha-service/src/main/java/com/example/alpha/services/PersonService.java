package com.example.alpha.services;

import com.example.alpha.entities.PersonEntity;
import com.example.alpha.repository.PersonRepository;
import com.example.alpha.requests.PetRequest;
import com.example.alpha.responses.PersonResponse;
import com.example.alpha.responses.ResponseMapper;
import com.example.alpha.util.PetData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PetService petService;

    public PersonResponse addPet(PetRequest petRequest) {
        ResponseMapper responseMapper = new ResponseMapper();
        PersonEntity person = personRepository.findByName(petRequest.getOwnerName());
        petService.addPet(petRequest,person);
        return responseMapper.mapToPersonResponse(personRepository.findByName(petRequest.getOwnerName()));
    }
}
