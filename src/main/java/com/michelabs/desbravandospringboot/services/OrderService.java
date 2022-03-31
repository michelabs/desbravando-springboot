package com.michelabs.desbravandospringboot.services;

import com.michelabs.desbravandospringboot.entities.Order;
import com.michelabs.desbravandospringboot.entities.User;
import com.michelabs.desbravandospringboot.repository.OrderRepository;
import com.michelabs.desbravandospringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    public OrderRepository orderRepository;


    public List<Order> findAllOrders(){
       return orderRepository.findAll();
    }

    public Order findUserById(Long id){
        Optional<Order> findOrderById = orderRepository.findById(id);
        return findOrderById.get();
    }
}
