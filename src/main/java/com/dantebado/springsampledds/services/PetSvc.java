package com.dantebado.springsampledds.services;

import com.dantebado.springsampledds.exceptions.GenericException;
import com.dantebado.springsampledds.model.pets.Pet;
import com.dantebado.springsampledds.model.pets.PetCDTO;
import com.dantebado.springsampledds.model.users.User;
import com.dantebado.springsampledds.repositories.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PetSvc {

    @Autowired
    PetRepo petRepo;

    @Autowired
    UserSvc userSvc;

    @Autowired
    AuthSvc authSvc;

    public Pet create(PetCDTO body) {
        User owner = authSvc.getCurrentUser();
        Pet pet = new Pet(body, owner);
        return save(pet);
    }

    public Pet findById(String id) {
        return petRepo
            .findById(id)
            .orElseThrow(() -> new GenericException("Pet not found: " + id, GenericException.ExceptionType.PET_NOT_FOUND));
    }

    public Page<Pet> findAll(String query, Pageable pageable) {
        return petRepo.findAll(query, pageable);
    }

    public Pet update(String id, PetCDTO body) {
        Pet pet = findById(id);

        if (body.getName() != null)
            pet.setName(body.getName());

        if (body.getSex() != null)
            pet.setSex(body.getSex());

        return save(pet);
    }

    private Pet save(Pet pet) {
        return petRepo.save(pet);
    }

    public Pet authorizePetForUser(String petId, String userId) {
        Pet pet = findById(petId);
        User user = userSvc.findById(userId);

        pet.getAuthorizedPeople().add(user);

        return save(pet);
    }

    public Pet deauthorizePetForUser(String petId, String userId) {
        Pet pet = findById(petId);
        User user = userSvc.findById(userId);

        if (pet.getOwner() == user) {
            throw new GenericException("Cannot deauthorize pet owner", GenericException.ExceptionType.USER_IS_PET_OWNER);
        }

        pet.getAuthorizedPeople().remove(user);

        return save(pet);
    }

}
