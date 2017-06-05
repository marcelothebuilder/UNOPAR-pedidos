package io.github.marcelothebuilder.unoparpedidos4.service;

import javax.persistence.PrePersist;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import io.github.marcelothebuilder.unoparpedidos4.model.Pedido;

@Service
@Transactional
public class PedidoService {	
	
	@PrePersist
	public void onNovoPedido(Pedido pedido) {
		// diminuir estoque
	}
}
