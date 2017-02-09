package dr.gob.hacienda.servicios.procesos;

import javax.inject.Inject;

import dr.gob.hacienda.servicios.repositorio.ArchivoRepositorio;

public abstract class LimpiadorObsoletos {
	
	private @Inject ArchivoRepositorio archivoRepositorio;
	
	public LimpiadorObsoletos() {
		
	}
	
}
