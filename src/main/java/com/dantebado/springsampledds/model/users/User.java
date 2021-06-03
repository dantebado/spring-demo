package com.dantebado.springsampledds.model.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Calendar;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    String id;

    String email;
    String password;

    Calendar registrationDate;
    Calendar lastSigninDate;

    public UserRDTO toRDTO() {
        return new UserRDTO(id, email, registrationDate, lastSigninDate);
    }

    public static User fromCDTO(UserCDTO body) {
        return new User(UUID.randomUUID().toString(), body.getEmail(), body.getPassword(), Calendar.getInstance(), null);
    }

}
