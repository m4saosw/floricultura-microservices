# Loja API

Contexto de aplicação de Floricultura.

Loja API é um microserviço responsável de negócio no lado Loja.
É o principal serviço, fazendo a orquestração da compra.

Aplicação para fins de estudo.

## Tecnologias
    Java 8
    Spring Framework (Boot, Web, Data JPA, Cloud - Netflix Eureka, Config Server)
    MySql/ MariaDB
	Maven
    Lombok

# Características da solução

Esta é uma versão inicial, com diversas limitações:
- sem tratamento de erros
- sem controle transacional
- sem controle de segurança
- sem balanceamento
- entre outros

## Pré-requisitos de execução
    Criar um banco de dados de nome "loja" 

## Execução
    $ spring-boot:run

## Web Interfaces

### Endpoints:
#### Registra uma compra
    POST localhost:8080/loja-api/compras

    Body exemplo:
    {
        "itens": [
            {
            "id": 1,
            "quantidade": 5
            },
            {
            "id": 2,
            "quantidade": 1
            }
        ],
        "endereco": {
        "rua": "rua do cliente",
        "numero": 1,
        "estado": "GO"
        }
    }



## Sobre
Este código fonte é derivado do curso da Alura.