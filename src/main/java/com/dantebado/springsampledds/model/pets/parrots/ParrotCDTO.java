package com.dantebado.springsampledds.model.pets.parrots;

import com.dantebado.springsampledds.model.pets.PetCDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParrotCDTO extends PetCDTO {

    @NotNull
    Boolean canSing;
    @NotNull
    Boolean canTalk;

}
