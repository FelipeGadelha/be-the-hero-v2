package br.com.portfolio.bethehero.domain.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Incident extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	private String title;
	private String description;
	private BigDecimal value;
	
	@ManyToOne
	private Ong ong;

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

	public Ong getOng() {
		return ong;
	}

	public void setOng(Ong ong) {
		this.ong = ong;
	}
}
