package com.ttn.restfulwebservices.q1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello")
    public HelloWorldBean helloWorld(){
        return new HelloWorldBean("Welcome to spring boot");
    }
}

