package io.github.marcelothebuilder.unoparpedidos4.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class PassoEntrega {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long codigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	private String descricao;

	@Enumerated(EnumType.STRING)
	private EstadoEntrega estado;
	
	@ManyToOne(optional=false)
	@JoinColumn
	private Pedido pedido;
}
