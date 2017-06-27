package io.github.marcelothebuilder.unoparpedidos4.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PassoEntregaDTO {
	private Long codigo;
	private Long pedidoCodigo;
	private Date data = new Date();
	private String descricao;
	private EstadoEntregaDTO estado;
}
