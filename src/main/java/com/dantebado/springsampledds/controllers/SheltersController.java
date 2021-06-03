package com.dantebado.springsampledds.controllers;

import com.dantebado.springsampledds.services.ShelterSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/shelters")
public class SheltersController {

    @Autowired
    ShelterSvc shelterSvc;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return ResponseEntity.ok(shelterSvc.findAll());
    }

}
