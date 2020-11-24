package br.com.portfolio.bethehero.api.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public class IncidentResponse {
	
	private UUID id;
	private String title;
	private String description;
	private BigDecimal value;
	
	private UUID ongId;
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public UUID getOngId() {
		return ongId;
	}
	
	public void setOngId(UUID ongId) {
		this.ongId = ongId;
	}	
}
