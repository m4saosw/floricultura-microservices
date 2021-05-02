package br.com.massao.floricultura.microservices.loja.service;

import br.com.massao.floricultura.microservices.loja.dto.*;
import br.com.massao.floricultura.microservices.loja.model.Compra;
import br.com.massao.floricultura.microservices.loja.model.CompraState;
import br.com.massao.floricultura.microservices.loja.repository.CompraRepository;
import br.com.massao.floricultura.microservices.loja.service.client.FornecedorClient;
import br.com.massao.floricultura.microservices.loja.service.client.TransportadorClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class CompraServiceImpl implements CompraService {
    @Autowired
    private FornecedorClient fornecedorClient;

    @Autowired
    private TransportadorClient transportadorClient;

    @Autowired
    private CompraRepository compraRepository;


    @Override
    public Compra getById(Long id) {
        return compraRepository.findById(id).orElse(new Compra());
    }


    /**
     * Orquestrador da compra. Faz integração com o serviço do fornecedor e da transportadora
     *
     * @param compra
     * @return
     */
    @Override
    public Compra realizaCompra(CompraDTO compra) {
        Compra compraSalva = new Compra();


        // PASSO 1 - LOJA REGISTRA NOVA COMPRA. STATUS DA COMPRA É ATUALIZADA PARA "COMPRA RECEBIDA"
        log.debug("Iniciando nova Compra <{}>", compra);
        log.debug("Atualizando status da compra para <{}>", CompraState.RECEBIDO);
        compraSalva.setState(CompraState.RECEBIDO);
        compraSalva.setEnderecoDestino(compra.getEndereco().toString());
        compraRepository.save(compraSalva);
        compra.setCompraId(compraSalva.getId());


        // PASSO 2 - INVOCA O FORNECEDOR PARA REGISTRAR O PEDIDO. STATUS DA COMPRA É ATUALIZADA PARA "PEDIDO REALIZADO"
        log.debug("Invocando o Fornecedor para registrar o Pedido da Compra <{}>", compra);
        InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado()); // Obtem infos do fornecedor local daquela UF
        InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
        log.debug("Atualizando status da compra para <{}>", CompraState.PEDIDO_REALIZADO);
        compraSalva.setState(CompraState.PEDIDO_REALIZADO);
        compraSalva.setPedidoId(pedido.getId());
        compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
        compraRepository.save(compraSalva);


        // PASSO 3 - INVOCA A TRANSPORTADORA PARA OBTER UM VOUCHER. STATUS DA COMPRA É ATUALIZADA PARA "RESERVA ENTREGA REALIZADA"
        InfoEntregaDTO entrega = InfoEntregaDTO.builder()
                .pedidoId(pedido.getId())
                .dataParaEntrega(LocalDate.now().plusDays(pedido.getTempoDePreparo()))
                .enderecoOrigem(info.getEndereco())
                .enderecoDestino(compraSalva.getEnderecoDestino())
                .build();

        log.debug("Invocando o Transportador para obter um voucher da Compra <{}>", compra);
        VoucherDTO voucher = transportadorClient.reservaEntrega(entrega);
        log.debug("Atualizando status da compra para <{}>", CompraState.RESERVA_ENTREGA_REALIZADA);
        compraSalva.setState(CompraState.RESERVA_ENTREGA_REALIZADA);
        compraSalva.setDataParaEntrega(voucher.getPrevisaoParaEntrega());
        compraSalva.setVoucher(voucher.getNumero());
        compraRepository.save(compraSalva);


        return compraSalva;
    }


    @Override
    public Compra reprocessaCompra(Long id) {
        // TODO - pendente
        return null;
    }

    @Override
    public Compra cancelaCompra(Long id) {
        // TODO - pendente
        return null;
    }

}