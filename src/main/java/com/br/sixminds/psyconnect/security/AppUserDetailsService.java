/**
 * @author andrei
 *
 * 5 de dez de 2018
 */
package com.br.sixminds.psyconnect.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.br.sixminds.psyconnect.model.Grupo;
import com.br.sixminds.psyconnect.model.Usuario;
import com.br.sixminds.psyconnect.repository.Usuarios;
import com.br.sixminds.psyconnect.util.cdi.CDIServiceLocator;

/**
 * @author andrei
 *
 */
public class AppUserDetailsService implements UserDetailsService {


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuarios usuarios = CDIServiceLocator.getBean(Usuarios.class);
		Usuario usuario = usuarios.porEmail(email);
		
		UsuarioSistema user = null;
		
		if (usuario != null) {
			user = new UsuarioSistema(usuario, getGrupos(usuario));
			
		}
		
		
		return user;
	}
	
	private Collection<? extends GrantedAuthority> getGrupos(Usuario usuario) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		for (Grupo grupo : usuario.getGrupos()) {
			authorities.add(new SimpleGrantedAuthority(grupo.getNome().toUpperCase()));
		}
		
		return authorities;
	}
	

}
