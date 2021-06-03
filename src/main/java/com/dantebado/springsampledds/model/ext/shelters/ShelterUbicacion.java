package com.dantebado.springsampledds.model.ext.shelters;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShelterUbicacion {

    String direccion;
    float lat;

    @JsonProperty("long")
    float lng;

}
