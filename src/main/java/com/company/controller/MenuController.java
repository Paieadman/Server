package com.company.controller;

import com.company.dto.Dish;
import com.company.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/menu")
    public List<Dish> getMenu(){
        return menuService.getMenu();
    }

}
