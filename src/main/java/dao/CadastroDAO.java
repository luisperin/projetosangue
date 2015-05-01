package dao;


import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import jpa.Transactional;
import service.NegocioException;
import modelo.Cadastro;

public class CadastroDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager em;
	
	public void salvar(Cadastro cadastro) {
		em.merge(cadastro);
	}

	@SuppressWarnings("unchecked")
	public List<Cadastro> buscarTodos() {
		return em.createQuery("from Cadastro").getResultList();
	}

	@Transactional
	public void excluir(Cadastro cadastro) throws NegocioException {
		Cadastro cadastroTemp = em.find(Cadastro.class, cadastro.getCodigo());
		
		em.remove(cadastroTemp);
		em.flush();
	}

	public Cadastro buscarPeloCodigo(Long codigo) {
		return em.find(Cadastro.class, codigo);
	}
	
}
