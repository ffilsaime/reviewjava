package com.florebenciafilsaime.functionalinterface;

@FunctionalInterface
public interface Functionable<T, R> {
    R applyThis(T t);
}
