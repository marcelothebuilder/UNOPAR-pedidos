package io.github.marcelothebuilder.unoparpedidos4.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long codigo;

	@NotBlank
	private String nome;

	@NotBlank
	private String uf;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
	private List<Cidade> cidades = new ArrayList<>();
}
