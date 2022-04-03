package com.michelabs.desbravandospringboot.config;

import com.michelabs.desbravandospringboot.entities.Category;
import com.michelabs.desbravandospringboot.entities.Order;
import com.michelabs.desbravandospringboot.entities.Product;
import com.michelabs.desbravandospringboot.entities.User;
import com.michelabs.desbravandospringboot.entities.enums.OrderStatus;
import com.michelabs.desbravandospringboot.repository.CategoryRepository;
import com.michelabs.desbravandospringboot.repository.OrderRepository;
import com.michelabs.desbravandospringboot.repository.ProductRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category(null, "Eletronics");
        Category category2 = new Category(null, "Books");
        Category category3 = new Category(null, "Computers");

        Product product1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5,"");
        Product product2 = new Product(null, "Smart TV", "Nulla eu impediet purus. Maecenas ante.", 2190.0,"");
        Product product3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product product4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product product5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);

        product1.getCategories().add(category2);
        product2.getCategories().add(category1);
        product2.getCategories().add(category3);
        product3.getCategories().add(category3);
        product4.getCategories().add(category3);
        product5.getCategories().add(category2);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);

        User user1 = new User(null,"Natalia Rodrigues","natalia@gmail.com","34988888888","123456");
        User user2 = new User(null,"Regina Silva","regina@gmail.com","34999999999","123456");

        userRepository.save(user1);
        userRepository.save(user2);

        Order order1 = new Order(null, Instant.parse("2022-03-30T21:37:07Z"), OrderStatus.PAID , user1);
        Order order2 = new Order(null, Instant.parse("2022-03-30T20:37:07Z"), OrderStatus.WAITING_PAYMENT, user2);
        Order order3 = new Order(null, Instant.parse("2022-03-30T19:37:07Z"), OrderStatus.WAITING_PAYMENT, user1);

        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);

    }
}
