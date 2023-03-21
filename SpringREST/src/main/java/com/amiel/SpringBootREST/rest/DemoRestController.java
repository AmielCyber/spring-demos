package com.amiel.SpringBootREST.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController                 // Mark as REST Controller for Java Spring
@RequestMapping("/test")     // REST Controller for /test endpoints
public class DemoRestController {
    // Request handler for /test/hello
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World!";
    }
}
