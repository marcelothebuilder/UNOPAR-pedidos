package io.github.marcelothebuilder.unoparpedidos4.mappers;

import org.mapstruct.Mapper;

import io.github.marcelothebuilder.unoparpedidos4.dto.ItemPedidoDTO;
import io.github.marcelothebuilder.unoparpedidos4.model.ItemPedido;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring", uses=ProdutoMapper.class)
public interface ItemPedidoMapper {
	@Mapping(target = "pedido", ignore = true)
	ItemPedido itemPedidoDTOToItemPedido(ItemPedidoDTO dto);
	
	ItemPedidoDTO itemPedidoToItemPedidoDTO(ItemPedido model);
}
