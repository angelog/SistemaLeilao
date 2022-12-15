package br.com.springboot.Component;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.springboot.models.Database;
import br.com.springboot.models.Financeira;
import br.com.springboot.models.Imovel;
import br.com.springboot.models.Lance;
import br.com.springboot.models.Leilao;
import br.com.springboot.models.Veiculo;
import br.com.springboot.service.UserService;

@Component
public class LeilaoComponent {
    
    @Autowired
    private UserService users;

    public List<Leilao> listaLeilao(){
        List<Leilao> leilao = Database.getLeilao();
        
        return leilao;
    }

    public void addLeilao(Leilao leilao){
        List<Leilao> leiloes = Database.getLeilao();
        leiloes.add(leilao);
    }

    public Optional<Leilao> buscaLeilao(Integer id){
        List<Leilao> leiloes = Database.getLeilao();
        Optional<Leilao> leilaofind = leiloes.stream().filter(leilao -> leilao.getId().equals(id)).findFirst();
        return leilaofind;
    }

    public Leilao deletLeilao(Integer id){
        List<Leilao> leiloes = Database.getLeilao();
        Optional<Leilao> leilaofind = leiloes.stream().filter(leilao -> leilao.getId().equals(id)).findFirst();
        if (leilaofind.isPresent()){
            leiloes.remove(leilaofind.get());
            return leilaofind.get();
        }
        return null;
    }

    public Financeira mudarFinanceira(Integer id, Financeira financeira){
        List<Leilao> leiloes = Database.getLeilao();
        Optional<Leilao> leilaofind = leiloes.stream().filter(leilao -> leilao.getId().equals(id)).findAny();
        if (leilaofind.isPresent()){
            leilaofind.get().setFinanceira(financeira);
            return financeira;
        }

        return null;
    }

    public String buscaFinanceira(Integer id){
        List<Leilao> leiloes = Database.getLeilao();
        Optional<Leilao> leilaofind = leiloes.stream().filter(leilao -> leilao.getId().equals(id)).findAny();
        return leilaofind.map(leilao -> leilao.getFinanceira().info()).orElse(null);
    }

    public String darLance(Integer idLeilao, Integer tipo, Integer idItem, Integer id, Lance lance){
        List<Leilao> leiloes = Database.getLeilao();
        Optional<br.com.springboot.models.User> usuario = users.buscaUser(id);
        if (usuario.isPresent()){
            lance.setUsuario(usuario);

            Optional<Leilao> leilaofilter = leiloes.stream().filter(leilao -> leilao.getId().equals(idLeilao)).findFirst();
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

    public Leilao addImovel(Integer id, Imovel imovel){
        List<Leilao> leiloes = Database.getLeilao();
        Optional<Leilao> leilaoadd = leiloes.stream().filter(leilao -> leilao.getId().equals(id)).findFirst();
        if (leilaoadd.isPresent()){
            leilaoadd.get().getImovel().add(imovel);
            return leilaoadd.get();
        }
        return null;
    }

    public Imovel deleteImovel(Integer id, Integer idImovel){
        List<Leilao> leiloes = Database.getLeilao();
        Optional<Leilao> leilaoadd = leiloes.stream().filter(leilao -> leilao.getId().equals(id)).findFirst();
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

    public Leilao addVeiculo (Integer id, Veiculo veiculo){
        if(veiculo.getTipo().equals("Carro") || veiculo.getTipo().equals("Moto")){

            List<Leilao> leiloes = Database.getLeilao();
            Optional<Leilao> leilaoadd = leiloes.stream().filter(leilao -> leilao.getId().equals(id)).findFirst();
            if (leilaoadd.isPresent()){
                leilaoadd.get().getVeiculo().add(veiculo);
                return leilaoadd.get();
            }
        }
        return null;
    }

    public Veiculo deleteVeiculo(Integer id,Integer idVeiculo){

        List<Leilao> leiloes = Database.getLeilao();
        Optional<Leilao> leilaoadd = leiloes.stream().filter(leilao -> leilao.getId().equals(id)).findFirst();
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
}
