package com.vendamais.api.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vendamais.domain.exception.NegocioException;
import com.vendamais.domain.model.Usuario;
import com.vendamais.domain.repository.UsuarioRepository;

@Service
public class ApiUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByLogin(login)
				.orElseThrow(() -> new NegocioException("Usuario e/ou senha invalido!"));
		return new User(login, usuario.getSenha(), getPermissoes(usuario));
	}

	private Collection<? extends GrantedAuthority> getPermissoes(Usuario usuario) {
		Set<SimpleGrantedAuthority> permissoes = new HashSet<>();
		// TODO recuperar permissoes do usuario
		permissoes.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return permissoes;
	}

}
