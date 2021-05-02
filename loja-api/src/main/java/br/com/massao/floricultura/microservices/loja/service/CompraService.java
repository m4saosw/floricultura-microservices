package br.com.massao.floricultura.microservices.loja.service;

import br.com.massao.floricultura.microservices.loja.dto.CompraDTO;
import br.com.massao.floricultura.microservices.loja.model.Compra;

public interface CompraService {
    Compra getById(Long id);

    Compra realizaCompra(CompraDTO compra);

    Compra reprocessaCompra(Long id);

    Compra cancelaCompra(Long id);
}
