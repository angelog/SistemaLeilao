# SistemaLeilão
## Entrega Parcial Usando Postman
### Requisitos: 
- Java 8 ou mais;
- Maven

### Rotas:

#### localhost:8080/users/ Method : Post
- Insere um novo usuario
 - exemplo: {
    "id": 1,
    "name": "gabriel",
    "username": "angelo"
}

#### localhost:8080/users/list Method : Get
- Lista todos os Usuarios

#### localhost:8080/users/<id> Method : Delete
- Delete um Usuario

#### localhost:8080/leilao/  Method : Post
 - Insere um novo Leilão
  - exemplo: 	{
    "inicio": "2022-05-02" ,
    "id":1,
    "fim": "2022-05-03",
    "tipo": "online",
    "logradouro": "rua xyz, 280",
    "cidade":"São jose dos campos",
    "estado":"SP",
    "financeira":{"nome":"Brandesco", "cnpj":123456789},
    "imovel":[],
    "veiculo":[]
}
 
#### localhost:8080/leilao/<id>   Method : Get
 - Busca um leilão
 
#### localhost:8080/leilao/  Method : Get
 - Lista os leilões
 
#### localhost:8080/leilao/<id>   Method : Delete
 - Deleta um Leilão
 
#### localhost:8080/leilao/imovel/leilao=<id>  Method : post 
- Insere um novo imovel em um leilão
 - exemplo: {
    "id":1,
    "tipo":"Casa",
    "valor":120000,
    "logradouro":"Rua ismael 280",
    "cidade":"São Paulo",
    "estado":"SP",
    "lances":[]
}
 
 #### localhost:8080/leilao/imovel/leilao=<id>imovel=<idImovel>   Method : Delete
 - Deleta um imovel de um leilão
 
 #### localhost:8080/leilao/veiculo/leilao=<id>   Method : Post
 - Insere um novo veiculo em um leilão
  - exemplo: {
    "id":1,
    "tipo":"Carro",
    "valor":12000,
    "placa":"ava1234",
    "marca":"Chevrolet",
    "modelo":"Onix",
    "cor":"Azul",
    "ano":2019,
    "lances":[]
}
 
#### localhost:8080/leilao/veiculo/leilao=<id>/veiculo=<idVeiculo>   Method : Delete 
 - Deleta um veiculo de um leilão
 
#### localhost:8080/leilao/<id>/financeira   Method : Post
- Define a financeira responsavel pelo leilão
 - exemplo: {"nome":"Brandesco", "cnpj":123456789}
 
#### localhost:8080/leilao/<id>/financeira   Method : Get
- Busca a financeira responsavel pelo leilão
 
#### localhost:8080/leilao/lance/user=<id>/leilao=<idLeilao>/tipo=<tipo>/Item=<idItem>   Method : Post
 - Da um lance para o item de um leilão
 - exemplo: {"valor":10000}
 
