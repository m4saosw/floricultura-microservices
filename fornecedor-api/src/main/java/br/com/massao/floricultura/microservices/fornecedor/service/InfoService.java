package br.com.massao.floricultura.microservices.fornecedor.service;

import br.com.massao.floricultura.microservices.fornecedor.model.InfoFornecedor;

public interface InfoService {
    InfoFornecedor getInfoPorEstado(String estado);
}
