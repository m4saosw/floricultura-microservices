package br.com.massao.floricultura.microservices.loja.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class EnderecoDTO {

    private String rua;

    private int numero;

    private String estado;
}
