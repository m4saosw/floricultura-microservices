package br.com.massao.floricultura.microservices.loja.service.client;

import br.com.massao.floricultura.microservices.loja.dto.InfoFornecedorDTO;
import br.com.massao.floricultura.microservices.loja.dto.InfoPedidoDTO;
import br.com.massao.floricultura.microservices.loja.dto.ItemDaCompraDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class FornecedorClient {
    @Autowired
    private RestTemplate client;

    public InfoFornecedorDTO getInfoPorEstado(String estado) {
        String url = "http://fornecedor-api/fornecedor-api/infos/" + estado;

        ResponseEntity<InfoFornecedorDTO> exchange = client.getForEntity(url, InfoFornecedorDTO.class);

        return exchange.getBody();
    }


    public InfoPedidoDTO realizaPedido(List<ItemDaCompraDTO> itens) {
        String url = "http://fornecedor-api/fornecedor-api/pedidos";
        ResponseEntity<InfoPedidoDTO> exchange = client.postForEntity(url, itens, InfoPedidoDTO.class);

        return exchange.getBody();
    }
}
