package br.com.massao.floricultura.microservices.loja.service.client;

import br.com.massao.floricultura.microservices.loja.dto.InfoEntregaDTO;
import br.com.massao.floricultura.microservices.loja.dto.VoucherDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class TransportadorClient {
    @Autowired
    private RestTemplate client;

    public VoucherDTO reservaEntrega(InfoEntregaDTO pedidoDTO) {
        String url = "http://transportador-api/transportador-api/entregas";

        ResponseEntity<VoucherDTO> exchange = client.postForEntity(url, pedidoDTO, VoucherDTO.class);

        return exchange.getBody();
    }
}
