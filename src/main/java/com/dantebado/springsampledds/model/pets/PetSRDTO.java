package com.dantebado.springsampledds.model.pets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetSRDTO {

    String id;
    String name;

    Pet.PetSex sex;
    PetRDTO.PetType type;

}
