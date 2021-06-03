package com.dantebado.springsampledds.controllers;

import com.dantebado.springsampledds.model.pets.PetCDTO;
import com.dantebado.springsampledds.model.pets.PetRDTO;
import com.dantebado.springsampledds.services.PetSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/pets")
public class PetsController {

    @Autowired
    PetSvc petSvc;

    @PostMapping
    public ResponseEntity<PetRDTO> createPet(
            @RequestBody PetCDTO body
            ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(petSvc.create(body).toRDTO());
    }

}
