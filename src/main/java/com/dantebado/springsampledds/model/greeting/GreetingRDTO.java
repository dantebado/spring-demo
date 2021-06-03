package com.dantebado.springsampledds.model.greeting;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Calendar;

@Data
@AllArgsConstructor
public class GreetingRDTO {

    Calendar date;
    String name;

    public GreetingRDTO(String name) {
        this(Calendar.getInstance(), name);
    }

    public String getGreeting() {
        return "Hello " + name;
    }

}
