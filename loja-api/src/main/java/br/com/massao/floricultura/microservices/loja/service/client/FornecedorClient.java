package br.com.massao.floricultura.microservices.loja.service.client;

import br.com.massao.floricultura.microservices.loja.dto.InfoFornecedorDTO;
import br.com.massao.floricultura.microservices.loja.dto.InfoPedidoDTO;
import br.com.massao.floricultura.microservices.loja.dto.ItemDaCompraDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("fornecedor-api")
public interface FornecedorClient {

    @GetMapping("/fornecedor-api/infos/{estado}")
    InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);

    @PostMapping(value = "/fornecedor-api/pedidos")
    InfoPedidoDTO realizaPedido(List<ItemDaCompraDTO> itens);
}
