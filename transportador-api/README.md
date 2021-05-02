# Transportador API

Contexto de aplicação de Floricultura.

Transportador API é um microserviço responsável de negócio no lado Transportador.

Aplicação para fins de estudo.

## Tecnologias
    Java 8
    Spring Framework (Boot, Web, Data JPA)
    MySql/ MariaDB
	Maven
    Lombok

# Características da solução

Esta é uma versão inicial, com diversas limitações:
- configurações hardcoded
- sem tratamento de erros
- sem controle transacional
- sem controle de segurança
- sem balanceamento
- entre outros

## Pré-requisitos de execução
    Criar um banco de dados de nome "transportador" 

## Execução
    $ spring-boot:run

## Web Interfaces

### Endpoints:
#### Registra um pedido de Entrega e devolve um voucher
	POST http://localhost:8083/transportador-api/entregas



## Sobre
Este código fonte é derivado do curso da Alura.