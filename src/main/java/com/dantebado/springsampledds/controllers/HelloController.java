package com.dantebado.springsampledds.controllers;

import com.dantebado.springsampledds.model.greeting.GreetingRDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/")
public class HelloController {

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

    @PostMapping(value = "/mirror")
    public ResponseEntity<Object> mirrorMe(
            @RequestBody Object body
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

}
