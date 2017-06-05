package io.github.marcelothebuilder.unoparpedidos4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstadoEntrega {
	// @formatter:off
	NAO_INICIADA("Não iniciada"),
	EM_SEPARACAO("Em separação"),
	NA_TRANSPORTADORA("Na transportadora"),
	EM_TRANSITO("Em trânsito"),
	EM_ROTA_DE_ENTREGA("Em rota de entrega"),
	ENTREGUE("Entregue"),
	CANCELADA("Cancelada"); 
	// @formatter:on
	
	private String descricao;
}
