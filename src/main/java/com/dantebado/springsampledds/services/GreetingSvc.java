package com.dantebado.springsampledds.services;

import com.dantebado.springsampledds.model.greeting.GreetingCDTO;
import com.dantebado.springsampledds.model.greeting.GreetingRDTO;
import org.springframework.stereotype.Service;

@Service
public class GreetingSvc {

    public GreetingRDTO buildGreeting(GreetingCDTO body) {
        return new GreetingRDTO(body.getFullName());
    }

}
