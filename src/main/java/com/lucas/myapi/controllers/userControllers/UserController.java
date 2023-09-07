package com.lucas.myapi.controllers.userControllers;

import com.lucas.myapi.domain.User;
import com.lucas.myapi.services.userServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.sound.midi.SysexMessage;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<User>> findaAll() { return ResponseEntity.ok().body(service.findAll()); }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User usuario) {
        return ResponseEntity.ok().body(service.update(id, usuario));
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/users/{id}").buildAndExpand(
                        service.create(user).getId()
                ).toUri()
        ).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
