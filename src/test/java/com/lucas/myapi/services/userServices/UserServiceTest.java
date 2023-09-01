package com.lucas.myapi.services.userServices;

import com.lucas.myapi.domain.User;
import com.lucas.myapi.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class UserServiceTest {

    public static final Integer ID = 1;
    public static final String NAME = "Lucas Alves";
    public static final String LOGIN = "luc";
    public static final String SENHA = "123456";

    @InjectMocks
    private UserService service;
    @Mock
    private UserRepository repository;
    private User user;
    private Optional<User> optionalUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.start();
    }

    @Test
    void whenFindByIdThenReturnAnUserInstance() {
        when(repository.findById(anyInt())).thenReturn(this.optionalUser);

        User user = service.findById(ID);

        assertNotNull(user);
        assertEquals(User.class, user.getClass());

        assertEquals(ID, user.getId());
        assertEquals(NAME, user.getNome());
        assertEquals(LOGIN, user.getLogin());
        assertEquals(SENHA, user.getSenha());
    }

    @Test
    void findAll() {
    }

    @Test
    void update() {
    }

    @Test
    void create() {
    }

    @Test
    void delete() {
    }

    void start() {
        this.user = new User(ID, NAME, LOGIN, SENHA);
        this.optionalUser = Optional.of(new User(ID, NAME, LOGIN, SENHA));
    }
}