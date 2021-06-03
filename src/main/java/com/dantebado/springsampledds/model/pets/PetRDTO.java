package com.dantebado.springsampledds.model.pets;

import com.dantebado.springsampledds.model.users.UserRDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetRDTO {

    String id;
    String name;
    String ownerFullName;
    UserRDTO owner;

    Pet.PetSex sex;

    Calendar registrationDate;

    public enum PetType {
        dog,
        parrot
    }
    PetType type;

    public void fillFromPet(Pet pet) {
        this.id = pet.getId();
        this.name = pet.getName();
        this.ownerFullName = pet.getOwner().getEmail();
        this.owner = pet.getOwner().toRDTO();
        this.sex = pet.getSex();
        this.registrationDate = pet.getRegistrationDate();
        this.type = pet.getPetType();
    }

}
