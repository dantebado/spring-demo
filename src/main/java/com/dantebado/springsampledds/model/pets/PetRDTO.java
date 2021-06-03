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
        parrots
    }
    PetType type;

}
