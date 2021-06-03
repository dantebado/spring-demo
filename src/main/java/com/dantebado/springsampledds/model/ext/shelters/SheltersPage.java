package com.dantebado.springsampledds.model.ext.shelters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SheltersPage {

    int total;
    int offset;
    ShelterDTO hogares[];

}
