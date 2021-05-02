package br.com.massao.floricultura.microservices.fornecedor.repository;

import br.com.massao.floricultura.microservices.fornecedor.model.Entrega;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends CrudRepository<Entrega, Long> {

}
