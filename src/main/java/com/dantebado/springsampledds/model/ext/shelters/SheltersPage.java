package com.dantebado.springsampledds.model.ext.shelters;

import com.dantebado.springsampledds.model.shelters.SheltersRDTOPage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SheltersPage {

    int total;
    int offset;
    ShelterDTO hogares[];

    public SheltersRDTOPage toRDTOPage() {
        return new SheltersRDTOPage(total, offset, Arrays.stream(hogares).map(ShelterDTO::toRDTO).collect(Collectors.toSet()));
    }

}
