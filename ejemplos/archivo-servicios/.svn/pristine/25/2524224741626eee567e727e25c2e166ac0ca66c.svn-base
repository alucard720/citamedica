package dr.gob.hacienda.servicios.repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import dr.gob.hacienda.servicios.modelo.Aplicacion;
import dr.gob.hacienda.servicios.utilitarios.AdministradorEntidadTransaccion;

@Transactional
@Stateless
public class AplicacionRepositorio {
	private @Inject AdministradorEntidadTransaccion ejb;

	public Aplicacion buscaAplicacion(int aplicacionId) {
		return ejb.getEntityManager().find(Aplicacion.class, aplicacionId);
	}
	
	public Aplicacion buscaAplicacion(String idAplicacionBlob) {
		return ejb.getEntityManager().find(Aplicacion.class, idAplicacionBlob);
	}

	public Aplicacion crearActualizar(Aplicacion Aplicacion) {					
		return ejb.getEntityManager().merge(Aplicacion);
	}

	public void borrar(String AplicacionId) {
		Aplicacion AplicacionABorrar = ejb.getEntityManager().find(Aplicacion.class, AplicacionId);
		if (AplicacionABorrar != null) {
			ejb.getEntityManager().remove(AplicacionABorrar);
		}
	}

	public List<Aplicacion> buscarPorNombres(List<String> nombres) {
		List<Aplicacion> Aplicacions = new ArrayList<Aplicacion>();
		
		String jpql = "SELECT A FROM dr.gob.hacienda.servicios.modelo.Aplicacion A WHERE A.nombre LIKE :parametro";
		
		Aplicacions = ejb.getEntityManager().createQuery(jpql, Aplicacion.class).getResultList();
		
		return Aplicacions;
	}	
}
