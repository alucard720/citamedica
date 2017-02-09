package dr.gob.hacienda.servicios.cliente;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import dr.gob.hacienda.servicios.modelo.Archivo;

public class ArchivoClienteTest {

	@Test
	@Ignore
	public void testArchivoBorrar() {
		ArchivoCliente cliente = new ArchivoCliente();
		cliente.borrar("1234");
	}

	@Test
	@Ignore
	public void testArchivoPut() {
		ArchivoCliente cliente = new ArchivoCliente();

		Archivo archivo = new Archivo();
		
		archivo.setArchivoId(3456);
		archivo.setNombre("Archivo3456.pdf");
		archivo.setDescripcion("Archivo creado desde unidad de prueba usando PUT");
		archivo = cliente.actualizar(archivo);

		assertNotNull(archivo);
	}

	@Test
	@Ignore
	public void testCreateArchivo() {
		ArchivoCliente cliente = new ArchivoCliente();

		Archivo archivo = new Archivo();
		archivo.setNombre("Archivo99.pdf");
		archivo.setDescripcion("Archivo creado desde unidad de prueba");
		archivo = cliente.crear(archivo);

		assertNotNull(archivo);
	}

	@Test
	@Ignore
	public void testGetArchivo() {
		ArchivoCliente cliente = new ArchivoCliente();
		Archivo archivo = cliente.get("1234");
		assertNotNull(archivo);
	}

	@Test
	@Ignore
	public void testGetListaArchivos() {
		ArchivoCliente cliente = new ArchivoCliente();
		List<Archivo> archivos = cliente.get();
		assertNotNull(archivos);
	}

	@Test(expected = RuntimeException.class)
	@Ignore
	public void testGetNoExiste() {
		ArchivoCliente cliente = new ArchivoCliente();
		cliente.get("777");
	}
}