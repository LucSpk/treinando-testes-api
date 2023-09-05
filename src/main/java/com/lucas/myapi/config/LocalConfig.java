package com.lucas.myapi.config;

import com.lucas.myapi.domain.User;
import com.lucas.myapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("local")
public class LocalConfig {
    @Autowired
    private UserRepository repository;

    @Bean
    public void starDB() {
        User user1 = new User(null, "Lucas Alves", "luc", "123");
        User user2 = new User(null, "Fulano de Tal", "fulano", "123");

        repository.saveAll(Arrays.asList(user1, user2));
    }
}
