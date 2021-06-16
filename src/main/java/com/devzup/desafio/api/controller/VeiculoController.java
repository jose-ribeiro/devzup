package com.devzup.desafio.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devzup.desafio.api.services.VeiculoService;
import com.devzup.desafio.domain.entidades.Veiculo;
import com.devzup.desafio.domain.repositorio.VeiculoRepositorio;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
	
	@Autowired
	public VeiculoRepositorio veiculoRepositorio;
	
	@Autowired
	public VeiculoService cadastroVeiculo;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Veiculo> listar(){
		return veiculoRepositorio.findAll();
	}
	
	//cadastro de veiculo
	/*@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo adicionar (@Valid @RequestBody Veiculo veiculo) {
		return cadastroVeiculo.salvar(veiculo);
		
	}*/
	@PostMapping("/usuarioId/{idUsuario}")
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo adicionar(@PathVariable Long idUsuario, @Valid @RequestBody Veiculo veiculo) throws Exception {
		return cadastroVeiculo.salvar(veiculo, idUsuario);
	}
	
	
	

}
