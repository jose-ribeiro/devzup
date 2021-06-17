package com.devzup.desafio.api.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devzup.desafio.domain.entidades.Usuario;
import com.devzup.desafio.domain.repositorio.UsuarioRepositorio;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	public Usuario salvar(Usuario usuario) {
		return usuarioRepositorio.save(usuario);
	}
	public Optional<Usuario> findById(Long id) {
		return usuarioRepositorio.findById(id);
	}
	
}


