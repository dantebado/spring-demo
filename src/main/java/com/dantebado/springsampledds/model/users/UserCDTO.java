package com.dantebado.springsampledds.model.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCDTO {

    @NotNull
    @Email
    String email;

    @NotNull
    @Length(min = 4, max = 16)
    String password;

    String mobilePhoneNumber;

}
