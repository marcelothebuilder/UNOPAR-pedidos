package io.github.marcelothebuilder.unoparpedidos4.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.marcelothebuilder.unoparpedidos4.dto.ProdutoDTO;
import io.github.marcelothebuilder.unoparpedidos4.mappers.ProdutoMapper;
import io.github.marcelothebuilder.unoparpedidos4.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;

	@Autowired
	private ProdutoMapper mapper;

	@PostMapping
	public void novo(@Valid @RequestBody ProdutoDTO dto) {
		repository.save(mapper.produtoDTOToProduto(dto));
	}

	@GetMapping
	public List<ProdutoDTO> todos() {
		return mapper.produtosToProdutoDTOs(repository.findAll());
	}

	@GetMapping(params = "nome")
	public Page<ProdutoDTO> pesquisar(@RequestParam(name = "nome", required = false) String nome, Pageable pagina) {
		if (StringUtils.isEmpty(nome)) {
			return repository.findAll(pagina).map(mapper::produtoToProdutoDTO);
		}
		return repository.findByNomeContainingIgnoreCase(nome, pagina).map(mapper::produtoToProdutoDTO);
	}
}
