package com.springboot.hello.controller;

import com.springboot.hello.dao.HospitalDao;
import com.springboot.hello.domain.Hospital;
import com.springboot.hello.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Optional;

public class HospitalController {
    private HospitalDao hospitalDao;
    public HospitalController(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Hospital> get(@PathVariable Integer id) {
        Hospital hospital = hospitalDao.findById(id);
        Optional<Hospital> opt = Optional.of(hospital);

        if (!opt.isEmpty()) {
            return ResponseEntity.ok().body(hospital);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Hospital());
        }
    }

}
