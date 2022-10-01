package br.com.springboot.controllers;


import br.com.springboot.models.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class LeilaoController {

    private final Database leiloes = new Database();
    private final DataUser users = new DataUser();
    public LeilaoController(){
        List<Leilao> leilao = new ArrayList<>();
        List<User> user = new ArrayList<>();
        users.setUsuarios(user);
        leiloes.setLeilao(leilao);
    }
    // busca um usuario
    @GetMapping("users/{id}")
    public User user(@PathVariable("id") Integer id) {
        Optional<User> userFind =  users.getUsuarios().stream().filter(user -> user.getId().equals(id)).findFirst();
        return userFind.orElse(null);
    }
    // adiciona um usuario
    @PostMapping("users/")
    public User user(@RequestBody User user){
        users.add(user);
        return user;
    }
    // lista os usuarios
    @GetMapping("users/list")
    public List<User> list(){
        return users.getUsuarios();
    }

    //remove Usuario
    @DeleteMapping("users/{id}")
    public User userDelete(@PathVariable("id") Integer id) {
        Optional<User> userFind =  users.getUsuarios().stream().filter(user -> user.getId().equals(id)).findFirst();
        if (userFind.isPresent()){
            users.remove(userFind.get());
            return userFind.get();
        }

        return null;
    }

    // adiciona um leilao
    @PostMapping("leilao/")
    public Leilao leilao(@RequestBody Leilao leilao){

        leiloes.add(leilao);
        return leilao;
    }

    // dar lance
    @PostMapping("leilao/lance/user={id}/leilao={idLeilao}/tipo={tipo}/Item={idItem}")
    public String lance(@PathVariable("idLeilao") Integer idLeilao, @PathVariable("tipo") Integer tipo,
                       @PathVariable("idItem") Integer idItem,@PathVariable("id") Integer id, @RequestBody Lance lance){

        Optional<User> usuario = users.getUsuarios().stream().filter(user -> user.getId().equals(id)).findFirst();
        if (usuario.isPresent()){
            lance.setName(usuario.get().getName());
            lance.setEmail(usuario.get().getEmail());
            lance.setUsername(usuario.get().getUsername());

            Optional<Leilao> leilaofilter = leiloes.getLeilao().stream().filter(leilao -> leilao.getId().equals(idLeilao)).findFirst();
            if (leilaofilter.isPresent()){
                if (tipo == 1){
                    Optional<Veiculo> veiculo = leilaofilter.get().getVeiculo().stream().filter(
                            veiculos -> veiculos.getId().equals(idItem)).findFirst();
                    if (veiculo.isPresent()) {
                        veiculo.get().getLances().add(lance);
                        return "Lance de: "+ lance.getValor() + ",\n feito no veiculo"+ veiculo.get().getId()+",\n" +
                                " no leilão: "+leilaofilter.get().getId();
                    }
                    return null;
                }
                if (tipo == 2) {
                    Optional<Imovel> imovel = leilaofilter.get().getImovel().stream().filter(
                            imoveis -> imoveis.getId().equals(idItem)).findFirst();
                    if (imovel.isPresent()){
                        imovel.get().getLances().add(lance);
                        return "Lance de: "+ lance.getValor() + ",\n feito no veiculo"+ imovel.get().getId()+",\n" +
                                " no leilão: "+leilaofilter.get().getId();
                    }
                    return null;
                }
                return null;
            }

        }

        return null;
    }

    // adiciona um imovel
    @PostMapping("leilao/imovel/leilao={id}")
    public Leilao imovel(@PathVariable("id") Integer id, @RequestBody Imovel imovel){
        Optional<Leilao> leilaoadd = leiloes.getLeilao().stream().filter(leilao -> leilao.getId().equals(id)).findFirst();
        if (leilaoadd.isPresent()){
            leilaoadd.get().getImovel().add(imovel);
            return leilaoadd.get();
        }
        return null;
    }

    // deleta um imovel
    @DeleteMapping("leilao/imovel/leilao={id}imovel={idImovel}")
    public Imovel imovel(@PathVariable("id") Integer id, @PathVariable("idImovel") Integer idImovel){
        Optional<Leilao> leilaoadd = leiloes.getLeilao().stream().filter(leilao -> leilao.getId().equals(id)).findFirst();
        if (leilaoadd.isPresent()){
            Optional<Imovel> imove = leilaoadd.get().getImovel().stream().filter(imovel -> imovel.getId().equals(
                    idImovel)).findFirst();
            if (imove.isPresent()) {
                leilaoadd.get().getImovel().remove(imove.get());
                return imove.get();
            }
            return null;
        }
        return null;
    }

    // adiciona um veiculo
    @PostMapping("leilao/veiculo/leilao={id}")
    public Leilao veiculo(@PathVariable("id") Integer id, @RequestBody Veiculo veiculo){
        Optional<Leilao> leilaoadd = leiloes.getLeilao().stream().filter(leilao -> leilao.getId().equals(id)).findFirst();
        if (leilaoadd.isPresent()){
            leilaoadd.get().getVeiculo().add(veiculo);
            return leilaoadd.get();
        }
        return null;
    }

    //   deleta um veiculo
    @DeleteMapping("leilao/veiculo/leilao={id}veiculo={idVeiculo}")
    public Veiculo veiculo(@PathVariable("id") Integer id, @PathVariable("idVeiculo") Integer idVeiculo){
        Optional<Leilao> leilaoadd = leiloes.getLeilao().stream().filter(leilao -> leilao.getId().equals(id)).findFirst();
        if (leilaoadd.isPresent()){
            Optional<Veiculo> veicul = leilaoadd.get().getVeiculo().stream().filter(veiculo -> veiculo.getId().equals(
                    idVeiculo)).findFirst();
            if (veicul.isPresent()) {
                leilaoadd.get().getVeiculo().remove(veicul.get());
                return veicul.get();
            }
            return null;
        }
        return null;
    }

    //  busca um leilao
    @GetMapping("leilao/{id}")
    public Leilao leilao(@PathVariable("id") Integer id){
        System.out.println(id);
        Optional<Leilao> leilaofind = leiloes.getLeilao().stream().filter(leilao -> leilao.getId().equals(id)).findFirst();
        return leilaofind.orElse(null);
    }

    // deleta um leilao
    @DeleteMapping("leilao/{id}")
    public Leilao list(@PathVariable("id") Integer id){
        System.out.println(id);
        Optional<Leilao> leilaofind = leiloes.getLeilao().stream().filter(leilao -> leilao.getId().equals(id)).findAny();
        if (leilaofind.isPresent()){
            leiloes.remove(leilaofind.get());
            return leilaofind.get();
        }
        return null;

    }

    // lista os leilões
    @GetMapping("leilao/")
    public List<Leilao> leilao(){

        return leiloes.getLeilao();
    }

    // mudar financeira do leilão
    @PostMapping("leilao/{id}/financeira")
    public Financeira financeira (@PathVariable("id") Integer id,@RequestBody Financeira financeira){
        Optional<Leilao> leilaofind = leiloes.getLeilao().stream().filter(leilao -> leilao.getId().equals(id)).findAny();
        if (leilaofind.isPresent()){
            leilaofind.get().setFinanceira(financeira);
            return financeira;
        }

        return null;
    }

    // consulta financeira do leilao
    @GetMapping("leilao/{id}/financeira")
    public String financeira (@PathVariable("id") Integer id){
        Optional<Leilao> leilaofind = leiloes.getLeilao().stream().filter(leilao -> leilao.getId().equals(id)).findAny();
        return leilaofind.map(leilao -> leilao.getFinanceira().info()).orElse(null);

    }

}
