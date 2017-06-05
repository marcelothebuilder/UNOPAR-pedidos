package io.github.marcelothebuilder.unoparpedidos4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long codigo;

	@NotBlank
	private String nome;

	private String descricao;

	@NotNull
	private Integer peso;

	@NotNull
	private Integer estoque;
}
