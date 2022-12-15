package br.com.springboot.Component;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.springboot.models.DataUser;
import br.com.springboot.models.User;

@Component
public class UserComponent {
    

    public List<User> listUsers(){
        List<User> users = DataUser.getUsuarios();
        return users;
    }

    public void addUser(User user){
        List<User> users = DataUser.getUsuarios();
        users.add(user);
    }

    public Optional<User> buscaUser(Integer id ){
        List<User> users = DataUser.getUsuarios();
        Optional<User> userFind = users.stream().filter(user -> user.getId().equals(id)).findFirst();
        return userFind;
    }
    public User deleteUser(Integer id){
        List<User> users = DataUser.getUsuarios();
        Optional<User> userFind = users.stream().filter(user -> user.getId().equals(id)).findFirst();
        if (userFind.isPresent()){
            users.remove(userFind.get());
            return userFind.get();
        }
        return null;
    }
}
