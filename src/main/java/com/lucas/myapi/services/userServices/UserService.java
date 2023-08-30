package com.lucas.myapi.services.userServices;

import com.lucas.myapi.domain.User;
import com.lucas.myapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findById(Integer userId) {
        Optional<User> usuario = repository.findById(userId);
        return usuario.orElse(null);
    }
}
