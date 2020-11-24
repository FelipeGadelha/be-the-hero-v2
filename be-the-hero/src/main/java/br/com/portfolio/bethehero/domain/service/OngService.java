package br.com.portfolio.bethehero.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.portfolio.bethehero.domain.entity.Ong;
import br.com.portfolio.bethehero.domain.repository.OngRepository;

@Service
public class OngService {

	private final OngRepository ongRepository;
	
	@Autowired
	public OngService(OngRepository ongRepository) {
		this.ongRepository = ongRepository;
	}
	
	public List<Ong> findAll() {
		return ongRepository.findAll();
	}
	
	@Transactional
	public Ong save(Ong ong) {
		Ong save = ongRepository.save(ong);
		 return save;
	}
	
	public Optional<Ong> findById(UUID id) {
		return ongRepository.findById(id);
	}
	
}
