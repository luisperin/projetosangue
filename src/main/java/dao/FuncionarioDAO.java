package dao;


import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import jpa.Transactional;
import service.NegocioException;
import modelo.Funcionario;

public class FuncionarioDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager em;
	
	public void salvar(Funcionario funcionario) {
		em.merge(funcionario);
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> buscarTodos() {
		return em.createQuery("from Funcionario").getResultList();
	}

	@Transactional
	public void excluir(Funcionario funcionario) throws NegocioException {
		Funcionario funcionarioTemp = em.find(Funcionario.class, funcionario.getCodigo());
		
		em.remove(funcionarioTemp);
		em.flush();
	}

	public Funcionario buscarPeloCodigo(Long codigo) {
		return em.find(Funcionario.class, codigo);
	}
	
}
