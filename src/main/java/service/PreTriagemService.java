package service;

import java.io.Serializable;

import javax.inject.Inject;

import jpa.Transactional;
import modelo.PreTriagem;
import dao.PreTriagemDAO;

public class PreTriagemService implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	PreTriagemDAO preTriagemDAO;

	@Transactional
	public void salvar(PreTriagem preTriagem) throws NegocioException {
/*		if (preTriagem.getDescricao() == null || preTriagem.getDescricao().trim().equals("")) {
			throw new NegocioException("Campo obrigatório.");
		}
*/		
		if (preTriagem.getCadastro() == null) {
			throw new NegocioException("O cadastro Doador e obrigatório");
		}
		
		this.preTriagemDAO.salvar(preTriagem);
	}

	
}
