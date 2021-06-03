package com.dantebado.springsampledds.model.pets;

import com.dantebado.springsampledds.model.users.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pet {

    @Id
    @EqualsAndHashCode.Include
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

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "pet_authorized_people",
        joinColumns = @JoinColumn(name = "book_id", nullable = false),
        inverseJoinColumns = @JoinColumn(name="user_id", nullable = false)
    )
    Set<User> authorizedPeople;

    public PetRDTO toRDTO() {
        return new PetRDTO(id, name,
            owner != null ? owner.getEmail() : null,
            owner != null ? owner.toRDTO() : null,
            sex, registrationDate);
    }

    public PetSRDTO toSRDTO() {
        return new PetSRDTO(id, name, sex);
    }

    public static Pet fromCDTO(PetCDTO body, User owner) {
        return new Pet(
            UUID.randomUUID().toString(),
            body.getName(),
            owner,
            body.getSex(),
            Calendar.getInstance(), Set.of(owner)
        );
    }

}
