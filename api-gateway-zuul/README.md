# API Gateway

Contexto de aplicação de Floricultura.

API Gateway Zuul é um microserviço do tipo proxy. Este endereço do proxy é o único que deve ficar exposto para o cliente como ponto de acesso à aplicação.

Aplicação para fins de estudo.

## Tecnologias
    Java 8
    Spring Framework (Web, Eureka Client, Cloud Netflix Zuul)
	Maven

## Execução
    $ spring-boot:run

## Web Interfaces

### Endpoints:
#### Obtem as rotas para os serviços via proxy  (comando nativo)
	
	GET http://localhost:5555/actuator/routes
	
	Exemplo resultado:
	
	{
		"/loja-api/**": "loja-api",
		"/transportador-api/**": "transportador-api",
		"/fornecedor-api/**": "fornecedor-api"
	}

#### Exemplo de chamada para um serviço de info fornecedor (via proxy)
	GET http://localhost:5555/fornecedor-api/fornecedor-api/infos/DF