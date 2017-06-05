package io.github.marcelothebuilder.unoparpedidos4.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AnunciadorEventos {
	@Autowired
	private ApplicationEventPublisher publisher;
	
	public <T> void anunciarCriacao(T objetoCriado) {
		publisher.publishEvent(new EventoCriacao<T>(objetoCriado));
	}
}
