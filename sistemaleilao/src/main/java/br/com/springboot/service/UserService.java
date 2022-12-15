package br.com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.Component.UserComponent;
import br.com.springboot.models.User;

@Service
public class UserService {
    @Autowired
    private UserComponent users;

    public List<User> listUsers(){
        return users.listUsers();
    }

    public void addUser(User user){
        users.addUser(user);
    }

    public Optional<User> buscaUser(Integer id ){
        return users.buscaUser(id);
    }
    public User deleteUser(Integer id){
        return users.deleteUser(id);
    }
}
