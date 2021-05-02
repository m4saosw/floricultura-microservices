package br.com.massao.floricultura.microservices.fornecedor.controller;

import br.com.massao.floricultura.microservices.fornecedor.dto.ItemDoPedidoDTO;
import br.com.massao.floricultura.microservices.fornecedor.model.Pedido;
import br.com.massao.floricultura.microservices.fornecedor.service.PedidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido realizaPedido(@RequestBody List<ItemDoPedidoDTO> produtos) {
        log.info("Realizando novo Pedido relativo aos Produtos <{}>", produtos);

        Pedido pedido = pedidoService.realizaPedido(produtos);
        log.debug("Resultado do novo Pedido relativo aos Produtos <{}> Pedido <{}>", produtos, pedido);

        return pedido;
    }

    @GetMapping("/{id}")
    public Pedido getPedidoPorId(@PathVariable Long id) {
        log.info("Obtendo Pedido do Id <{}>", id);

        Pedido pedidoPorId = pedidoService.getPedidoPorId(id);
        log.debug("Resultado Pedido do Id <{}> Pedido <{}>", id, pedidoPorId);

        return pedidoPorId;
    }
}
