package br.com.massao.floricultura.microservices.fornecedor.service;

import br.com.massao.floricultura.microservices.fornecedor.dto.ItemDoPedidoDTO;
import br.com.massao.floricultura.microservices.fornecedor.model.Pedido;
import br.com.massao.floricultura.microservices.fornecedor.model.PedidoItem;
import br.com.massao.floricultura.microservices.fornecedor.model.Produto;
import br.com.massao.floricultura.microservices.fornecedor.repository.PedidoRepository;
import br.com.massao.floricultura.microservices.fornecedor.repository.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Pedido realizaPedido(List<ItemDoPedidoDTO> itens) {

        if (itens == null) {
            return null;
        }

        List<PedidoItem> pedidoItens = toPedidoItem(itens);
        Pedido pedido = new Pedido(pedidoItens);
        pedido.setTempoDePreparo(itens.size());
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido getPedidoPorId(Long id) {
        return this.pedidoRepository.findById(id).orElse(new Pedido());
    }

    private List<PedidoItem> toPedidoItem(List<ItemDoPedidoDTO> itens) {

        List<Long> idsProdutos = itens
                .stream()
                .map(item -> item.getId())
                .collect(Collectors.toList());

        List<Produto> produtosDoPedido = produtoRepository.findByIdIn(idsProdutos);

        List<PedidoItem> pedidoItens = itens
                .stream()
                .map(item -> {
                    Produto produto = produtosDoPedido
                            .stream()
                            .filter(p -> p.getId() == item.getId())
                            .findFirst().get();

                    PedidoItem pedidoItem = PedidoItem.builder()
                            .produto(produto)
                            .quantidade(item.getQuantidade()).build();

                    return pedidoItem;
                })
                .collect(Collectors.toList());
        return pedidoItens;
    }
}
