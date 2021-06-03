package com.dantebado.springsampledds.model.pets;

import com.dantebado.springsampledds.model.users.User;
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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "owner_id")
    User owner;

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
        return new PetRDTO(id, name,
            owner != null ? owner.getEmail() : null,
            owner != null ? owner.toRDTO() : null,
            sex, registrationDate);
    }

    public static Pet fromCDTO(PetCDTO body) {
        return new Pet(
            UUID.randomUUID().toString(),
            body.getName(),
            null,
            body.getSex(),
            Calendar.getInstance()
        );
    }

}
