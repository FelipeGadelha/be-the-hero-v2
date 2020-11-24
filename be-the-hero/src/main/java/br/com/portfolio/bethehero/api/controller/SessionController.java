package br.com.portfolio.bethehero.api.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.portfolio.bethehero.api.dto.request.OngIdRequest;
import br.com.portfolio.bethehero.api.dto.response.OngNameResponse;
import br.com.portfolio.bethehero.domain.entity.Ong;
import br.com.portfolio.bethehero.domain.service.OngService;

@RestController
public class SessionController {

	private final OngService ongService;
	
	@Autowired
	public SessionController(OngService ongService) {
		this.ongService = ongService;
	}
	
	@PostMapping("sessions")
	public ResponseEntity<?> createSession(@RequestBody OngIdRequest ongIdRequest) {
		System.out.println(ongIdRequest);
		Optional<Ong> optional = ongService.findById(UUID.fromString(ongIdRequest.getId()));
		if (!optional.isPresent()) {
			return new ResponseEntity<>("No ONG found with this ID", HttpStatus.BAD_REQUEST);
		}
		var ongName = new OngNameResponse(optional.get().getName());
		
		return new ResponseEntity<>(ongName, HttpStatus.CREATED);
	}
	

}
