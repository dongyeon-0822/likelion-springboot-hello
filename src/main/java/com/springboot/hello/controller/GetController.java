package com.springboot.hello.controller;

import com.springboot.hello.domain.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
@Slf4j
public class GetController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        log.info("hello로 요청이 들어왔습니다.");
        return "Hello World";
    }
    @GetMapping(value = "/name")
    public String getName() {
        log.info("getName으로 요청이 들어왔습니다.");
        return "Hello World";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable(@PathVariable String variable) {
        log.info("getVariable1으로 요청이 들어왔습니다. variable:{}", variable);
        return variable;
    }

    @GetMapping(value = "/variable2/{variable}")
    public String getVariable0(@PathVariable("variable") String variable) {
        log.info("getVariable1으로 요청이 들어왔습니다. variable:{}", variable);
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
