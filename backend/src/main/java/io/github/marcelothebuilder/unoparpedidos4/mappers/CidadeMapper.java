package io.github.marcelothebuilder.unoparpedidos4.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import io.github.marcelothebuilder.unoparpedidos4.dto.CidadeDTO;
import io.github.marcelothebuilder.unoparpedidos4.model.Cidade;

@Mapper(componentModel="spring")
public interface CidadeMapper {
	
	@Mappings({
		@Mapping(source="estado.nome", target="estado")
	})
	CidadeDTO toDto(Cidade cidade);
	List<CidadeDTO> toDtos(List<Cidade> cidade);
}
