package com.springboot.hello.controller;

import com.springboot.hello.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello World";
    }
    @GetMapping(value = "/name")
    public String getName() {
        return "Hello World";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable(@PathVariable("variable") String variable) {
        return variable;
    }

    @GetMapping(value = "/request1")
    public String getVariable1(@RequestParam String name, @RequestParam String email, @RequestParam String organization) {
        return String.format("%s %s %s", name, email, organization);
    }

    @GetMapping(value = "/request2")
    public String getVariable2(@RequestParam Map<String,String> params) {
        StringBuilder sb = new StringBuilder();
        params.entrySet().forEach((map)->{
            sb.append(map.getKey()+ ":" + map.getValue() + "\n");
        });
        return sb.toString();
    }

    @GetMapping(value = "/request3")
    public String getVariable3(MemberDto memberDto) {
        return memberDto.toString();
    }
}
