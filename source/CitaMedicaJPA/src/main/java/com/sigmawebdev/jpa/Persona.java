package com.sigmawebdev.jpa;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Persona")
@AttributeOverrides({@AttributeOverride(name="id", column= @Column(name = "PersonaId")) })
public abstract class Persona extends Entidad {
	public Persona() {
		// TODO Auto-generated constructor stub
	}

	@Id	
	@Column(name="PersonaId", unique=true, nullable=false)
	private int persoinaId;

	@Column(name="PrimerNombre", length = 50, nullable = true)
	private String primerNombre;

	@Column(name="SegundoNombre", length = 50, nullable = true)
	private String segundoNombre;

	@Column(name="PrimerApellido", length = 50, nullable = true)
	private String primerApellido;

	@Column(name="SegundoApellido", length = 50, nullable = true)
	private String segundoApellido;

	@Column(name="Comercial", length = 150, nullable = true)
	private String comercial;

	@Column(name="Legal", length = 150, nullable = true)
	private String legal;

	@Transient
	@Enumerated(EnumType.STRING)
	@Column(name="Clase")
	private Clase clase;
	
	// *****************************************
	// SET y GETS
	// *****************************************
	
	public String getNombreLegal() {
		return legal;
	}
	
	public void setNombreLegal(String nombreLegal) {
		this.legal = nombreLegal;
	}
	
	public Clase getClasePersona() {
		return clase;
	}
	
	public void setClasePersona(Clase clasePersona) {
		this.clase = clasePersona;
	}
	
	public String getNombre() {
		StringBuilder sb = new StringBuilder(200);
		switch (clase) {
		case EMPRESA:
			sb.append(comercial);
			break;
		case PERSONA:
			sb.append(primerNombre);
			sb.append(" ");
			sb.append(segundoNombre);
			sb.append(" ");
			sb.append(primerApellido);
			sb.append(" ");
			sb.append(segundoApellido);
			break;
		}
		return sb.toString();
	}
}