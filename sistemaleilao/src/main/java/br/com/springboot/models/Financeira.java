package br.com.springboot.models;

public class Financeira {

    private String nome;
    private Integer cnpj;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCnpj() {
        return cnpj;
    }

    public void setCnpj(Integer cnpj) {
        this.cnpj = cnpj;
    }

    public String info(){
        return "Nome: "+ getNome() + "CNPJ: " + getCnpj();
    }
}
