package io.github.marcelothebuilder.unoparpedidos4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.marcelothebuilder.unoparpedidos4.dto.CidadeDTO;
import io.github.marcelothebuilder.unoparpedidos4.mappers.CidadeMapper;
import io.github.marcelothebuilder.unoparpedidos4.model.Cidade;
import io.github.marcelothebuilder.unoparpedidos4.model.Estado;
import io.github.marcelothebuilder.unoparpedidos4.repository.EstadoRepository;

@RestController
@RequestMapping("/cidade")
public class CidadeController {
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeMapper mapper;
	
	@GetMapping
	public List<CidadeDTO> porEstado(@RequestParam("estado") Long idEstado) {
		Estado estado = estadoRepository.findOne(idEstado);
		List<Cidade> cidades = estado.getCidades();
		return mapper.toDtos(cidades);
	}
}
