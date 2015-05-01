package service;

import java.io.Serializable;

import javax.inject.Inject;

import jpa.Transactional;
import modelo.NovaPergunta;
import dao.PeruntaDAO;

public class PerguntaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PeruntaDAO peruntaDAO;
	
	@Transactional
	public void salvar(NovaPergunta novaPergunta) throws NegocioException {
		
		if (novaPergunta.getDescricao() == null || novaPergunta.getDescricao().trim().equals("")) {
			throw new NegocioException("Campo obrigatorio");
		}
		
		this.peruntaDAO.salvar(novaPergunta);
	}

}
