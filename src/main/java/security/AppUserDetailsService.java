package security;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import modelo.Grupo;
import modelo.Usuario;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cdi.CDIServiceLocator;
import repository.Usuarios;


public class AppUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuarios usuarios = CDIServiceLocator.getBean(Usuarios.class);
		
		Usuario usuario = usuarios.porEmail(email);
		
		UsuarioSistema user = null;//usuario sistema,pai
			//usuario não for nulo
		if (usuario != null) {
			user = new UsuarioSistema(usuario, getGrupos(usuario));
		}
		
		return user;//me retorna		
	}

	private Collection<? extends GrantedAuthority> getGrupos(Usuario usuario) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		for (Grupo grupo : usuario.getGrupos()) {//percorre
			authorities.add(new SimpleGrantedAuthority(grupo.getNome().toUpperCase()));//permissão em maiuscula
		}
		
		return authorities;
	}

}
