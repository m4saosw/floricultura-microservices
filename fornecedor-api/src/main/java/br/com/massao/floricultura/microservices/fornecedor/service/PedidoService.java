package br.com.massao.floricultura.microservices.fornecedor.service;

import br.com.massao.floricultura.microservices.fornecedor.dto.ItemDoPedidoDTO;
import br.com.massao.floricultura.microservices.fornecedor.model.Pedido;

import java.util.List;

public interface PedidoService {
    Pedido realizaPedido(List<ItemDoPedidoDTO> itens);

    Pedido getPedidoPorId(Long id);
}
