package br.com.massao.floricultura.microservices.loja.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {
    /**
     * Configuracao para os requests serem autenticados
     *
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        // apenas /compras eh autenticado
        http.authorizeRequests()
                .antMatchers("/compras/**")
                .hasRole("USER");
    }
}
