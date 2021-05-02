package br.com.massao.floricultura.microservices.fornecedor.service;

import br.com.massao.floricultura.microservices.fornecedor.dto.EntregaDTO;
import br.com.massao.floricultura.microservices.fornecedor.dto.VoucherDTO;

public interface EntregaService {
    VoucherDTO reservaEntrega(EntregaDTO pedidoDTO);
}
