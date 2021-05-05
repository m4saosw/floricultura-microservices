# Loja API

Contexto de aplicação de Floricultura.

Loja API é um microserviço responsável de negócio no lado Loja.
É o principal serviço, fazendo a orquestração da compra.

Aplicação para fins de estudo.

## Tecnologias
    Java 8
    Spring Framework (Boot, Web, Data JPA, Cloud - Netflix Eureka, Config Server, Sleuth, Hystrix)
    MySql/ MariaDB
	Maven
    Lombok

# Características da solução

Esta versão possui:
- balanceamento com Eureka (Ribbon)
- rastreamento de log distribuído com Papertrail e Spring Sleuth
- melhor desempenho e resiliência com uso de circuit breaker e fallback com Hystrix
- controle de segurança / autenticação e autorização

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