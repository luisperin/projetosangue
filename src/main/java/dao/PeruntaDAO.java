package dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import jpa.Transactional;
import service.NegocioException;
import modelo.NovaPergunta;

public class PeruntaDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public NovaPergunta buscarPeloCodigo(Long codigo) {
		return manager.find(NovaPergunta.class, codigo);
	}
	
	public void salvar(NovaPergunta cadastro) {
		manager.merge(cadastro);
	}

	@SuppressWarnings("unchecked")
	public List<NovaPergunta> buscarTodos() {
		return manager.createQuery("from NovaPergunta").getResultList();
	}
	
	@Transactional
	public void excluir(NovaPergunta cadastro) throws NegocioException {
		cadastro = buscarPeloCodigo(cadastro.getCodigo());
		try {
			manager.remove(cadastro);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Pergunta não pode ser excluído.");
		}
	}
}
