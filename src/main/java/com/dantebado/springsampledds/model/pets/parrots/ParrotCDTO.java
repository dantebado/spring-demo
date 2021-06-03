package com.dantebado.springsampledds.model.pets.parrots;

import com.dantebado.springsampledds.model.pets.PetCDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParrotCDTO extends PetCDTO {

    Boolean canSing;
    Boolean canTalk;

}
