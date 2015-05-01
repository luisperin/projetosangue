package dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import jpa.Transactional;
import service.NegocioException;
import modelo.PreTriagem;

public class PreTriagemDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager manager;
	
	public PreTriagem buscarPeloCodigo(Long codigo) {
		return manager.find(PreTriagem.class, codigo);
	}
	
	public void salvar(PreTriagem preTriagem) {
		manager.merge(preTriagem);
	}

	@SuppressWarnings("unchecked")
	public List<PreTriagem> buscarTodos() {
		return manager.createQuery("from PreTriagem").getResultList();
	}
	
	@Transactional
	public void excluir(PreTriagem preTriagem) throws NegocioException {
		preTriagem = buscarPeloCodigo(preTriagem.getCodigo());
		try {
			manager.remove(preTriagem);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Este modulo não pode ser excluído.");
		}
	}
	
}
