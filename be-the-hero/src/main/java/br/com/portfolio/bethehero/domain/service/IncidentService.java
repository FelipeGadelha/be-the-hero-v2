package br.com.portfolio.bethehero.domain.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.portfolio.bethehero.domain.entity.Incident;
import br.com.portfolio.bethehero.domain.repository.IncidentRepository;

@Service
public class IncidentService {

	private IncidentRepository incidentRepository;
	
	@Autowired
	public IncidentService(IncidentRepository incidentRepository) {
		this.incidentRepository = incidentRepository;
	}
	
	public List<Incident> findAll(){
		List<Incident> incidents = incidentRepository.findAll();
		return incidents;
//		return incidents.stream().map(i -> i.convert()).collect(Collectors.toList());
	}
	
	public List<Incident> findByOngId(UUID id){
		return incidentRepository.findByOngId(id);
	}
	
	@Transactional
	public Incident save(Incident incident) {
		Incident save = incidentRepository.save(incident);
		return save;
	}

	public Optional<Incident> findById(UUID id) {
		return incidentRepository.findById(id);
	}
	
	@Transactional
	public void delete(Incident incident) {
		Objects.requireNonNull(incident.getId());
		incidentRepository.delete(incident);
	}
	
	
}
