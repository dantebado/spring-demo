package com.dantebado.springsampledds.model.users;

import com.dantebado.springsampledds.model.pets.Pet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    public UserRDTO toRDTO() {
        return new UserRDTO(id, email, registrationDate, lastSigninDate);
    }

    public static User fromCDTO(UserCDTO body) {
        return new User(UUID.randomUUID().toString(),
            body.getEmail(), body.getPassword(),
            Calendar.getInstance(), null,
            UUID.randomUUID().toString(), Collections.emptySet(),
            null);
    }

    public void resetPasswordRecoveryCode() {
        this.passwordRecoveryCode = UUID.randomUUID().toString().split("-")[0];
    }

}
