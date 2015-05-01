package dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import modelo.Cidade;
import modelo.Estado;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


public class CidadeDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Cidade buscarPeloCodigo(Integer codigo) {
		return manager.find(Cidade.class, codigo);
	}
	
	public List<Cidade> buscarCidades(Estado estado){
		Session session = this.manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Cidade.class);
		
		if(estado != null){
			criteria.add(Restrictions.eq("estado", estado));
		}
		
		return criteria.list();
	}
	
}