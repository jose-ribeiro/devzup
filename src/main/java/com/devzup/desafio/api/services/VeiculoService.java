package com.devzup.desafio.api.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devzup.desafio.domain.entidades.Usuario;
import com.devzup.desafio.domain.entidades.Veiculo;
import com.devzup.desafio.domain.repositorio.VeiculoRepositorio;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepositorio veiculoRepositorio;
	@Autowired
	private UsuarioService usuarioService;
	
	public Veiculo salvar(Veiculo veiculo, Long idUsuario)  {
		Optional<Usuario> usuario = usuarioService.findById(idUsuario);
		Usuario usuarioid = usuario.get();
		veiculo.setUsuario(usuarioid);
		return veiculoRepositorio.save(veiculo);
	}
	
}
