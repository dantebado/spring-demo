package com.dantebado.springsampledds.controllers;

import com.dantebado.springsampledds.model.pets.PetRDTO;
import com.dantebado.springsampledds.model.pets.parrots.ParrotCDTO;
import com.dantebado.springsampledds.services.ParrotSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/pets/parrots")
public class ParrotsController {

    @Autowired
    ParrotSvc parrotSvc;

    @PostMapping
    public ResponseEntity<PetRDTO> createDog(
            @RequestBody @Valid ParrotCDTO body
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(parrotSvc.create(body).toRDTO());
    }

}
