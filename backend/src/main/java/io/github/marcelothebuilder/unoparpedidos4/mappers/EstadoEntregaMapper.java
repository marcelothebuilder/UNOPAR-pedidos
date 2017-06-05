package io.github.marcelothebuilder.unoparpedidos4.mappers;

import java.util.Arrays;
import java.util.List;

import org.mapstruct.Mapper;

import io.github.marcelothebuilder.unoparpedidos4.dto.EstadoEntregaDTO;
import io.github.marcelothebuilder.unoparpedidos4.model.EstadoEntrega;

@Mapper(componentModel = "spring")
public abstract class EstadoEntregaMapper {
	public EstadoEntregaDTO toDto(EstadoEntrega model) {
		EstadoEntregaDTO dto = new EstadoEntregaDTO();
		dto.setDescricao(model.getDescricao());
		dto.setIdentificador(model.name());
		return dto;
	}
	
	public EstadoEntrega fromDto(EstadoEntregaDTO dto) {
		return EstadoEntrega.valueOf(dto.getIdentificador());
	}

	public abstract List<EstadoEntregaDTO> toDtos(List<EstadoEntrega> estados);

	public List<EstadoEntregaDTO> toDtos(EstadoEntrega[] estados) {
		return toDtos(Arrays.asList(estados));
	}
}
