package com.dantebado.springsampledds.services;

import com.dantebado.springsampledds.exceptions.GenericException;
import com.dantebado.springsampledds.model.pets.Pet;
import com.dantebado.springsampledds.model.pets.PetCDTO;
import com.dantebado.springsampledds.repositories.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PetSvc {

    @Autowired
    PetRepo petRepo;

    public Pet create(PetCDTO body) {
        Pet pet = Pet.fromCDTO(body);
        return save(pet);
    }

    public Pet findById(String id) {
        return petRepo
            .findById(id)
            .orElseThrow(() -> new GenericException("Pet not found: " + id, GenericException.ExceptionType.PET_NOT_FOUND));
    }

    public Page<Pet> findAll(Pageable pageable) {
        return petRepo.findAll(pageable);
    }

    private Pet save(Pet pet) {
        return petRepo.save(pet);
    }

}
