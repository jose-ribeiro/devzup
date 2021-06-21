package com.devzup.desafio.api.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.devzup.desafio.api.services.UsuarioService;
import com.devzup.desafio.domain.entidades.Usuario;



@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	public UsuarioService usuarioService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> listar(){
		return usuarioService.listar();

	}
	
	@GetMapping("/cpf")
	@ResponseStatus(HttpStatus.OK)
	public List <Usuario> listarNome(){
		return usuarioService.listarCpf();
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario adicionar (@Valid @RequestBody Usuario usuario) {
		return usuarioService.salvar(usuario);
	}
	
	
}
