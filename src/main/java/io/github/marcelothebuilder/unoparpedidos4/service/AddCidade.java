package io.github.marcelothebuilder.unoparpedidos4.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import io.github.marcelothebuilder.unoparpedidos4.model.Cidade;
import io.github.marcelothebuilder.unoparpedidos4.model.Estado;
import io.github.marcelothebuilder.unoparpedidos4.repository.CidadeRepository;
import io.github.marcelothebuilder.unoparpedidos4.repository.EstadoRepository;

@Transactional
@Service
public class AddCidade {
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	
	@EventListener(ContextRefreshedEvent.class)
	@Transactional
	public void test() {
		if (estadoRepository.count() == 0) {
			Estado estado = new Estado();
			estado.setNome("Minas Gerais");
			estado.setUf("MG");
			
			Cidade cidade = new Cidade();
			cidade.setEstado(estado);
			cidade.setNome("Uberlândia");
			
			estadoRepository.save(estado);
			cidadeRepository.save(cidade);
		}
	}
	
}
