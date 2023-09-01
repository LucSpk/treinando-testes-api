package com.lucas.myapi.services.userServices;

import com.lucas.myapi.domain.User;
import com.lucas.myapi.repositories.UserRepository;
import com.lucas.myapi.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
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

        User response = service.findById(ID);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());

        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getNome());
        assertEquals(LOGIN, response.getLogin());
        assertEquals(SENHA, response.getSenha());
    }

    @Test
    void whenFindByIdThenReturnAnObjectNotFound() {
        when(repository.findById(anyInt())).thenThrow(new ObjectNotFoundException("Objeto não encontrado."));

        try {
            service.findById(ID);
        } catch (Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals("Objeto não encontrado.", ex.getMessage());
        }
    }

    @Test
    void whenFindAllThenReturnAnListOfUserInstance() {
        when(repository.findAll()).thenReturn(List.of(this.user));

        List<User> response = service.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());

        assertEquals(ID, response.get(0).getId());
        assertEquals(NAME, response.get(0).getNome());
        assertEquals(LOGIN, response.get(0).getLogin());
        assertEquals(SENHA, response.get(0).getSenha());
    }

    @Test
    void whenUpdateTherReturnSucess() {
        when(repository.save(any())).thenReturn(user);
        when(repository.findById(anyInt())).thenReturn(optionalUser);

        User response = service.update(ID ,user);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());

        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getNome());
        assertEquals(LOGIN, response.getLogin());
        assertEquals(SENHA, response.getSenha());
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