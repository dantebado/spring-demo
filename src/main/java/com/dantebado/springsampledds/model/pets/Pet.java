package com.dantebado.springsampledds.model.pets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    @Id
    String id;
    String name;
    String ownerFullName;

    public enum PetSex {
        female,
        male
    }
    @Enumerated(EnumType.STRING)
    PetSex sex;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    Calendar registrationDate;

    public PetRDTO toRDTO() {
        return new PetRDTO(id, name, ownerFullName, sex, registrationDate);
    }

    public static Pet fromCDTO(PetCDTO body) {
        return new Pet(
            UUID.randomUUID().toString(),
            body.getName(),
            body.getOwnerFullName(),
            body.getSex(),
            Calendar.getInstance()
        );
    }

}
