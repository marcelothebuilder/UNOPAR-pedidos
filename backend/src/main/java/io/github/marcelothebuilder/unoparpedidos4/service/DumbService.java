package io.github.marcelothebuilder.unoparpedidos4.service;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.github.marcelothebuilder.unoparpedidos4.dto.ClienteDTO;
import io.github.marcelothebuilder.unoparpedidos4.mappers.ClienteMapper;
import io.github.marcelothebuilder.unoparpedidos4.model.Cidade;
import io.github.marcelothebuilder.unoparpedidos4.model.Cliente;
import io.github.marcelothebuilder.unoparpedidos4.model.Endereco;
import io.github.marcelothebuilder.unoparpedidos4.model.Estado;
import io.github.marcelothebuilder.unoparpedidos4.repository.CidadeRepository;
import io.github.marcelothebuilder.unoparpedidos4.repository.ClienteRepository;
import io.github.marcelothebuilder.unoparpedidos4.repository.EstadoRepository;

@Transactional
@Controller
public class DumbService {
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void onBoot(){
		test();
	}
	
	@Autowired
	private ClienteMapper mapper;
	
	@Transactional
	public void test() {
//		Estado estado = new Estado();
//		estado.setNome("Minas Gerais");
//		estado.setUf("MG");
//		
//		Cidade cidade = new Cidade();
//		cidade.setEstado(estado);
//		cidade.setNome("Uberlândia");
//		
//		estadoRepository.save(estado);
//		cidadeRepository.save(cidade);
//		
//		Endereco endereco = new Endereco();
//		endereco.setBairro("Martins");
//		endereco.setCidade(cidade);
//		
//		Cliente cliente = new Cliente();
//		cliente.setCpf("10000000");
//		cliente.setDataNascimento(new Date());
//		cliente.setEmail("lalal");
//		cliente.setEndereco(endereco);
//		cliente.setNome("Jon");
//		clienteRepository.save(cliente);
//		
//		ClienteDTO dto = mapper.clienteToClienteDTO(cliente);
//		
//		System.out.println(dto.getNome());
	}
	
}
