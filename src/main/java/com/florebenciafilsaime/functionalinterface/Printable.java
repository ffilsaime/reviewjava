package com.florebenciafilsaime.functionalinterface;

@FunctionalInterface
public interface Printable<T> {
    void print(T t);
}
