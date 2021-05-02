package br.com.massao.floricultura.microservices.fornecedor.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pedidoId;

    private LocalDate dataParaBusca;

    private LocalDate previsaoParaEntrega;

    private String enderecoOrigem;

    private String enderecoDestino;
}
