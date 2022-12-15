package br.com.springboot.models;

import java.util.Optional;

public class Lance {
    private Integer valor;
    private Optional<User> usuario;

    public Optional<User> getUsuario() {
        return usuario;
    }

    public void setUsuario(Optional<User> usuario2) {
        this.usuario = usuario2;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
}
