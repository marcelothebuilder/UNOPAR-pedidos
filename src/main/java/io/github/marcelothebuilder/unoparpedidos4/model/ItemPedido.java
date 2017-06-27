package io.github.marcelothebuilder.unoparpedidos4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class ItemPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long codigo;
	
	@NotNull
	private Integer quantidade;

	@OneToOne
	@NotNull
	private Produto produto;	
	
	@ManyToOne
	@JoinColumn
	@NotNull
	private Pedido pedido;
}
