package io.github.marcelothebuilder.unoparpedidos4.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import io.github.marcelothebuilder.unoparpedidos4.dto.PedidoDTO;
import io.github.marcelothebuilder.unoparpedidos4.model.Pedido;

@Mapper(componentModel = "spring", uses = { ItemPedidoMapper.class, ClienteMapper.class })
public interface PedidoMapper {
	Pedido pedidoDTOToPedido(PedidoDTO dto);

	List<Pedido> pedidoDTOsToPedidos(List<PedidoDTO> dto);

	PedidoDTO pedidoToPedidoDTO(Pedido dto);

	List<PedidoDTO> pedidosToPedidoDTOs(List<Pedido> dto);
}
