package br.com.massao.floricultura.microservices.fornecedor.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class ReservaDTO {

    public Integer idReserva;

    public Integer tempoDePreparo;
}
