package br.com.portfolio.bethehero.api.dto.response;

import java.util.UUID;

public class OngIdResponse {

	private UUID id;
	
	public OngIdResponse() {
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public OngIdResponse(UUID id) {
		this.id = id;
	}
		
}
