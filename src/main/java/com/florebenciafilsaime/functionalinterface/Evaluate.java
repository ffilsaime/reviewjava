package com.florebenciafilsaime.functionalinterface;

@FunctionalInterface
public interface Evaluate<T> {
    boolean isNegative(T t);
}
