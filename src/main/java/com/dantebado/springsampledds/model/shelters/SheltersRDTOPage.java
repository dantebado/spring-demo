package com.dantebado.springsampledds.model.shelters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SheltersRDTOPage {

    int total;
    int offset;
    Set<ShelterRDTO> shelters;

}
