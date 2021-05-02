package br.com.massao.floricultura.microservices.fornecedor.controller;

import br.com.massao.floricultura.microservices.fornecedor.model.Produto;
import br.com.massao.floricultura.microservices.fornecedor.service.ProdutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/{estado}")
    public List<Produto> getProdutosPorEstado(@PathVariable("estado") String estado) {
        log.info("Obtendo Produtos do Estado <{}>", estado);

        List<Produto> produtosPorEstado = produtoService.getProdutosPorEstado(estado);
        log.debug("Resultado Produtos do Estado <{}> Produtos <{}>", estado, produtosPorEstado);
        return produtosPorEstado;
    }
}
