package io.github.marcelothebuilder.unoparpedidos4.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class CidadeDTO {
	@NotNull
	private Long codigo;

	@NotBlank
	private String nome;

	private String estado;
}
