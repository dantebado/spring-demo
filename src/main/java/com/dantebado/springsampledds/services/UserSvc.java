package com.dantebado.springsampledds.services;

import com.dantebado.springsampledds.exceptions.GenericException;
import com.dantebado.springsampledds.model.users.User;
import com.dantebado.springsampledds.model.users.UserCDTO;
import com.dantebado.springsampledds.model.users.UserSignin;
import com.dantebado.springsampledds.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.dantebado.springsampledds.exceptions.GenericException.ExceptionType.WRONG_CREDENTIALS;

@Service
public class UserSvc {

    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder encoder;

    public User create(UserCDTO body) {
        body.setPassword(
                encoder.encode(body.getPassword())
        );
        User user = User.fromCDTO(body);
        return save(user);
    }

    private User save(User user) {
        return userRepo.save(user);
    }

    public User signin(UserSignin body) {
        throw new GenericException("Wrong Credentials", WRONG_CREDENTIALS);
    }
}
