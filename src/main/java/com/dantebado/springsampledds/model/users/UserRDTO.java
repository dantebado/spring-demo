package com.dantebado.springsampledds.model.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRDTO {

    String id;

    String email;

    Calendar registrationDate;
    Calendar lastSigninDate;

    String mobilePhoneNumber;

}
