package com.dantebado.springsampledds.services;

import com.dantebado.springsampledds.model.pets.parrots.Parrot;
import com.dantebado.springsampledds.model.pets.parrots.ParrotCDTO;
import com.dantebado.springsampledds.model.users.User;
import com.dantebado.springsampledds.repositories.ParrotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParrotSvc {

    @Autowired
    ParrotRepo parrotRepo;

    @Autowired
    AuthSvc authSvc;

    public Parrot save(Parrot parrot) {
        return parrotRepo.save(parrot);
    }

    public Parrot create(ParrotCDTO body) {
        User owner = authSvc.getCurrentUser();
        Parrot parrot = new Parrot(body, owner);

        return save(parrot);
    }

}
