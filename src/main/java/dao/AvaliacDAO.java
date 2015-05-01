package dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import modelo.Aptidao;

public class AvaliacDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public void salvar(Aptidao aptidao) {
		manager.persist(aptidao);
	}

}
