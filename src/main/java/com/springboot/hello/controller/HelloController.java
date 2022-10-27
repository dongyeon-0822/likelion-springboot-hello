package com.springboot.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/get-api")
public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello World";
    }
    @GetMapping(value = "/name")
    public String getName() {
        return "Hello World";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable("variable") String variable) {
        return variable;
    }

    @GetMapping(value = "/request1")
    public String getVariable2(@RequestParam String name, @RequestParam String email, @RequestParam String organization) {
        return String.format("%s %s %s", name, email, organization);
    }
}
