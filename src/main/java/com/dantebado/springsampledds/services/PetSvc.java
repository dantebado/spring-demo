package com.dantebado.springsampledds.services;

import com.dantebado.springsampledds.model.pets.Pet;
import com.dantebado.springsampledds.model.pets.PetCDTO;
import com.dantebado.springsampledds.repositories.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetSvc {

    @Autowired
    PetRepo petRepo;

    public Pet create(PetCDTO body) {
        Pet pet = Pet.fromCDTO(body);
        return save(pet);
    }

    private Pet save(Pet pet) {
        return petRepo.save(pet);
    }

}
