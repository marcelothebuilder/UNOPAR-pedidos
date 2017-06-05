package io.github.marcelothebuilder.unoparpedidos4.dto;

import lombok.Data;

@Data
public class ItemPedidoDTO {
	private Long codigo;
	private Integer quantidade;
	private ProdutoDTO produto;	
}
