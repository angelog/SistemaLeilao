package br.com.springboot.controllers;

import br.com.springboot.models.*;
import br.com.springboot.service.LeilaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class LeilaoController {

    @Autowired
    private LeilaoService leilaoService;
    
    // adiciona um leilao
    @PostMapping("leilao/")
    public Leilao leilao(@RequestBody Leilao leilao){
        leilaoService.addLeilao(leilao);
        return leilao;
    }
    
    // lista os leilões
    @GetMapping("leilao/")
    public List<Leilao> leilao(){
        return (List<Leilao>) leilaoService.listaLeilao();
    }
    
    //  busca um leilao
    @GetMapping("leilao/{id}")
    public Leilao leilao(@PathVariable("id") Integer id){
        System.out.println(id);
        Optional<Leilao> leilaofind = leilaoService.buscaLeilao(id);
        return leilaofind.orElse(null);
    }
    
    // deleta um leilao
    @DeleteMapping("leilao/{id}")
    public Leilao list(@PathVariable("id") Integer id){
        return leilaoService.deletLeilao(id);
    }
    
    // mudar financeira do leilão
    @PostMapping("leilao/{id}/financeira")
    public Financeira financeira (@PathVariable("id") Integer id,@RequestBody Financeira financeira){
        return leilaoService.mudarFinanceira(id, financeira);
    }

    // consulta financeira do leilao
    @GetMapping("leilao/{id}/financeira")
    public String financeira (@PathVariable("id") Integer id){
        
        return leilaoService.buscaFinanceira(id);
    }

    // dar lance
    @PostMapping("leilao/lance/user={id}/leilao={idLeilao}/tipo={tipo}/Item={idItem}")
    public String lance(@PathVariable("idLeilao") Integer idLeilao, @PathVariable("tipo") Integer tipo,
    @PathVariable("idItem") Integer idItem,@PathVariable("id") Integer id, @RequestBody Lance lance){
        return leilaoService.darLance(idLeilao, tipo, idItem, id, lance);
    }

    // adiciona um imovel
    @PostMapping("leilao/imovel/leilao={id}")
    public Leilao imovel(@PathVariable("id") Integer id, @RequestBody Imovel imovel){
        return leilaoService.addImovel(id, imovel);
    }

    // deleta um imovel
    @DeleteMapping("leilao/imovel/leilao={id}imovel={idImovel}")
    public Imovel imovel(@PathVariable("id") Integer id, @PathVariable("idImovel") Integer idImovel){
        return leilaoService.deleteImovel(id, idImovel);
    }

    // adiciona um veiculo
    @PostMapping("leilao/veiculo/leilao={id}")
    public Leilao veiculo(@PathVariable("id") Integer id, @RequestBody Veiculo veiculo){
        return leilaoService.addVeiculo(id, veiculo);
    }

    //   deleta um veiculo
    @DeleteMapping("leilao/veiculo/leilao={id}veiculo={idVeiculo}")
    public Veiculo veiculo(@PathVariable("id") Integer id, @PathVariable("idVeiculo") Integer idVeiculo){
        return leilaoService.deleteVeiculo(id, idVeiculo);
    }



}
