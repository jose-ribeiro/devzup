package com.devzup.desafio.api.services;

import java.util.List;
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
	
	public List <Veiculo> listarVeiculo (){
		return veiculoRepositorio.findAll();
	}
	public Veiculo salvar(Veiculo veiculo)  {
		Optional<Usuario> usuario = usuarioService.findById(veiculo.getUsuario().getUsuarioId());
		Usuario usuarioObtido = usuario.get();
		veiculo.setUsuario(usuarioObtido);
		return veiculoRepositorio.save(veiculo);
	}
	
}
