package io.github.marcelothebuilder.unoparpedidos4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.marcelothebuilder.unoparpedidos4.dto.EstadoEntregaDTO;
import io.github.marcelothebuilder.unoparpedidos4.mappers.EstadoEntregaMapper;
import io.github.marcelothebuilder.unoparpedidos4.model.EstadoEntrega;

@RestController
@RequestMapping("/estado-entrega")
public class EstadoEntregaController {
	@Autowired
	private EstadoEntregaMapper mapper;
	
	@GetMapping
	public List<EstadoEntregaDTO> todos() {
		return mapper.toDtos(EstadoEntrega.values());
	}
}
