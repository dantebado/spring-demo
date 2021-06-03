package com.dantebado.springsampledds.services;

import com.dantebado.springsampledds.model.pets.Pet;
import com.dantebado.springsampledds.model.pets.PetCDTO;
import com.dantebado.springsampledds.repositories.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetSvc {

    @Autowired
    PetRepo petRepo;

    public Pet create(PetCDTO body) {
        Pet pet = Pet.fromCDTO(body);
        return save(pet);
    }

    public Pet findById(String id) {
        Optional<Pet> pet = petRepo.findById(id);
        return pet.orElse(null);
    }

    private Pet save(Pet pet) {
        return petRepo.save(pet);
    }

}
