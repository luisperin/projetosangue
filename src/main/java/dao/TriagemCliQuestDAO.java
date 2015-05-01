package dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import jpa.Transactional;
import service.NegocioException;
import modelo.TriagemCliQuest;

public class TriagemCliQuestDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public TriagemCliQuest buscarPeloCodigo(Long codigo) {
		return manager.find(TriagemCliQuest.class, codigo);
	}
	//Alterado:fabricante
	public void salvar(TriagemCliQuest cadastro) {
		manager.merge(cadastro);
	}

	@SuppressWarnings("unchecked")
	public List<TriagemCliQuest> buscarTodos() {
		return manager.createQuery("from TriagemCliQuest").getResultList();
	}
	
	@Transactional
	public void excluir(TriagemCliQuest triagemCliQuest) throws NegocioException {
		triagemCliQuest = buscarPeloCodigo(triagemCliQuest.getCodigo());
		try {
			manager.remove(triagemCliQuest);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("TriagemCliQuest não pode ser excluído.");
		}
	}

	public TriagemCliQuest buscarTriagemComPergunta(Long codigo) {
		return (TriagemCliQuest) manager.createQuery("select c from TriagemCliQuest c JOIN c.novaPergunta a where c.codigo = ?")
				.setParameter(1, codigo)
				.getSingleResult();
	}
	
}
