package com.dantebado.springsampledds.model.pets.dogs;

import com.dantebado.springsampledds.model.pets.PetCDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DogCDTO extends PetCDTO {

    Dog.DogSize size;

}
