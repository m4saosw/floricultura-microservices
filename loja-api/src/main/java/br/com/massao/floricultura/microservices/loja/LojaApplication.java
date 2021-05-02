package br.com.massao.floricultura.microservices.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class LojaApplication {

    /**
     * Obtem uma instancia de RestTemplate customizada com anotação
     *
     * @LoadBalanced - Necessario para que o Eureka Client consiga resolver os nomes de url e buscar no Eureka Server, atraves do Ribbon
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


    public static void main(String[] args) {
        SpringApplication.run(LojaApplication.class, args);
    }

}
