package br.com.massao.floricultura.microservices.fornecedor.service;

import br.com.massao.floricultura.microservices.fornecedor.dto.EntregaDTO;
import br.com.massao.floricultura.microservices.fornecedor.dto.VoucherDTO;
import br.com.massao.floricultura.microservices.fornecedor.model.Entrega;
import br.com.massao.floricultura.microservices.fornecedor.repository.EntregaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EntregaServiceImpl implements EntregaService {

    @Autowired
    private EntregaRepository repository;

    @Override
    public VoucherDTO reservaEntrega(EntregaDTO pedidoDTO) {

        Entrega entrega = Entrega.builder()
                .dataParaBusca(pedidoDTO.getDataParaEntrega())
                .previsaoParaEntrega(pedidoDTO.getDataParaEntrega().plusDays(1l))
                .enderecoDestino(pedidoDTO.getEnderecoDestino())
                .enderecoOrigem(pedidoDTO.getEnderecoOrigem())
                .pedidoId(pedidoDTO.getPedidoId())
                .build();

        repository.save(entrega);

        VoucherDTO voucher = VoucherDTO.builder()
                .numero(entrega.getId())
                .previsaoParaEntrega(entrega.getPrevisaoParaEntrega())
                .build();
        return voucher;
    }
}
