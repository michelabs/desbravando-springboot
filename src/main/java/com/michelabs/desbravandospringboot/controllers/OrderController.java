package com.michelabs.desbravandospringboot.controllers;

import com.michelabs.desbravandospringboot.entities.Order;
import com.michelabs.desbravandospringboot.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> listOrders = orderService.findAllOrders();
        return ResponseEntity.ok().body(listOrders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order findOrderById = orderService.findUserById(id);
        return ResponseEntity.ok().body(findOrderById);
    }

}
