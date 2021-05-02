# Fornecedor API

Contexto de aplicação de Floricultura.

Fornecedor API é um microserviço responsável de negócio no lado Fornecedor.

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