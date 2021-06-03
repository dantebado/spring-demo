package com.dantebado.springsampledds.controllers;

import com.dantebado.springsampledds.model.users.UserCDTO;
import com.dantebado.springsampledds.model.users.UserRDTO;
import com.dantebado.springsampledds.services.UserSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    UserSvc userSvc;

    @PostMapping
    public ResponseEntity<UserRDTO> createPet(
            @RequestBody UserCDTO body
            ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userSvc.create(body).toRDTO());
    }

}
