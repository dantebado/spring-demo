package com.dantebado.springsampledds.controllers;

import com.dantebado.springsampledds.model.pets.Pet;
import com.dantebado.springsampledds.model.pets.PetSRDTO;
import com.dantebado.springsampledds.model.users.*;
import com.dantebado.springsampledds.services.AuthSvc;
import com.dantebado.springsampledds.services.UserSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    UserSvc userSvc;

    @Autowired
    AuthSvc authSvc;

    @PostMapping
    public ResponseEntity<UserRDTO> signupUser(
            @RequestBody @Valid UserCDTO body
            ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userSvc.create(body).toRDTO());
    }

    @PostMapping(value = "/signin")
    public ResponseEntity<UserRDTO> signinUser(
            @RequestBody @Valid UserSignin body
            ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userSvc.signin(body).toRDTO());
    }

    @GetMapping(value = "/me")
    public ResponseEntity<UserRDTO> me() {
        return ResponseEntity.ok(authSvc.getCurrentUser().toRDTO());
    }

    @GetMapping(value = "/me/pets")
    public ResponseEntity<Set<PetSRDTO>> myPets() {
        return ResponseEntity.ok(
            authSvc.getCurrentUser()
                .getPets()
                .stream().map(Pet::toSRDTO)
                .collect(Collectors.toSet())
        );
    }

    @GetMapping(value = "/me/authorized-pets")
    public ResponseEntity<Set<PetSRDTO>> myAuthorizedPets() {
        return ResponseEntity.ok(
            authSvc.getCurrentUser()
                .getAuthorizedPets()
                .stream().map(Pet::toSRDTO)
                .collect(Collectors.toSet())
        );
    }

    @PostMapping(value = "/recovery/trigger")
    public ResponseEntity<UserRDTO> triggerPasswordRecovery(
            @RequestParam(required = true) String email
    ) {
        return ResponseEntity.ok(userSvc.triggerPasswordRecovery(email).toRDTO());
    }

    @PostMapping(value = "/recovery/do")
    public ResponseEntity<UserRDTO> doPasswordRecovery(
            @RequestBody @Valid UserPasswordRecovery body
            ) {
        return ResponseEntity.ok(userSvc.doPasswordRecovery(body).toRDTO());
    }

}
