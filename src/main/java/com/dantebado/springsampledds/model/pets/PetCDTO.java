package com.dantebado.springsampledds.model.pets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetCDTO {

    @NotNull
    @Length(min = 4, max = 16)
    String name;
    @NotNull
    Pet.PetSex sex;

}
