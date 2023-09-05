package com.lucas.myapi.services.userServices;

import com.lucas.myapi.domain.User;
import com.lucas.myapi.repositories.UserRepository;
import com.lucas.myapi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findById(Integer id) {
        Optional<User> usuario = repository.findById(id);
        return usuario.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User update(Integer id, User newUser) {
        User usuario = this.findById(id);
        usuario.setNome(newUser.getNome());
        usuario.setLogin(newUser.getLogin());
        usuario.setSenha(newUser.getSenha());
        return repository.save(usuario);
    }

    public User create(User user) {
        user.setId(null);
        return repository.save(user);
    }

    public void delete(Integer id) {
        this.findById(id);
        repository.deleteById(id);
    }
}
