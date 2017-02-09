package dr.gob.hacienda.servicios.cliente;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;

import dr.gob.hacienda.servicios.modelo.Archivo;

public class ArchivoCliente {

	private Client cliente;
	
	public ArchivoCliente() {
		cliente = ClientBuilder.newClient();
	}
	
	public Archivo get(String id) {
		WebTarget origen = cliente.target("http://localhost:8080/archivo-servicios/webapi/");
		Response respuesta = origen.path("archivos/" + id).request(MediaType.APPLICATION_JSON).get(Response.class);
		
		if (respuesta.getStatus() != Status.OK.getStatusCode()) {
			throw new RuntimeException(respuesta.getStatus() + ": Hubo un error en el servidor");
		}
		
		return respuesta.readEntity(Archivo.class);
	}
	
	public List<Archivo> get() {
		WebTarget origen = cliente.target("http://localhost:8080/archivo-servicios/webapi/");
		List<Archivo> respuesta = origen.path("archivos").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Archivo>>() {});
		
		return respuesta;
	}

	public Archivo crear(Archivo archivo) {
		WebTarget origen = cliente.target("http://localhost:8080/archivo-servicios/webapi/");
		
		Response respuesta = origen.path("archivos/archivo")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(archivo, MediaType.APPLICATION_JSON));
		
		if (respuesta.getStatus() != Status.OK.getStatusCode()) {
			throw new RuntimeException(respuesta.getStatus() + ": Hubo un error en el servidor");
		}

		return respuesta.readEntity(Archivo.class);
	}

	public Archivo actualizar(Archivo archivo) {
		WebTarget origen = cliente.target("http://localhost:8080/archivo-servicios/webapi/");
		
		Response respuesta = origen.path("archivos/archivo")
				.request()
				.buildPut(Entity.json(new Gson().toJson(archivo)) )
				.invoke();
		
		if (respuesta.getStatus() != Status.OK.getStatusCode()) {
			throw new RuntimeException(respuesta.getStatus() + ": Hubo un error en el servidor");
		}

		return new Gson().fromJson(respuesta.readEntity(String.class), Archivo.class) ;
	}


	public void borrar(String archivoId) {
		WebTarget origen = cliente.target("http://localhost:8080/archivo-servicios/webapi/");
		
		Response respuesta = origen.path("archivos/" + archivoId)
				.request(MediaType.APPLICATION_JSON)
				.delete();
		
		if (respuesta.getStatus() != Status.OK.getStatusCode()) {
			throw new RuntimeException(respuesta.getStatus() + ": Hubo un error en el servidor");
		}
	}
}