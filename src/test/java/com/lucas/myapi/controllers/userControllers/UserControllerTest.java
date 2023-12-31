package com.lucas.myapi.controllers.userControllers;

import com.lucas.myapi.domain.User;
import com.lucas.myapi.services.userServices.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserControllerTest {

    public static final Integer ID = 1;
    public static final String NAME = "Lucas Alves";
    public static final String LOGIN = "luc";
    public static final String SENHA = "123456";

    private User user;

    @InjectMocks
    private UserController controller;

    @Mock
    private UserService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.start();
    }

    @Test
    void findById() {
        when(service.findById(anyInt())).thenReturn(user);

        ResponseEntity<User> response = controller.findById(ID);

        assertNotNull(response);
        assertNotNull(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(User.class, response.getBody().getClass());

        assertEquals(ID, response.getBody().getId());
        assertEquals(NAME, response.getBody().getNome());
        assertEquals(LOGIN, response.getBody().getLogin());
        assertEquals(SENHA, response.getBody().getSenha());
    }

    @Test
    void findAll() {
        List<User> userList = new ArrayList<>();
        userList.add(user);
        when(service.findAll()).thenReturn(userList);

        ResponseEntity<List<User>> response = controller.findaAll();

        assertNotNull(response);
        assertNotNull(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(ArrayList.class, response.getBody().getClass());
        assertEquals(User.class, response.getBody().get(0).getClass());

        assertEquals(ID, response.getBody().get(0).getId());
        assertEquals(NAME, response.getBody().get(0).getNome());
        assertEquals(LOGIN, response.getBody().get(0).getLogin());
        assertEquals(SENHA, response.getBody().get(0).getSenha());
    }

    @Test
    void update() {
        when(service.update(anyInt(), any())).thenReturn(user);

        ResponseEntity<User> response = controller.update(ID, user);

        assertNotNull(response);
        assertNotNull(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(User.class, response.getBody().getClass());

        assertEquals(ID, response.getBody().getId());
        assertEquals(NAME, response.getBody().getNome());
        assertEquals(LOGIN, response.getBody().getLogin());
        assertEquals(SENHA, response.getBody().getSenha());
    }

    @Test
    void create() {
        when(service.create(any())).thenReturn(user);

        ResponseEntity<User> response = controller.create(user);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getHeaders().get("Location"));
    }

    @Test
    void delete() {
        doNothing().when(service).delete(anyInt());

        ResponseEntity<?> response = controller.delete(ID);

        assertNotNull(response);

        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(service, times(1)).delete(anyInt());
    }

    void start() {
        this.user = new User(ID, NAME, LOGIN, SENHA);
    }
}