package io.github.marcelothebuilder.unoparpedidos4.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import io.github.marcelothebuilder.unoparpedidos4.dto.EstadoDTO;
import io.github.marcelothebuilder.unoparpedidos4.model.Estado;

@Mapper(componentModel = "spring")
public interface EstadoMapper {
	EstadoDTO estadoToEstadoDTO(Estado estado);

	List<EstadoDTO> estadosToEstadoDTOs(List<Estado> estados);

	@Mapping(target = "cidades", ignore = true)
	Estado estadoDTOToEstado(EstadoDTO estado);

	List<Estado> estadosDTOsToEstados(List<EstadoDTO> estados);
}
