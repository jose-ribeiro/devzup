package com.devzup.desafio.domain.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devzup.desafio.domain.entidades.Veiculo;

@Repository
public interface VeioculoRepositorio extends JpaRepository<Veiculo, Long> {

}
