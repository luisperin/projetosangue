package repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import modelo.Usuario;

public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Usuario porId(Long id) {
		return this.manager.find(Usuario.class, id);
	}
	
	public List<Usuario> vendedores() {
		// TODO filtrar apenas vendedores (por um grupo específico)
		return this.manager.createQuery("from Usuario", Usuario.class)
				.getResultList();
	}

	public Usuario porEmail(String email) {
	Usuario usuario= null;
	try{
	usuario = this.manager.createQuery("from  Usuario where lowser(email) = :email",Usuario.class)
			.setParameter("email",email.toLowerCase()).getSingleResult();
	}catch(NoResultException e){
		//nada encontrado
	}
		return null;
	}
	
}