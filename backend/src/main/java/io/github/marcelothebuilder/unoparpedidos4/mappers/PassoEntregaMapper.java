package io.github.marcelothebuilder.unoparpedidos4.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import io.github.marcelothebuilder.unoparpedidos4.dto.PassoEntregaDTO;
import io.github.marcelothebuilder.unoparpedidos4.model.PassoEntrega;
import io.github.marcelothebuilder.unoparpedidos4.model.Pedido;
import io.github.marcelothebuilder.unoparpedidos4.repository.PedidoRepository;

@Mapper(componentModel="spring", uses=EstadoEntregaMapper.class)
public abstract class PassoEntregaMapper {
	
	@Autowired
	private PedidoRepository repository;
	
	@Mapping(source="pedido.codigo", target="pedidoCodigo")
	public abstract
	PassoEntregaDTO toDto(PassoEntrega model);
	
	@Mapping(source="pedidoCodigo", target="pedido")
	public abstract PassoEntrega fromDto(PassoEntregaDTO dto);
	public abstract List<PassoEntregaDTO> toDtos(List<PassoEntrega> model);
	public abstract List<PassoEntrega> fromDtos(List<PassoEntregaDTO> dto);
	
	Pedido toPedido(Long codigo) {
		return repository.findOne(codigo);
	}
}
