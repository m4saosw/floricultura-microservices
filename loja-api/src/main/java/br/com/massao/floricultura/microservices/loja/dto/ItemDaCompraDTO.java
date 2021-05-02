package br.com.massao.floricultura.microservices.loja.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class ItemDaCompraDTO {

    private long id;

    private int quantidade;
}
