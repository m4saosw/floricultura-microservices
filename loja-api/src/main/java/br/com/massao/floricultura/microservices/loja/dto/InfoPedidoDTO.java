package br.com.massao.floricultura.microservices.loja.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class InfoPedidoDTO {

    private Long id;

    private Integer tempoDePreparo;
}
