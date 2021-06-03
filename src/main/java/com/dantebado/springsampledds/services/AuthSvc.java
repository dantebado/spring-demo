package com.dantebado.springsampledds.services;

import com.dantebado.springsampledds.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class AuthSvc {

    @Autowired
    HttpServletRequest request;

    @Autowired
    UserSvc userSvc;

    public User getCurrentUser() {
        String authorizationHeader = request.getHeader("Authorization");
        return userSvc.findBySecretToken(authorizationHeader);
    }

}
