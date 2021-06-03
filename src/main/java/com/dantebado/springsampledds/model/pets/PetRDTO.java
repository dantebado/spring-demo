package com.dantebado.springsampledds.model.pets;

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

    Pet.PetSex sex;

    Calendar registrationDate;

}
