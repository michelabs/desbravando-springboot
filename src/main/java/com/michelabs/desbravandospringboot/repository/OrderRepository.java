package com.michelabs.desbravandospringboot.repository;

import com.michelabs.desbravandospringboot.entities.Order;
import com.michelabs.desbravandospringboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
