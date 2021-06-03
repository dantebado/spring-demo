package com.dantebado.springsampledds.model.ext.shelters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShelterDTO {

    String id;
    String nombre;
    ShelterUbicacion ubicacion;
    String telefono;
    ShelterAdmisiones admisiones;
    int capacidad;
    int lugares_disponibles;
    boolean patio;
    String caracteristicas[];

}
