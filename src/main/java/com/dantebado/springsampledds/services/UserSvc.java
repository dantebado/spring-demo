package com.dantebado.springsampledds.services;

import com.dantebado.springsampledds.exceptions.GenericException;
import com.dantebado.springsampledds.model.users.User;
import com.dantebado.springsampledds.model.users.UserCDTO;
import com.dantebado.springsampledds.model.users.UserSignin;
import com.dantebado.springsampledds.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.UUID;

import static com.dantebado.springsampledds.exceptions.GenericException.ExceptionType.WRONG_CREDENTIALS;

@Service
public class UserSvc {

    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    HttpServletResponse response;

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
        User user = userRepo.findByEmail(body.getEmail())
            .orElseThrow(() -> new GenericException("Wrong credentials", WRONG_CREDENTIALS));

        if (!encoder.matches(body.getPassword(), user.getPassword())) {
            throw new GenericException("Wrong credentials", WRONG_CREDENTIALS);
        }

        user.setLastSigninDate(Calendar.getInstance());

        // Emulate JWT token
        String authenticationToken = UUID.randomUUID().toString().replace("-", "");
        response.addHeader("Authorization", authenticationToken);

        return save(user);
    }
}
