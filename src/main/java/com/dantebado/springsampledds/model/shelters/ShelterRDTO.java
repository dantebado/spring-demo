package com.dantebado.springsampledds.model.shelters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShelterRDTO {

    String id;
    String name;
    ShelterLocation location;
    String phone;
    ShelterAdmissions admissions;
    int capacity;
    int availableSpots;
    boolean hasYard;
    String[] characteristics;

}
