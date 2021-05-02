package br.com.massao.floricultura.microservices.fornecedor.controller;

import br.com.massao.floricultura.microservices.fornecedor.dto.EntregaDTO;
import br.com.massao.floricultura.microservices.fornecedor.dto.VoucherDTO;
import br.com.massao.floricultura.microservices.fornecedor.service.EntregaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @PostMapping
    public VoucherDTO reservaEntrega(@RequestBody EntregaDTO pedidoDTO) {
        log.info("Reservando entrega para o Pedido <{}>", pedidoDTO);

        return entregaService.reservaEntrega(pedidoDTO);
    }
}
