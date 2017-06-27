package io.github.marcelothebuilder.unoparpedidos4.controllers;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.marcelothebuilder.unoparpedidos4.dto.PassoEntregaDTO;
import io.github.marcelothebuilder.unoparpedidos4.dto.PedidoDTO;
import io.github.marcelothebuilder.unoparpedidos4.mappers.PassoEntregaMapper;
import io.github.marcelothebuilder.unoparpedidos4.mappers.PedidoMapper;
import io.github.marcelothebuilder.unoparpedidos4.model.PassoEntrega;
import io.github.marcelothebuilder.unoparpedidos4.model.Pedido;
import io.github.marcelothebuilder.unoparpedidos4.repository.PedidoRepository;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository repository;

	@Autowired
	private PedidoMapper mapper;

	@Autowired
	private PassoEntregaMapper passoMapper;

	@GetMapping("/{codigo}")
	public PedidoDTO porCodigo(@PathVariable("codigo") Long codigo) {
		return mapper.pedidoToPedidoDTO(repository.findOne(codigo));
	}

	@PostMapping
	public void novo(@Valid @RequestBody PedidoDTO dto) {
		Pedido pedido = mapper.pedidoDTOToPedido(dto);
		repository.save(pedido);
	}

	@GetMapping
	public List<PedidoDTO> todos() {
		return mapper.pedidosToPedidoDTOs(repository.findAll());
	}

	@GetMapping("/{codigo}/passo-entrega")
	public List<PassoEntregaDTO> passosEntrega(@PathVariable("codigo") Long codigo) {
		Pedido pedido = repository.findOne(codigo);
		List<PassoEntrega> passos = pedido.getPassosEntrega();

		return passoMapper.toDtos(passos);
	}

	@PostMapping("/{codigo}/passo-entrega")
	@Transactional
	public void adicionarPassoEntrega(@PathVariable("codigo") Long codigo, @RequestBody @Valid PassoEntregaDTO passoDTO) {
		PassoEntrega passo = passoMapper.fromDto(passoDTO);
		passo.getPedido().adicionarPassoEntrega(passo);
		repository.save(passo.getPedido());
	}
}
