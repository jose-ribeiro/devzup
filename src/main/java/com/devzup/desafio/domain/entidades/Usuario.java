package com.devzup.desafio.domain.entidades;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Usuario  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usuarioId;
	
	@NotNull
	@NotBlank
	@Size(max= 60)
	private String nome;
	
	@NotBlank
	@NotNull
	@Email
	@Size(max= 40)
	@Column(unique = true)
	private String email;
	
	@NotBlank
	@NotNull
	@Size(max= 11)
	@Column(unique = true)
	private String cpf;
	
	@NotBlank
	@NotNull
	private String dataNascimento;
	
	@OneToMany(
			mappedBy="usuario",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private Set<Veiculo> veiculos;
	
	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Set<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(Set<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

}