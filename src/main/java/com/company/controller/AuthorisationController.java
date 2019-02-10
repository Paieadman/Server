package com.company.controller;

import com.company.service.AuthorisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class AuthorisationController {

    @Autowired
    private AuthorisationService authorisationService;

    @RequestMapping("/authorisation")
    public String authorisation(String login, String pass){
        System.out.println("i am here");
        return authorisationService.authorisation(login,pass);
    }

}
