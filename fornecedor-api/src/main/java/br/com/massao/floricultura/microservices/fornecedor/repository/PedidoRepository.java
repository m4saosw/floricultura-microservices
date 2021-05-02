package br.com.massao.floricultura.microservices.fornecedor.repository;

import br.com.massao.floricultura.microservices.fornecedor.model.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {

}
