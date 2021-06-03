package com.dantebado.springsampledds.model.greeting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GreetingCDTO {

    String firstName;
    String lastName;

    public String getFullName() {
        return firstName + " " + lastName;
    }

}
