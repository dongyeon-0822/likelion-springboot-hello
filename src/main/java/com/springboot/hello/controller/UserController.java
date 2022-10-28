package com.springboot.hello.controller;

import com.springboot.hello.dao.UserDao;
import com.springboot.hello.domain.User;
import com.springboot.hello.domain.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }
    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/user")
    public User selectAndInsert() throws SQLException {
        userDao.insert(new User("1", "dong" , "1234"));
        return userDao.select("1");
    }
    @DeleteMapping(value = "/deleteId")
    public void deleteId(@RequestParam String id) {
        log.info("id:{}인 user를 삭제합니다", id);
        userDao.deleteById(id);
    }
    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        log.info("모든 user를 삭제합니다");
        userDao.deleteAll();
    }
}
