package io.github.marcelothebuilder.unoparpedidos4.events;

public class EventoCriacao<T> extends TypedApplicationEvent<T> {
	private static final long serialVersionUID = 1L;

	public EventoCriacao(T objetoCriado) {
		super(objetoCriado);
	}

	@SuppressWarnings("unchecked")
	public T getCriado() {
		return (T) this.getSource();
	}
}
