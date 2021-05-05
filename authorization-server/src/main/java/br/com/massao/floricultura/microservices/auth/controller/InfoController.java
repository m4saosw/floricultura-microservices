package br.com.massao.floricultura.microservices.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class InfoController {

    /**
     * Retorna as roles do usuario
     *
     * @param user
     * @return
     */
    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
