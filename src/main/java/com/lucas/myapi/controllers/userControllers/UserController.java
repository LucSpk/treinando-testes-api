package com.lucas.myapi.controllers.userControllers;

import com.lucas.myapi.domain.User;
import com.lucas.myapi.services.userServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.SysexMessage;

@RestController
@RequestMapping(value = "/usuario")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/{userId}")
    public ResponseEntity<User> findById(@PathVariable Integer userId) {
        User response = service.findById(userId);
        return ResponseEntity.ok().body(response);
    }
}
