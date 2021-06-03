package com.dantebado.springsampledds.model.pets.dogs;

import com.dantebado.springsampledds.model.pets.PetCDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DogCDTO extends PetCDTO {

    @NotNull
    Dog.DogSize size;

}
