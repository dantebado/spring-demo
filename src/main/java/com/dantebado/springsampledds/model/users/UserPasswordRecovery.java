package com.dantebado.springsampledds.model.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPasswordRecovery {

    @NotNull
    String passwordRecoveryCode;
    @NotNull
    @Length(min = 4, max = 16)
    String newPassword;

}
