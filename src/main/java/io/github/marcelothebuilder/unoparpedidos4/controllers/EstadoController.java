package io.github.marcelothebuilder.unoparpedidos4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.marcelothebuilder.unoparpedidos4.dto.EstadoDTO;
import io.github.marcelothebuilder.unoparpedidos4.mappers.EstadoMapper;
import io.github.marcelothebuilder.unoparpedidos4.model.Estado;
import io.github.marcelothebuilder.unoparpedidos4.repository.EstadoRepository;

@RestController
@RequestMapping("/estado")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private EstadoMapper mapper;

	@GetMapping
	public List<EstadoDTO> todos() {
		return mapper.estadosToEstadoDTOs(estadoRepository.findAll());
	}

	@GetMapping(path = "/{codigo}")
	public EstadoDTO porId(@PathVariable("codigo") Long codigo) {
		return mapper.estadoToEstadoDTO(estadoRepository.findOne(codigo));
	}

	@PostMapping
	public void novo(@RequestBody EstadoDTO dto) {
		Estado estado = mapper.estadoDTOToEstado(dto);
		estadoRepository.save(estado);
	}

	@PutMapping(path = "/{codigo}")
	public void substituir(@PathVariable("codigo") Long codigo, @RequestBody EstadoDTO dto) {
		Estado estado = mapper.estadoDTOToEstado(dto);
		estado.setCodigo(codigo);
		estadoRepository.save(estado);
	}
}
