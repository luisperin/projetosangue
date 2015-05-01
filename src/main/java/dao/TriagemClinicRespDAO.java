package dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import modelo.TriagemClinicResp;

public class TriagemClinicRespDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public void salvar(TriagemClinicResp triagemClinicResp) {
		manager.merge(triagemClinicResp);
	}

}
