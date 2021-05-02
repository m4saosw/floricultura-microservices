package br.com.massao.floricultura.microservices.loja.repository;

import br.com.massao.floricultura.microservices.loja.model.Compra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends CrudRepository<Compra, Long>{

}
