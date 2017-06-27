package io.github.marcelothebuilder.unoparpedidos4.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class PedidoDTO {
	private Long codigo;
	private Date data = new Date();
	private List<ItemPedidoDTO> itens;
	private ClienteDTO cliente;
	private Integer quantidadeItens;
}
