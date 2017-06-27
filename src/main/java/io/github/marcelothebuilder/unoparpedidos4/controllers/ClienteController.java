package io.github.marcelothebuilder.unoparpedidos4.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.marcelothebuilder.unoparpedidos4.dto.ClienteDTO;
import io.github.marcelothebuilder.unoparpedidos4.mappers.ClienteMapper;
import io.github.marcelothebuilder.unoparpedidos4.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private ClienteMapper mapper;
	
	@GetMapping("/{codigo}")
	public ClienteDTO porCodigo(@PathVariable("codigo") Long codigo) {
		return mapper.toDto(repository.findOne(codigo));
	}
	
	@PostMapping
	public void novo(@Valid @RequestBody ClienteDTO dto) {
		repository.save(mapper.fromDto(dto));
	}
	
	@GetMapping
	public List<ClienteDTO> todos() {
		return mapper.toDto(repository.findAll());		
	}
}
