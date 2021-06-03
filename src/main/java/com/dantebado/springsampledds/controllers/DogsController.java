package com.dantebado.springsampledds.controllers;

import com.dantebado.springsampledds.model.pets.PetRDTO;
import com.dantebado.springsampledds.model.pets.dogs.DogCDTO;
import com.dantebado.springsampledds.services.DogSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/pets/dogs")
public class DogsController {

    @Autowired
    DogSvc dogSvc;

    @PostMapping
    public ResponseEntity<PetRDTO> createDog(
            @RequestBody DogCDTO body
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dogSvc.create(body).toRDTO());
    }

}
