package com.dantebado.springsampledds.model.pets.parrots;

import com.dantebado.springsampledds.model.pets.PetRDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParrotRDTO extends PetRDTO {

    boolean canSing;
    boolean canTalk;

}
