package br.com.zup.desafios.loteria.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.zup.desafios.loteria.domain.model.Aposta;

@Repository
public interface ApostaRepository extends JpaRepository<Aposta, Long>{

	@Query("select a from Aposta a join fetch a.pessoa where a.pessoa.email = :email order by a.dataCriacao")
	List<Aposta> listarFiltradoPorEmailOrdenadoPorDataCriacao(@Param("email") String email);
	
}
