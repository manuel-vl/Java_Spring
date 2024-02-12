package com.projectjavaspring.marketapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// Path al cual va a responder
@RequestMapping("/saludar")
public class HolaMundoController {

    // Peticion get y endpoint
    @GetMapping("/hola")
    public String saludar(){
        return "Hello World!";
    }
}

