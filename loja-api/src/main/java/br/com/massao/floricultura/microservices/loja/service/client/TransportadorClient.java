package br.com.massao.floricultura.microservices.loja.service.client;

import br.com.massao.floricultura.microservices.loja.dto.InfoEntregaDTO;
import br.com.massao.floricultura.microservices.loja.dto.VoucherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("transportador-api")
public interface TransportadorClient {

    @PostMapping(path = "/transportador-api/entregas")
    public VoucherDTO reservaEntrega(InfoEntregaDTO pedidoDTO);
}
