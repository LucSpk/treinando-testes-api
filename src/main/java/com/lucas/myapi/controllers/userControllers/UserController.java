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
        User response = service.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<List<User>> findaAll() {
        List<User> response = service.findAll();
        return ResponseEntity.ok().body(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User usuario) {
        User response = service.update(id, usuario);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User response = service.create(user);
        URI uri = UriComponentsBuilder.fromPath("/users/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
