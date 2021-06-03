package com.dantebado.springsampledds.model.pets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetCDTO {

    String name;
    Pet.PetSex sex;

}
