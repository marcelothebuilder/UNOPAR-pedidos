package io.github.marcelothebuilder.unoparpedidos4.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import io.github.marcelothebuilder.unoparpedidos4.dto.ClienteDTO;
import io.github.marcelothebuilder.unoparpedidos4.model.Cliente;
import io.github.marcelothebuilder.unoparpedidos4.model.Cidade;
import io.github.marcelothebuilder.unoparpedidos4.dto.CidadeDTO;

@Mapper(componentModel="spring", uses=CidadeMapper.class)
public interface ClienteMapper {
	
	@Mappings({
		@Mapping(target="bairro", source="endereco.bairro"),
		@Mapping(target="cidade", source="endereco.cidade")
	})
	ClienteDTO toDto(Cliente cliente);
	List<ClienteDTO> toDto(List<Cliente> cliente);
	
	@Mappings({
		@Mapping(target="endereco.bairro", source="bairro"),
		@Mapping(target="endereco.cidade", source="cidade")
	})
	Cliente fromDto(ClienteDTO dto);

	@Mapping(target = "estado", ignore = true)
	Cidade fromDto(CidadeDTO cidadeDTO);
}
