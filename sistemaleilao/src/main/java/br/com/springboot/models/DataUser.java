package br.com.springboot.models;

import java.util.List;

public class DataUser {
    public static List<User> users;

    public List<User> getUsuarios() {
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
