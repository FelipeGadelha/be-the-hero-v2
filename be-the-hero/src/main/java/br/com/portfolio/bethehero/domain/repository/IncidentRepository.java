package br.com.portfolio.bethehero.domain.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.portfolio.bethehero.domain.entity.Incident;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, UUID> {

	List<Incident> findByOngId(UUID id); 
	
//	@Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")
//	List<Topico> carregarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso);
	
}
