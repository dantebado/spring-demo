package com.dantebado.springsampledds.controllers;

import com.dantebado.springsampledds.model.greeting.GreetingCDTO;
import com.dantebado.springsampledds.model.greeting.GreetingRDTO;
import com.dantebado.springsampledds.services.GreetingSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/")
public class HelloController {

    @Autowired
    GreetingSvc greetingSvc;

    @GetMapping
    public ResponseEntity<GreetingRDTO> sayHello(
            @RequestParam(required = false, defaultValue = "World") String name
    ) {
        return ResponseEntity.ok(new GreetingRDTO(name));
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<GreetingRDTO> sayHelloToPathVariable(
            @PathVariable String name
    ) {
        return ResponseEntity.ok(new GreetingRDTO(name));
    }

    @PostMapping(value = "/greetings")
    public ResponseEntity<GreetingRDTO> greetMe(
            @RequestBody GreetingCDTO body
            ) {
        return ResponseEntity.ok(greetingSvc.buildGreeting(body));
    }

}
