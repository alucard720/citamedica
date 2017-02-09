package dr.gob.hacienda.servicios.modelo;

import java.io.Serializable;
import java.net.URI;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import dr.gob.hacienda.servicios.utilitarios.DeserializadorFechaNorticA4;
import dr.gob.hacienda.servicios.utilitarios.SerializadorFechaNorticA4;

@Entity
@Table(name = "ARCHIVOS")
public class Archivo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// *****************************************
	// Declaracion de Variables
	// *****************************************
	@Id
	@GeneratedValue
	@Column(name = "ID_ARCHIVO")
	private int archivoId;

	@NaturalId
	@Column(name = "ID_ARCHIVO_BLOB", length = 100)
	private String idArchivoBlob;

	@Column(name = "COD_HASH_UNICO", length = 512)
	private String codHashUnico;

	@Column(name = "NOMBRE", length = 100, nullable = false)
	private String nombre;

	@Column(name = "RUTA", length = 512, nullable = false)
	private String ruta;

	@Column(name = "DESCRIPCION", length = 255)
	private String descripcion;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "ID_APLICACION")	
	private Aplicacion aplicacion;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd,HH:00", timezone = "AST")	
	@Column(name = "FCH_ARCHIVO")
	private Date deFecha;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd,HH:00", timezone = "AST")
	@Column(name = "FCH_EXPIRA")
	private Date expira;

	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO")	
	private TipoArchivo tipo;

	// *****************************************
	// SET y GETS
	// *****************************************
	public TipoArchivo getTipo() {
		return tipo;
	}

	public void setTipo(TipoArchivo tipoArchivo) {
		this.tipo = tipoArchivo;
	}
	
	public int getArchivoId() {
		return archivoId;
	}

	public void setArchivoId(int archivoId) {
		this.archivoId = archivoId;
	}

	public String getIdArchivoBlob() {
		return idArchivoBlob;
	}

	public void setIdArchivoBlob(String idArchivoBlob) {
		this.idArchivoBlob = idArchivoBlob;
	}

	public String getCodHashUnico() {
		return codHashUnico;
	}

	public void setCodHashUnico(String codHashUnico) {
		this.codHashUnico = codHashUnico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}
	
	public URI getRuta() {
		return URI.create(ruta);
	}

	public void setRuta(URI ruta) {
		this.ruta = ruta.toString();
	}

	@JsonSerialize(using = SerializadorFechaNorticA4.class)
	public Date getDeFecha() {
		return deFecha;
	}

	@JsonDeserialize(using = DeserializadorFechaNorticA4.class)
	public void setDeFecha(Date fechaArchivo) {
		this.deFecha = fechaArchivo;
	}

	@JsonSerialize(using = SerializadorFechaNorticA4.class)
	public Date getExpira() {
		return expira;
	}

	@JsonDeserialize(using = DeserializadorFechaNorticA4.class)
	public void setExpira(Date fechaExpiracion) {
		this.expira = fechaExpiracion;
	}
}
