package com.dantebado.springsampledds.controllers;

import com.dantebado.springsampledds.model.pets.Pet;
import com.dantebado.springsampledds.model.pets.PetSRDTO;
import com.dantebado.springsampledds.model.users.UserCDTO;
import com.dantebado.springsampledds.model.users.UserRDTO;
import com.dantebado.springsampledds.model.users.UserSignin;
import com.dantebado.springsampledds.services.AuthSvc;
import com.dantebado.springsampledds.services.UserSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
            @RequestBody UserCDTO body
            ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userSvc.create(body).toRDTO());
    }

    @PostMapping(value = "/signin")
    public ResponseEntity<UserRDTO> signinUser(
            @RequestBody UserSignin body
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

}
