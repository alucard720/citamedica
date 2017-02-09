package dr.gob.hacienda.servicios.repositorio;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import dr.gob.hacienda.servicios.modelo.Archivo;

public class ArchivoRepositorioMoc {

	/* (non-Javadoc)
	 * @see dr.gob.hacienda.servicios.repositorio.RepositorioArchivo#buscaTodosLosArchivos()
	 */
	public List<Archivo> buscaTodosLosArchivos() {
		List<Archivo> archivos = new ArrayList<Archivo>();

		// ARCHIVO 1
		Archivo archivo1 = new Archivo();
		
		archivo1.setNombre("Archivo1.pdf");
		archivo1.setRuta(URI.create("file:///home/alexandermatos//temp//Archivo1.pdf"));
		//archivo1.setDeFecha(new Date());
		archivo1.setDescripcion("Archivo 1 - para prueba de MOC");
		
		archivos.add(archivo1);

		
		// ARCHIVO 2
		Archivo archivo2 = new Archivo();
		
		archivo2.setNombre("Archivo2.pdf");
		archivo2.setRuta(URI.create("file:///home/alexandermatos//temp//Archivo2.pdf"));
		//archivo2.setDeFecha(new Date());
		archivo2.setDescripcion("Archivo 2 - para prueba de MOC");
		
		archivos.add(archivo2);
		
		return archivos;
	}

	public Archivo buscaArchivo(String archivoId) {
		//Provocando un retorno null a proposito para prueba de falla
		if (archivoId.equals("777")) {
			return null;
		}
				
		Archivo archivo1 = new Archivo();
		
		archivo1.setArchivoId(1234);
		archivo1.setNombre("Archivo1.pdf");
		archivo1.setRuta(URI.create("file:///home/alexandermatos//temp//Archivo1.pdf"));
		//archivo1.setDeFecha(new Date());
		archivo1.setDescripcion("Archivo 1 - para prueba de MOC");
		
		return archivo1;
	}


	public void crear(Archivo archivo) {
		// TODO Insertar archivo a la base de datos
	}

	public Archivo actualizar(Archivo archivo) {
		// TODO Insertar o Actualizar el archivo en la base de datos
		return archivo;
	}

	public void borrar(String archivoId) {
		// TODO Borrado del archivo especificado
	}

	public List<Archivo> buscarPorNombres(List<String> descripciones) {
		// TODO Retornar una lista de archivos con todos los archivos que coincidan con las descripciones suministradas
		
		List<Archivo> archivos = new ArrayList<Archivo>();
		
		Archivo archivo1 = new Archivo();
		
		archivo1.setArchivoId(1234);
		archivo1.setNombre("Archivo1.pdf");
		archivo1.setRuta(URI.create("file:///home/alexandermatos//temp//Archivo1.pdf"));
		//archivo1.setDeFecha(new Date());
		archivo1.setDescripcion("Archivo 1 - para prueba de MOC");
		
		archivos.add(archivo1);
		
		return archivos;
	}
}
