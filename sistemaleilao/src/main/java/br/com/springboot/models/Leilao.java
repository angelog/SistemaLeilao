package br.com.springboot.models;

import java.util.Date;
import java.util.List;

public class Leilao {

    private Integer id;
    private Date inicio;
    private Date fim;
    private String tipo;
    private String logradouro;
    private String cidade;
    private String estado;
    private Financeira financeira;
    private List<Imovel> imovel;
    private List<Veiculo> veiculo;
    private String status;

    public String getStatus() {
        //virificar horario de fim com o atual para saber e dps setar o status.
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String endereco) {
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

    public Financeira getFinanceira() {
        return financeira;
    }

    public void setFinanceira(Financeira financeira) {
        this.financeira = financeira;
    }

    public List<Imovel> getImovel() {
        return imovel;
    }

    public void setImovel(List<Imovel> imovel) {
        this.imovel = imovel;
    }

    public List<Veiculo> getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(List<Veiculo> veiculo) {
        this.veiculo = veiculo;
    }
}
