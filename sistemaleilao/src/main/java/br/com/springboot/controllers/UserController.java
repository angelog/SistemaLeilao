package br.com.springboot.controllers;


import br.com.springboot.models.*;
import br.com.springboot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class UserController {
    private final Database leiloes = new Database();
    private final DataUser users = new DataUser();

    public UserController(){
        List<Leilao> leilao = new ArrayList<>();
        List<User> user = new ArrayList<>();
        users.setUsuarios(user);
        leiloes.setLeilao(leilao);
    }

    @Autowired
    private UserService userService;

    // busca um usuario
    @GetMapping("users/{id}")
    public User user(@PathVariable("id") Integer id) {
        Optional<User> userFind =  userService.buscaUser(id);
        return userFind.orElse(null);
    }
    // adiciona um usuario
    @PostMapping("users/")
    public User user(@RequestBody User user){
        userService.addUser(user);
        return user;
    }
    // lista os usuarios
    @GetMapping("users/list")
    public List<User> list(){
        return userService.listUsers();
    }

    //remove Usuario
    @DeleteMapping("users/{id}")
    public User userDelete(@PathVariable("id") Integer id) {
        return userService.deleteUser(id);
    }


}
