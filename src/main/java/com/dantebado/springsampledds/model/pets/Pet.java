package com.dantebado.springsampledds.model.pets;

import com.dantebado.springsampledds.model.users.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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
        joinColumns = @JoinColumn(name = "pet_id", nullable = false),
        inverseJoinColumns = @JoinColumn(name="user_id", nullable = false)
    )
    Set<User> authorizedPeople;

    public PetRDTO toRDTO() {
        return new PetRDTO(id, name,
            owner != null ? owner.getEmail() : null,
            owner != null ? owner.toRDTO() : null,
            sex, registrationDate, getPetType());
    }

    public PetSRDTO toSRDTO() {
        return new PetSRDTO(id, name, sex, getPetType());
    }

    public Pet(PetCDTO body, User owner) {
        this.id = UUID.randomUUID().toString();
        this.name = body.getName();
        this.owner = owner;
        this.sex = body.getSex();
        this.registrationDate = Calendar.getInstance();
        this.authorizedPeople = new HashSet<>();
        this.authorizedPeople.add(owner);
    }

    public PetRDTO.PetType getPetType() {
        return null;
    }

}
