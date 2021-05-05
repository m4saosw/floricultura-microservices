package br.com.massao.floricultura.microservices.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
 * Configura a camada de autorização
 */
@Configuration
public class AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService detailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Configura uma lista branca de aplicacoes clientes aceitas (hardcoded apenas para teste)
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // cria um cliente chamado loja

        clients.inMemory()
                .withClient("loja")
                .secret(passwordEncoder.encode("lojapwd"))
                .authorizedGrantTypes("password")
                .scopes("web", "mobile");
    }


    /**
     * Utiliza efetivamente os recursos do WebSecurityConfigurer
     * Injeta objetos do Security na camada de OAuth
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(detailsService);
    }
}
