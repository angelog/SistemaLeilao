package br.com.springboot.models;

import java.util.ArrayList;
import java.util.List;

public class Database {

    static List<Leilao> leiloes;
    static List<User> users;
    public static List<Leilao> getLeilao(){
        if (leiloes == null){
            leiloes = new ArrayList<>();
        }
        return leiloes;
    }

    public void setLeilao(List<Leilao> leilao) {
        Database.leiloes = leilao;
    }

    public static List<User> getUsuarios() {
        return users;
    }

    public void add(Leilao leilao) {
        leiloes.add(leilao);
    }

    public void remove(Leilao leilao){
        leiloes.remove(leilao);
    }
}
