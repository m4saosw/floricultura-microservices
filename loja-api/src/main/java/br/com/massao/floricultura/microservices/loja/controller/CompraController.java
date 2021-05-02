package br.com.massao.floricultura.microservices.loja.controller;

import br.com.massao.floricultura.microservices.loja.dto.CompraDTO;
import br.com.massao.floricultura.microservices.loja.model.Compra;
import br.com.massao.floricultura.microservices.loja.service.CompraService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("/compras")
public class CompraController {
    @Autowired
    private CompraService compraService;

    @GetMapping("/{id}")
    public Compra getById(@PathVariable("id") Long id) {
        log.info("Obtendo compras do id <{}>", id);

        return compraService.getById(id);
    }

    @PostMapping
    public void realizaCompra(@RequestBody CompraDTO compra) {
        log.info("Registrando nova Compra <{}>", compra);

        compraService.realizaCompra(compra);
    }
}
