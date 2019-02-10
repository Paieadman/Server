package com.company.controller;

import com.company.service.LogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
public class LogController {
    @Autowired
    private LogService logService;

    @PostMapping("/login")
    public String login(){
        return "success";
    }
}
