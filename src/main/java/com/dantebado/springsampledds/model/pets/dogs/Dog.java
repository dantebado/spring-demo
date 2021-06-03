package com.dantebado.springsampledds.model.pets.dogs;

import com.dantebado.springsampledds.model.pets.Pet;
import com.dantebado.springsampledds.model.pets.PetRDTO;
import com.dantebado.springsampledds.model.users.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog extends Pet {

    public enum DogSize {
        mini,
        small,
        medium,
        large
    }

    @Enumerated(EnumType.STRING)
    DogSize size;

    public Dog(DogCDTO body, User owner) {
        super(body, owner);
        this.size = body.getSize();
    }

    @Override
    public DogRDTO toRDTO() {
        DogRDTO dog = new DogRDTO(size);
        dog.fillFromPet(this);
        return dog;
    }

    @Override
    public PetRDTO.PetType getPetType() {
        return PetRDTO.PetType.dog;
    }
}
