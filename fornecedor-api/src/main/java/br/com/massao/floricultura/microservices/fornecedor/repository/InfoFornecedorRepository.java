package br.com.massao.floricultura.microservices.fornecedor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.massao.floricultura.microservices.fornecedor.model.InfoFornecedor;

@Repository
public interface InfoFornecedorRepository extends CrudRepository<InfoFornecedor, Long>{

	InfoFornecedor findByEstado(String estado);
}
