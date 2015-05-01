package service;


import java.io.Serializable;

import javax.inject.Inject;

import jpa.Transactional;
import modelo.Funcionario;
import dao.FuncionarioDAO;

public class FuncionarioService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private FuncionarioDAO funcionarioDA;
	
	@Transactional
	public void salvar(Funcionario funcionario) throws NegocioException {
		if (funcionario.getNome_funcionario() == null || funcionario.getNome_funcionario().trim().equals("")) { 
			throw new NegocioException("O nome do cadastroDoador é obrigatório");
		}
		
		this.funcionarioDA.salvar(funcionario);
	}
	
}
