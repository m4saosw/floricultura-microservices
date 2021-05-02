package br.com.massao.floricultura.microservices.loja.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class CompraDTO {

    @JsonIgnore
    private Long compraId;

    private List<ItemDaCompraDTO> itens;

    private EnderecoDTO endereco;
}
