package com.dantebado.springsampledds.model.ext.shelters;

import com.dantebado.springsampledds.model.shelters.ShelterAdmissions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShelterAdmisiones {

    boolean perros;
    boolean gatos;

    public ShelterAdmissions toAdmissions() {
        return new ShelterAdmissions(perros, gatos);
    }

}
