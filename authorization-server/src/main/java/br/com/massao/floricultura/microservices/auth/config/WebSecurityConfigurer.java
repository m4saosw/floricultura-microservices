package br.com.massao.floricultura.microservices.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configura a camada de segurança (Security)
 * Expoe alguns beans para a aplicação, que serão posteriormente injetados na camada de autorização
 */
@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }


    /**
     * Criptografa o password
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * Configura uma lista branca de usuarios em memoria (hardcoded apenas para teste)
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // cria o usuario joao

        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("joao")
                .password(passwordEncoder().encode("joaopwd"))
                .roles("USER");
    }

}
