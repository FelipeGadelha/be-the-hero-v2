package br.com.portfolio.bethehero.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.portfolio.bethehero.api.dto.request.OngRequest;
import br.com.portfolio.bethehero.api.dto.response.OngIdResponse;
import br.com.portfolio.bethehero.api.dto.response.OngResponse;
import br.com.portfolio.bethehero.domain.entity.Ong;
import br.com.portfolio.bethehero.domain.service.OngService;

@RestController
@RequestMapping("/v1/ongs")
public class OngController {
	
	
	private final OngService ongService;
	private final ModelMapper mapper;

	@Autowired
	public OngController(OngService ongService, ModelMapper mapper) {
		this.ongService = ongService;
		this.mapper = mapper;
	}
	
	@GetMapping
	public List<OngResponse> findAll() {
		return ToCollectResponse(ongService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody OngRequest ongRequest) {
		System.out.println(ongRequest);
		Ong ong = toEntity(ongRequest);
		System.out.println(ong);
		try {
			OngIdResponse save = toIdResponse(ongService.save(ong));
			return new ResponseEntity<>(save, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	private List<OngResponse> ToCollectResponse(List<Ong> ongs) {
		return ongs.stream()
				.map(o -> mapper.map(o, OngResponse.class))
				.collect(Collectors.toList());
	}
	
	private OngIdResponse toIdResponse(Ong ong) {
		return mapper.map(ong, OngIdResponse.class);
	}
	
	private Ong toEntity(OngRequest ongRequest) {
		return mapper.map(ongRequest, Ong.class);
	}
	
	
}
