package dao;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import modelo.Estado;


public class EstadoDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Estado buscarPeloCodigo(Integer codigo) {
		return manager.find(Estado.class, codigo);
	}
	
	public List<Estado> buscarEstados() {
		return manager.createNamedQuery("Estado.buscarEstados", Estado.class).getResultList();
	}
	
}
