package br.com.portfolio.bethehero.api.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.portfolio.bethehero.api.dto.request.IncidentRequest;
import br.com.portfolio.bethehero.api.dto.response.IncidentIdResponse;
import br.com.portfolio.bethehero.api.dto.response.IncidentResponse;
import br.com.portfolio.bethehero.domain.entity.Incident;
import br.com.portfolio.bethehero.domain.exception.BusinessException;
import br.com.portfolio.bethehero.domain.service.IncidentService;
import br.com.portfolio.bethehero.domain.service.OngService;

@RestController
@RequestMapping("/v1/incidents")
public class IncidentController {

	private final IncidentService incidentService;
	private final OngService ongService;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	public IncidentController(IncidentService incidentService, OngService ongService) {
		this.incidentService = incidentService;
		this.ongService = ongService;
	}
	
	@GetMapping("/profile")
	public ResponseEntity<?> findByOngId(@RequestHeader(required = false, value ="auth") UUID auth){
		List<Incident> incidents = incidentService.findByOngId(auth);
		List<IncidentResponse> IncidentResponses = ToCollectResponse(incidents);
		return ResponseEntity.ok(IncidentResponses);
	}

	@GetMapping
	public ResponseEntity<?> listAll() {
		List<Incident> incidents = incidentService.findAll();
		List<IncidentResponse> IncidentResponses = ToCollectResponse(incidents);
		return ResponseEntity.ok(IncidentResponses);
	 	
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody IncidentRequest incidentRequest, @RequestHeader(required = false, value ="auth") UUID auth) {
		Incident incident = toEntity(incidentRequest);
		incident.setOng(
				ongService.findById(auth).orElseThrow(
						() -> new BusinessException("User not found fot the given ID")
				));
		try {
			var save = toIdResponse(incidentService.save(incident));
			return new ResponseEntity<>(save, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") UUID id, @RequestHeader(required = false, value ="auth") UUID auth) {
		return incidentService.findById(id).map(entity -> {
				if(entity.getOng().getId().equals(auth)) {
					incidentService.delete(entity);					
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>("this ONG is not allowed to delete this incident", HttpStatus.UNAUTHORIZED);
		}).orElseGet( () -> 
		new ResponseEntity<>("incident not found in the database.", HttpStatus.BAD_REQUEST));
	}
	
//	private IncidentRequest toRequest(Incident incident) {
//		return mapper.map(incident, IncidentRequest.class);
//	}
//	
//	private IncidentResponse toResponse(Incident incident) {
//		return mapper.map(incident, IncidentResponse.class);
//	}
	
	private IncidentIdResponse toIdResponse(Incident incident) {
		return mapper.map(incident, IncidentIdResponse.class);
	}
	
	private Incident toEntity(IncidentRequest incidentRequest) {
		return mapper.map(incidentRequest, Incident.class);
	}
	
	private List<IncidentResponse> ToCollectResponse(List<Incident> incidents) {
		return incidents.stream()
				.map(i -> mapper.map(i, IncidentResponse.class))
				.collect(Collectors.toList());
	}
	
}
