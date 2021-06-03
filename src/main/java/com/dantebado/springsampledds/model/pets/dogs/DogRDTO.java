package com.dantebado.springsampledds.model.pets.dogs;

import com.dantebado.springsampledds.model.pets.PetRDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DogRDTO extends PetRDTO {

    Dog.DogSize size;

}
