package br.com.springboot.models;

import java.util.List;

public class Database {

    public static List<Leilao> leiloes;

    public List<Leilao> getLeilao() {
        return leiloes;
    }

    public void setLeilao(List<Leilao> leilao) {
        Database.leiloes = leilao;
    }

    public void add(Leilao leilao) {
        leiloes.add(leilao);
    }

    public void remove(Leilao leilao){
        leiloes.remove(leilao);
    }
}
