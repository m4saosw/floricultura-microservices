package br.com.massao.floricultura.microservices.loja.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class VoucherDTO {

    private Long numero;

    private LocalDate previsaoParaEntrega;
}
