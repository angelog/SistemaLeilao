package br.com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.springboot.Component.LeilaoComponent;
import br.com.springboot.models.Financeira;
import br.com.springboot.models.Imovel;
import br.com.springboot.models.Lance;
import br.com.springboot.models.Leilao;
import br.com.springboot.models.Veiculo;

@Service
public class LeilaoService {
    @Autowired
    private LeilaoComponent leiloes;

    public List<Leilao> listaLeilao(){
        return leiloes.listaLeilao();
    }

    public void addLeilao(Leilao leilao){
        leiloes.addLeilao(leilao);
    }

    public Optional<Leilao> buscaLeilao(Integer id){
        return leiloes.buscaLeilao(id);
    }

    public Leilao deletLeilao(Integer id){
        return leiloes.deletLeilao(id);
    }

    public Financeira mudarFinanceira(Integer id, Financeira financeira){
        return leiloes.mudarFinanceira(id, financeira);
    }

    public String buscaFinanceira(Integer id){
        return leiloes.buscaFinanceira(id);
    }

    public String darLance(Integer idLeilao, Integer tipo, Integer idItem, Integer id, Lance lance){
        return leiloes.darLance(idLeilao, tipo, idItem, id, lance);
    }

    public Leilao addImovel(Integer id, Imovel imovel){
        return leiloes.addImovel(id, imovel);
    }

    public Imovel deleteImovel(Integer id, Integer idImovel){
        return leiloes.deleteImovel(id, idImovel);
    }

    public Leilao addVeiculo (Integer id, Veiculo veiculo){
        return leiloes.addVeiculo(id, veiculo);
    }

    public Veiculo deleteVeiculo(Integer id,Integer idVeiculo){
        return leiloes.deleteVeiculo(id, idVeiculo);
    }
}
