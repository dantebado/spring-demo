package com.dantebado.springsampledds.model.pets.parrots;

import com.dantebado.springsampledds.model.pets.Pet;
import com.dantebado.springsampledds.model.pets.PetRDTO;
import com.dantebado.springsampledds.model.users.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parrot extends Pet {

    boolean canSing;
    boolean canTalk;

    public Parrot(ParrotCDTO body, User owner) {
        super(body, owner);
        this.canSing = body.getCanSing();
        this.canTalk = body.getCanTalk();
    }

    @Override
    public ParrotRDTO toRDTO() {
        ParrotRDTO parrot = new ParrotRDTO(canSing, canTalk);
        parrot.fillFromPet(this);
        return parrot;
    }

    @Override
    public PetRDTO.PetType getPetType() {
        return PetRDTO.PetType.parrot;
    }
}
