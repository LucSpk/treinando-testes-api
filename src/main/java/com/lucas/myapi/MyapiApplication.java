package com.lucas.myapi;

import com.lucas.myapi.domain.User;
import com.lucas.myapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MyapiApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyapiApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Lucas Alves", "luc", "123");
		User user2 = new User(null, "Fulano de Tal", "fulano", "123");

		userRepository.saveAll(Arrays.asList(user1, user2));
	}
}
