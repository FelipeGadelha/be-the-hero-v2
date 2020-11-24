package br.com.portfolio.bethehero.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.portfolio.bethehero.domain.entity.Ong;

@Repository
public interface OngRepository extends JpaRepository<Ong, UUID>{
	
	

}
