package br.com.massao.floricultura.microservices.fornecedor.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class ItemDoPedidoDTO {

    private long id;

    private int quantidade;
}
