package com.michelabs.desbravandospringboot.config;

import com.michelabs.desbravandospringboot.entities.Order;
import com.michelabs.desbravandospringboot.entities.User;
import com.michelabs.desbravandospringboot.repository.OrderRepository;
import com.michelabs.desbravandospringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null,"Natalia Rodrigues","natalia@gmail.com","34988888888","123456");
        User u2 = new User(null,"Regina Silva","regina@gmail.com","34999999999","123456");


        Order o1 = new Order(null, Instant.parse("2022-03-30T21:37:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2022-03-30T20:37:07Z"), u2);
        Order o3 = new Order(null, Instant.parse("2022-03-30T19:37:07Z"), u1);

        userRepository.save(u1);
        userRepository.save(u2);
        orderRepository.save(o1);
        orderRepository.save(o2);
        orderRepository.save(o3);
    }
}
