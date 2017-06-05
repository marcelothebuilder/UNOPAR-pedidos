package io.github.marcelothebuilder.unoparpedidos4.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import io.github.marcelothebuilder.unoparpedidos4.dto.ProdutoDTO;
import io.github.marcelothebuilder.unoparpedidos4.model.Produto;

@Mapper(componentModel="spring")
public interface ProdutoMapper {
	ProdutoDTO produtoToProdutoDTO(Produto produto);
	List<ProdutoDTO> produtosToProdutoDTOs(List<Produto> produto);
	Produto produtoDTOToProduto(ProdutoDTO dto);
}
