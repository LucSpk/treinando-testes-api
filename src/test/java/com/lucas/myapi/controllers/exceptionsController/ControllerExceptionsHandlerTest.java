package com.lucas.myapi.controllers.exceptionsController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ControllerExceptionsHandlerTest {

    @InjectMocks
    private ControllerExceptionsHandler exceptionsHandler;

    @BeforeEach
    void setUp() {
    }

    @Test
    void objectNotFound() {
    }
}