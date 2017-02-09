package dr.gob.hacienda.servicios.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APLICACIONES")
public class Aplicacion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//*****************************************
	// Declaracion de Variables
	//*****************************************
	@Id
	@GeneratedValue
	@Column(name = "ID_APLICACION")
	private int aplicacionId;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "RUTA")
	private String ruta;
	
	@Column(name = "DISPONIBLE")
    private Boolean disponible;


	// *****************************************
	// SET y GETS
	// *****************************************    
	public int getAplicacionId() {
		return aplicacionId;
	}

	public void setAplicacionId(int aplicacionId) {
		this.aplicacionId = aplicacionId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
}