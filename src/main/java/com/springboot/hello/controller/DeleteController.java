package com.springboot.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {
    @DeleteMapping(value = "/request1")
    public String getVariable1(@RequestParam String name) {
        return String.format("%s", name);
    }
}
