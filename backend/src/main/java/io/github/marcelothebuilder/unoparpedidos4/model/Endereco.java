package io.github.marcelothebuilder.unoparpedidos4.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Embeddable
@Data
public class Endereco {
	
	@NotBlank
	private String bairro;

	@NotNull
	@ManyToOne
	private Cidade cidade;
}
