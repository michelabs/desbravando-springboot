package com.michelabs.desbravandospringboot.config;

import com.michelabs.desbravandospringboot.entities.User;
import com.michelabs.desbravandospringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null,"Natalia Rodrigues","natalia@gmail.com","34988888888","123456");
        User u2 = new User(null,"Regina Silva","regina@gmail.com","34999999999","123456");

        userRepository.save(u1);
        userRepository.save(u2);
    }
}
