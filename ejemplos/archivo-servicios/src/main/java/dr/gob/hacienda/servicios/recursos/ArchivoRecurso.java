package dr.gob.hacienda.servicios.recursos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import dr.gob.hacienda.servicios.modelo.Aplicacion;
import dr.gob.hacienda.servicios.modelo.Archivo;
import dr.gob.hacienda.servicios.modelo.TipoArchivo;
import dr.gob.hacienda.servicios.repositorio.AplicacionRepositorio;
import dr.gob.hacienda.servicios.repositorio.ArchivoRepositorio;

@Path("archivos")
public class ArchivoRecurso {

	private @Inject ArchivoRepositorio archivoRepositorio;
	private @Inject AplicacionRepositorio aplicacionRepositorio;

	// *************************************************
	// Metodos DELETE
	// *************************************************

	@DELETE
	@Path("{archivoId}")
	public Response borrarArchivo(@PathParam("archivoId") String archivoId) {
		archivoRepositorio.borrar(archivoId);
		return Response.ok().build();
	}

	// *************************************************
	// Metodos GET
	// *************************************************

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("{archivoId}")
	public Archivo getArchivo(@PathParam("archivoId") String archivoId) {
		return archivoRepositorio.buscaArchivo(Integer.valueOf(archivoId));
	}

	@GET
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/blob/{idArchivoBlob}")
	public Response getArchivoCodOrigen(@PathParam("idArchivoBlob") String idArchivoBlob) {

		Archivo archivo = archivoRepositorio.buscaArchivoBlob(idArchivoBlob);

		if (archivo != null) {
			StringBuilder sb = new StringBuilder().append(new File(archivo.getAplicacion().getRuta()))
					.append(archivo.getNombre());

			return Response.ok(archivo, MediaType.APPLICATION_OCTET_STREAM)
					.header("Content-Type:application/json Content-Disposition",
							"attachment; filename=\"" + sb.toString() + "\"")
					.build();
		} else {
			Response.status(Status.NOT_FOUND).build();
		}

		return null;
	}

	// *************************************************
	// Metodos POST
	// *************************************************

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response crearArchivo(Archivo archivo) {

		return Response.ok().entity(archivoRepositorio.crearActualizar(archivo)).build();
	}

	@POST
	@Path("archivo")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({ MediaType.APPLICATION_JSON })
	public Archivo creaParametrosArchivo(MultivaluedMap<String, String> parametrosFormulario) {

		Archivo archivo = new Archivo();
		archivo.setNombre(parametrosFormulario.getFirst("nombre"));
		archivo.setDescripcion(parametrosFormulario.getFirst("descripcion"));
		archivo.setRuta(URI.create(parametrosFormulario.getFirst("aplicacion")));

		String target = parametrosFormulario.getFirst("fechaArchivo");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);
		try {
			archivo.setDeFecha(df.parse(target));
		} catch (ParseException e) {
			throw new IllegalArgumentException();
		}

		archivo.setTipo(TipoArchivo.valueOf(TipoArchivo.class, parametrosFormulario.getFirst("tipoArchivo")));

		return archivoRepositorio.crearActualizar(archivo);
	}

	@POST
	@Path("/subir")
	@Consumes({ MediaType.MULTIPART_FORM_DATA })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response uploadFile(@Context final HttpServletRequest request, MultipartFormDataInput input) {

		// Datos del Header - Info del archivo y la aplicacion
		Archivo archivo = new Archivo();
		archivo.setCodHashUnico(request.getHeader("codHashUnico"));

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		try {
			java.sql.Date fecha = new java.sql.Date(df.parse(request.getHeader("deFecha")).getTime());
			archivo.setDeFecha(fecha);
		} catch (final ParseException ex) {
			throw new WebApplicationException(ex);
		}

		archivo.setDescripcion(request.getHeader("descripcion"));
		archivo.setTipo(TipoArchivo.valueOf(request.getHeader("tipo")));
		archivo.setNombre(request.getHeader("nombre"));

		// Si el id aplicacion existe le pasamos la instancia al objeto archivo
		String aplicacionId = request.getHeader("aplicacionId");
		Aplicacion app = aplicacionRepositorio.buscaAplicacion(Integer.valueOf(aplicacionId));
		if (app != null) {
			archivo.setAplicacion(app);
		} else {
			return Response.status(null).build();
		}
		
		// Iniciando la carga del archivo
		String fileName = descomponer(input, app.getRuta());
		
		archivo.setRuta(URI.create(fileName));
		
		//Actualizando base de datos
		archivoRepositorio.crearActualizar(archivo);
				
		return Response.status(200)
				.entity("Fue requerida la SUBIDA de archivo(s), el archivo cargado fue : " + fileName).build();

	}

	// *************************************************
	// Metodos Privados
	// *************************************************

	private String descomponer(MultipartFormDataInput input, String rutaDestino) {
		String fileName = "";

		Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
		List<InputPart> inputParts = uploadForm.get("filename");

		for (InputPart inputPart : inputParts) {

			try {

				MultivaluedMap<String, String> header = inputPart.getHeaders();
				fileName = getNombreArchivo(header);

				new File(rutaDestino + getPeriodo() + "/" + getNumeroMes() + "/").mkdirs();
				fileName = rutaDestino + getPeriodo() + "/" + getNumeroMes() + "/" + fileName;

				BufferedInputStream bis = new BufferedInputStream(inputPart.getBody(InputStream.class, null));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName));

				byte[] arr = new byte[8192];
				int disponible = -1;

				while ((disponible = bis.read(arr)) > 0) {
					bos.write(arr, 0, disponible);
				}
				bos.flush();
				bos.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fileName;
	}

	private String getNombreArchivo(MultivaluedMap<String, String> header) {
		String[] contentDisposition = header.getFirst("Content-Disposition").split(";");
		for (String contenido : contentDisposition) {
			if ((contenido.trim().startsWith("filename"))) {
				String[] name = contenido.split("=");
				String finalFileName = name[1].trim().replaceAll("\"", "");
				return finalFileName;
			}
		}
		return "desconocido";
	}

	private String getNumeroMes() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return String.valueOf(cal.get(Calendar.MONTH) + 1);
	}

	private String getPeriodo() {
		return String.valueOf(LocalDate.now().getYear());
	}
}