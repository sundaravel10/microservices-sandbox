package com.example.alpha.controllers;

import com.example.alpha.requests.PetRequest;
import com.example.alpha.responses.PersonResponse;
import com.example.alpha.services.PersonService;
import com.example.alpha.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/household")
public class HouseHoldController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PetService petService;

    @PostMapping("/add/pet")
    public ResponseEntity<PersonResponse> addPet(PetRequest petRequest){
        return ResponseEntity.ok(personService.addPet(petRequest));
    }
}
