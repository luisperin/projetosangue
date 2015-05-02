package service;

import java.io.Serializable;

import javax.inject.Inject;

import jpa.Transactional;
import modelo.TriagemClinicResp;
import dao.TriagemClinicRespDAO;

public class AvaliacaoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TriagemClinicRespDAO triagemClinicRespDAO;
	
	@Transactional
	public void salvar(TriagemClinicResp triagemClinicResp) throws NegocioException {
		
		if (triagemClinicResp.getTriagemCliQuest() == null) {
			throw new NegocioException(" obrigatório");
		}
		
		this.triagemClinicRespDAO.salvar(triagemClinicResp);
	}

}
