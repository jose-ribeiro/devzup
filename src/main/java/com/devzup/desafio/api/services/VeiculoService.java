package com.devzup.desafio.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devzup.desafio.domain.entidades.Veiculo;
import com.devzup.desafio.domain.repositorio.VeiculoRepositorio;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepositorio veiculoRepositorio;
	
	public Veiculo salvar(Veiculo veiculo) {
		return veiculoRepositorio.save(veiculo);
	}
	
	
}
