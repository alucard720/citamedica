package dr.gob.hacienda.servicios.repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import dr.gob.hacienda.servicios.modelo.Archivo;
import dr.gob.hacienda.servicios.modelo.Periodo;
import dr.gob.hacienda.servicios.utilitarios.AdministradorEntidadTransaccion;

@Transactional
@Stateless
public class ArchivoRepositorio {

	@SuppressWarnings("cdi-ambiguous-dependency")
	private @Inject AdministradorEntidadTransaccion ejb;

	public Archivo buscaArchivo(int archivoId) {
		return ejb.getEntityManager().find(Archivo.class, archivoId);
	}

	public Archivo buscaArchivoBlob(String idArchivoBlob) {
		String jpql = "SELECT A FROM dr.gob.hacienda.servicios.modelo.Archivo A WHERE A.idArchivoBlob = :parametro";
		Archivo archivo = ejb.getEntityManager().createQuery(jpql, Archivo.class).getSingleResult();
		return archivo;

	}

	public Archivo crearActualizar(Archivo archivo) {
		return ejb.getEntityManager().merge(archivo);
	}

	public void borrar(String archivoId) {
		Archivo archivoABorrar = ejb.getEntityManager().find(Archivo.class, archivoId);
		if (archivoABorrar != null) {
			ejb.getEntityManager().remove(archivoABorrar);
		}
	}

	public List<Archivo> buscarObsoletosPorPeriodo(Periodo periodo) {
		List<Archivo> archivos = new ArrayList<Archivo>();
		
		switch (periodo) {
		case DIARIO:
			// Consultar contra la base de datos los archivos caducados contra la informacion de su origen
			// para que si no existe borrarlo definitivamente
			
			return null;
		case SEMANAL:
			
			return null;
		case QUINCENAL:
			
			return null;
		case MENSUAL:
			
			return null;
		case TRIMESTRAL:
			
			return null;
		case ANUAL:
			
			return null;
		default:
			return null;
		}
	}

	public List<Archivo> buscarPorNombres(List<String> nombres) {
		List<Archivo> archivos = new ArrayList<Archivo>();

		String jpql = "SELECT A FROM dr.gob.hacienda.servicios.modelo.Archivo A WHERE A.nombre LIKE :parametro";

		archivos = ejb.getEntityManager().createQuery(jpql, Archivo.class).getResultList();

		return archivos;
	}
}