package br.com.massao.floricultura.microservices.fornecedor.service;

import br.com.massao.floricultura.microservices.fornecedor.model.Produto;

import java.util.List;

public interface ProdutoService {
    List<Produto> getProdutosPorEstado(String estado);
}
