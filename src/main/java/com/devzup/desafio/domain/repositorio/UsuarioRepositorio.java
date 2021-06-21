package com.devzup.desafio.domain.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devzup.desafio.domain.entidades.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	
	List<Usuario> findByNome (String nome);
	Optional<Usuario> findByCpf(String cpf);

}
