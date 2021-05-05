# Fornecedor API

Contexto de aplicação de Floricultura.

Fornecedor API é um microserviço responsável de negócio no lado Fornecedor.

Aplicação para fins de estudo.

## Tecnologias
    Java 8
    Spring Framework (Boot, Web, Data JPA, Cloud - Netflix Eureka, Config Server, Sleuth, Security OAuth2)
    MySql/ MariaDB
	Maven
    Lombok

# Características da solução


Esta versão possui:
- balanceamento com Eureka (Ribbon)
- rastreamento de log distribuído com Papertrail e Spring Sleuth
- controle de segurança / autenticação e autorização


## Pré-requisitos de execução
    Criar um banco de dados de nome "fornecedor" 

## Execução
    $ spring-boot:run

## Web Interfaces

### Endpoints:
#### Obtem endereço do fornecedor de determinado Estado
	GET  localhost:8081/fornecedor-api/infos/{estado}

#### Obtem os dados de um pedido

	GET  localhost:8081/fornecedor-api/pedidos/{pedidoId}

#### Obtem os produtos de um determinado Estado

	GET  localhost:8081/fornecedor-api/produtos/{estado}

## Sobre
Este código fonte é derivado do curso da Alura.