package io.github.marcelothebuilder.unoparpedidos4.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

abstract class TypedApplicationEvent<T> extends ApplicationEvent implements ResolvableTypeProvider {
	private static final long serialVersionUID = 1L;

	public TypedApplicationEvent(T source) {
		super(source);
	}

	@Override
	public ResolvableType getResolvableType() {
		return ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forInstance(source));
	}

}
