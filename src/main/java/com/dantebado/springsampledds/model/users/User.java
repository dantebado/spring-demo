package com.dantebado.springsampledds.model.users;

import com.dantebado.springsampledds.model.pets.Pet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    @Id
    @EqualsAndHashCode.Include
    String id;

    String email;
    String password;

    Calendar registrationDate;
    Calendar lastSigninDate;

    String secretToken;

    @OneToMany(mappedBy = "owner")
    Set<Pet> pets;

    String passwordRecoveryCode;

    String mobilePhoneNumber;

    @ManyToMany(mappedBy = "authorizedPeople", cascade = CascadeType.PERSIST)
    Set<Pet> authorizedPets;

    public UserRDTO toRDTO() {
        return new UserRDTO(id, email, registrationDate, lastSigninDate, mobilePhoneNumber);
    }

    public static User fromCDTO(UserCDTO body) {
        return new User(UUID.randomUUID().toString(),
            body.getEmail(), body.getPassword(),
            Calendar.getInstance(), null,
            UUID.randomUUID().toString(), Collections.emptySet(),
            null, body.getMobilePhoneNumber(), Collections.emptySet());
    }

    public void resetPasswordRecoveryCode() {
        this.passwordRecoveryCode = UUID.randomUUID().toString().split("-")[0];
    }

}
