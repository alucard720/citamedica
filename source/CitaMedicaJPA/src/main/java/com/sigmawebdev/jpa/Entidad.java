package com.sigmawebdev.jpa;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class Entidad {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CreadoEn")
	private Date fechaCreado;

	@Column(name="CreadoPor", length = 50, nullable = false)
	private String creadoPor;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ModificadoEn")
	private Date fechaModificado;
	
	@Column(name="ModificadoPor", length = 50, nullable = true)
	private String modificadoPor;
	
	public Entidad() {
		this.fechaCreado = Calendar.getInstance().getTime();
	}
	
	// *****************************************
	// SET y GETS
	// *****************************************
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Date getFechaCreado() {
		return fechaCreado;
	}
	public Date getFechaModificado() {
		return fechaModificado;
	}
	public void setFechaModificado(Date fechaModificado) {
		this.fechaModificado = fechaModificado;
	}
	public String getModificadoPor() {
		return modificadoPor;
	}
	public void setModificadoPor(String modificadoPor) {
		this.modificadoPor = modificadoPor;
	}
	public String getCreadoPor() {
		return creadoPor;
	}
	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}
}