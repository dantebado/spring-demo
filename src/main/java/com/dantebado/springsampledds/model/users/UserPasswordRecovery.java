package com.dantebado.springsampledds.model.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPasswordRecovery {

    String passwordRecoveryCode;
    String newPassword;

}
