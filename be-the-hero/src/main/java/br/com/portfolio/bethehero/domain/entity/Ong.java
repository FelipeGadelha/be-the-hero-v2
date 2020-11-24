package br.com.portfolio.bethehero.domain.entity;

import javax.persistence.Entity;

@Entity
public class Ong extends AbstractEntity{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private String whatsapp;
	private String city;
	private String uf;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWhatsapp() {
		return whatsapp;
	}
	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	@Override
	public String toString() {
		return "Ong [name=" + name + ", email=" + email + ", whatsapp=" + whatsapp + ", city=" + city + ", uf=" + uf
				+ "]";
	}
	
}
