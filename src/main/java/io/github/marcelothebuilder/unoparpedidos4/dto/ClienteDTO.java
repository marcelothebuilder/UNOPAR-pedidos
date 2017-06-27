package io.github.marcelothebuilder.unoparpedidos4.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class ClienteDTO {
	private Long codigo;

	@NotBlank
	private String nome;

	@NotBlank
	private String cpf;

	@NotBlank
	private String email;

	@NotNull
	private Date dataNascimento;

	@NotBlank
	private String bairro;

	@NotNull
	private CidadeDTO cidade;
}
