package com.michelabs.desbravandospringboot.repository;

import com.michelabs.desbravandospringboot.entities.OrderItem;
import com.michelabs.desbravandospringboot.entities.User;
import com.michelabs.desbravandospringboot.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
