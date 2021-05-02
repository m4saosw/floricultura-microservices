package br.com.massao.floricultura.microservices.fornecedor.controller;

import br.com.massao.floricultura.microservices.fornecedor.model.InfoFornecedor;
import br.com.massao.floricultura.microservices.fornecedor.service.InfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/infos")
public class InfoController {
    @Autowired
    private InfoService infoService;

    @GetMapping("/{estado}")
    public InfoFornecedor getInfoPorEstado(@PathVariable String estado) {
        log.info("Obtendo informações do Fornecedor do Estado <{}> ", estado);

        InfoFornecedor infoPorEstado = infoService.getInfoPorEstado(estado);
        log.debug("Resultado informações do Fornecedor do Estado <{}> Info <{}>", estado, infoPorEstado);

        return infoPorEstado;
    }
}
