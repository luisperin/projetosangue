package service;

import java.io.Serializable;

import javax.inject.Inject;

import jpa.Transactional;
import modelo.TriagemCliQuest;
import dao.TriagemCliQuestDAO;

public class TriagemClinicQuestService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TriagemCliQuestDAO triagemCliQuestDAO;
	
	@Transactional
	public void salvar(TriagemCliQuest triagemCliQuest) throws NegocioException {
		
		if (triagemCliQuest.getCodext() == null || triagemCliQuest.getCodext().trim().equals("")) {
			throw new NegocioException(" obrigatória");
		}
		
		this.triagemCliQuestDAO.salvar(triagemCliQuest);
	}

}
