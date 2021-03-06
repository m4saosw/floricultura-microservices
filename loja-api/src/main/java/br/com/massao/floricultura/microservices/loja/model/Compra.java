package br.com.massao.floricultura.microservices.loja.model;

import lombok.*;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long pedidoId;

	private Integer tempoDePreparo;

	private String enderecoDestino;

	private LocalDate dataParaEntrega;

	private Long voucher;

	@Enumerated(EnumType.STRING)
	private CompraState state;
}
