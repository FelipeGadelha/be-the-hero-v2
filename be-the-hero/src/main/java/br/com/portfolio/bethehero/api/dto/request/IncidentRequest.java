package br.com.portfolio.bethehero.api.dto.request;

import java.math.BigDecimal;

public class IncidentRequest {

	private String title;
	private String description;
	private BigDecimal value;
	
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
	
}
