package com.devzup.desafio.domain.entidades;

import java.time.DayOfWeek;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String marca;
	
	@NotNull
	private String modeloVeiculo;
	
	@NotNull
	private Integer ano;
	
	@JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;
	
	private String rodizioVeiculo;
	
	private Boolean rodizioAtivo = false;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModeloVeiculo() {
		return modeloVeiculo;
	}
	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getRodizioVeiculo() {
			switch(ultimoDigito()) {
			case 0 :
			case 1:
				this.setRodizioVeiculo("Segunda feira");
				break;
			case 2:
			case 3:
				this.setRodizioVeiculo("Terça feira");
				break;
			case 4:
			case 5:
				this.setRodizioVeiculo("Quarta feira");;
				break;
			case 6:
				case 7:
					this.setRodizioVeiculo("Quinta feira");
				break;
			case 8:
				case 9:
					this.setRodizioVeiculo("Sexta feira");
				break;
	
			}
		
		return rodizioVeiculo;
	}
	public void setRodizioVeiculo(String rodizioVeiculo) {
		this.rodizioVeiculo = rodizioVeiculo;
	}
	
	public Boolean getRodizioAtivo() {
		validaRodizioAtivo();
		return rodizioAtivo;
	}
	
	public void setRodizioAtivo(Boolean rodizioAtivo) {
		this.rodizioAtivo = rodizioAtivo;
	}
	
	
	public void validaRodizioAtivo()  {
		DayOfWeek diadehoje = LocalDate.now().getDayOfWeek();
		int ultimoDigitoAno = ultimoDigito();

		switch(ultimoDigitoAno) {
			case 0:
			case 1:
				this.setRodizioAtivo((diadehoje == DayOfWeek.MONDAY) && (ultimoDigitoAno == 0 || ultimoDigitoAno == 1 ));
				break;
			case 2:
			case 3:
				this.setRodizioAtivo((diadehoje == DayOfWeek.TUESDAY) && (ultimoDigitoAno == 2 || ultimoDigitoAno == 3 ));
				break;
			case 4:
			case 5:
				this.setRodizioAtivo((diadehoje == DayOfWeek.SATURDAY) && (ultimoDigitoAno == 5 || ultimoDigitoAno == 5 ));
				break;
			case 6:
			case 7:
				this.setRodizioAtivo((diadehoje == DayOfWeek.THURSDAY) && (ultimoDigitoAno == 6 || ultimoDigitoAno == 7 ));
				break;
			case 8:
			case 9:
				this.setRodizioAtivo((diadehoje == DayOfWeek.TUESDAY) && (ultimoDigitoAno == 8 || ultimoDigitoAno == 9 ));
				break;

		}
	}
	
	private int ultimoDigito() {
		return this.getAno() % 10;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
