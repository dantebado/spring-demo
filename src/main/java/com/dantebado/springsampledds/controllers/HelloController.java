package com.dantebado.springsampledds.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/")
public class HelloController {

    @GetMapping
    public ResponseEntity<String> sayHello(
            @RequestParam(required = false, defaultValue = "World") String name
    ) {
        return ResponseEntity.ok("Hello " + name);
    }

}
