# Authorization Server - OAuth2

Contexto de aplicação de Floricultura.

Authorization Server é o servidor de autorização OAuth2 da aplicação.

Aplicação para fins de estudo.

## Tecnologias
    Java 8
    Spring Framework (Web, Security Cloud OAuth2)
	Maven

## Execução
    $ spring-boot:run

## Web Interfaces
### Obtem um token
	POST localhost:8088/oauth/token
	
	Exemplo:
	
	Auth - type basic auth
	
	Body (form-data):
	
	scope: web
	grant_type: password
	username: joao
	password: joaopwd
	
### Obtem dados do usuario (roles cadastradas)
	GET localhost:8088/user
	
	Header:
	Auth type - OAuth2  Access Token: Bearer <preencher>
	
	
	

### Endpoints:

	

