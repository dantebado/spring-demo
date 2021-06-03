package com.dantebado.springsampledds.services;

import com.dantebado.springsampledds.model.pets.Pet;
import com.dantebado.springsampledds.model.pets.PetCDTO;
import org.springframework.stereotype.Service;

@Service
public class PetSvc {

    public Pet create(PetCDTO body) {
        return Pet.fromCDTO(body);
    }

}
