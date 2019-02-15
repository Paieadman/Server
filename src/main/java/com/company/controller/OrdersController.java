package com.company.controller;
import com.company.dto.Order;
import com.company.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class OrdersController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/orders")
    public List<Order> getOrders(){
        return orderService.getOrders();
    }

    @PostMapping("/orders/add")
    public Order add(@RequestBody Order order){
        return orderService.addOrder(order);
    }

    @RequestMapping("/orders/{id}/remove")
    public String remove(@PathVariable int id){ return orderService.removeOrder(id);}
}
