package service;

import java.io.Serializable;

import javax.inject.Inject;

import jpa.Transactional;
import modelo.Cadastro;
import dao.CadastroDAO;

public class CadastroService implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private CadastroDAO cadastroDAO;
	
	@Transactional
	public void salvar(Cadastro cadastro) throws NegocioException {
		
		
		this.cadastroDAO.salvar(cadastro);
	}
	
}
