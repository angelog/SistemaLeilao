package br.com.springboot.controllers;

import br.com.springboot.models.DataUser;
import br.com.springboot.models.Imovel;
import br.com.springboot.models.Leilao;
import br.com.springboot.models.User;
import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userss/")
public class UserController {

    private final DataUser users = new DataUser();
    public UserController(){
        List<User> users = new ArrayList<>();
    }


    @GetMapping("users/{id}")
    public User user(@PathVariable("id") Integer id) {
        Optional<User> userFind =  users.getUsuarios().stream().filter(user -> user.getId().equals(id)).findFirst();
        return userFind.orElse(null);
    }

    @PostMapping("users/")
    public User user(@RequestBody User user){
        users.add(user);
        return user;
    }

    @GetMapping("users/list")
    public List<User> list(){
        return users.getUsuarios();
    }
}
