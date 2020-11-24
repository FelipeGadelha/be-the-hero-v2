package br.com.portfolio.bethehero.api.dto.response;

public class OngNameResponse {

	private String name;
	
	public OngNameResponse(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
