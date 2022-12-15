package br.com.springboot.models;

import java.util.ArrayList;
import java.util.List;

public class DataUser {
    static List<User> users;

    public static List<User> getUsuarios() {
        if (users == null){
            users = new ArrayList<>();
        }
        return users;
    }

    public void setUsuarios(List<User> users) {
        DataUser.users = users;
    }
    public void add(User user){
        users.add(user);
    }
    public void remove(User user){
        users.remove(user);
    }
}
