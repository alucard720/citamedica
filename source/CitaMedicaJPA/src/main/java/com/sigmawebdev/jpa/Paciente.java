package com.sigmawebdev.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Pacientes")
public class Paciente extends Persona {
	
	public Paciente() {
		// TODO Auto-generated constructor stub
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Persona persona;
	
	@Column(name="Aseguradora")
	private String aseguradora;
	
	@Column(name="Poliza")
	private String poliza;
	
	@Column(name="Cobertura")
	private String cobertura;

	// *****************************************
	// SET y GETS
	// *****************************************
	public String getAseguradora() {
		return aseguradora;
	}

	public void setAseguradora(String aseguradora) {
		this.aseguradora = aseguradora;
	}

	public String getPoliza() {
		return poliza;
	}

	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}

	public String getCobertura() {
		return cobertura;
	}

	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}
}
