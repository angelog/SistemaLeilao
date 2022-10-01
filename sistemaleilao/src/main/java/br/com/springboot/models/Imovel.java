package br.com.springboot.models;


import java.util.List;

public class Imovel {
    private Integer id;
    private String tipo;
    private Integer valor;
    private String logradouro;
    private String cidade;
    private String estado;
    private List<Lance> lances;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getEndereco() {
        return logradouro;
    }

    public void setEndereco(String endereco) {
        this.logradouro = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Lance> getLances() {
        return lances;
    }

    public void setLances(List<Lance> lances) {
        this.lances = lances;
    }
}
