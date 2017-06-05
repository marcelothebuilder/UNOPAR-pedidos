package io.github.marcelothebuilder.unoparpedidos4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Cidade {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long codigo;
	
	@NotNull
	private String nome;
	
	@ManyToOne
	@NotNull
	private Estado estado;

	@Override
	public String toString() {
		return "Cidade [codigo=" + codigo + ", nome=" + nome + "]";
	}
	
	
}
