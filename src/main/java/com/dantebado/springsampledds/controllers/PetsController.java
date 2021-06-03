package com.dantebado.springsampledds.controllers;

import com.dantebado.springsampledds.model.pets.Pet;
import com.dantebado.springsampledds.model.pets.PetCDTO;
import com.dantebado.springsampledds.model.pets.PetRDTO;
import com.dantebado.springsampledds.model.users.User;
import com.dantebado.springsampledds.model.users.UserRDTO;
import com.dantebado.springsampledds.services.PetSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/pets")
public class PetsController {

    @Autowired
    PetSvc petSvc;

    @PostMapping
    public ResponseEntity<PetRDTO> createPet(
            @RequestBody @Valid PetCDTO body
            ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(petSvc.create(body).toRDTO());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PetRDTO> findById(
            @PathVariable String id
    ) {
        return ResponseEntity.ok(petSvc.findById(id).toRDTO());
    }

    @GetMapping(value = "/{id}/authorized-users")
    public ResponseEntity<Set<UserRDTO>> findAuthorizedUsersByPetId(
            @PathVariable String id
    ) {
        return ResponseEntity.ok(petSvc.findById(id).getAuthorizedPeople().stream().map(User::toRDTO).collect(Collectors.toSet()));
    }

    @PostMapping(value = "/{petId}/authorized-users/{userId}")
    public ResponseEntity<PetRDTO> authorizeUserByPetId(
            @PathVariable String petId,
            @PathVariable String userId
    ) {
        return ResponseEntity.ok(petSvc.authorizePetForUser(petId, userId).toRDTO());
    }

    @DeleteMapping(value = "/{petId}/authorized-users/{userId}")
    public ResponseEntity<PetRDTO> deauthorizeUserByPetId(
            @PathVariable String petId,
            @PathVariable String userId
    ) {
        return ResponseEntity.ok(petSvc.deauthorizePetForUser(petId, userId).toRDTO());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PetRDTO> findById(
            @PathVariable String id,
            @RequestBody PetCDTO body
    ) {
        return ResponseEntity.ok(petSvc.update(id, body).toRDTO());
    }

    @GetMapping
    public ResponseEntity<Page<PetRDTO>> findAll(
            Pageable pageable,
            @RequestParam(required = false) String query
    ) {
        return ResponseEntity.ok(petSvc.findAll(query, pageable).map(Pet::toRDTO));
    }

}
