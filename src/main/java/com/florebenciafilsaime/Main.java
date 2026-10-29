package com.florebenciafilsaime;

import com.florebenciafilsaime.functionalinterface.Printable;
import com.florebenciafilsaime.functionalinterface.Retrievable;

import java.util.function.Consumer;
import java.util.function.Supplier;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //using the printable interface and implementing the function using lambda
        Printable<String> printable = (word) -> System.out.println(word);
        printable.print("Hello, user!");

        //Using both a lambda expression and a method reference, implement 1a using a Consumer.
        Consumer<String> consumer = System.out::println;
        consumer.accept("Hello, world! I'm using a consumer.");

        //Using a lambda expression, implement the Retrievable interface (typed for Integer). The relevant
        //method just returns 77. Invoke the relevant method.
        Retrievable<Integer> retrievable = () -> 77;
        System.out.println("This is the value from Retrievable: " + retrievable.retrieve());
        //Using a lambda expression, implement 2a using a Supplier
        Supplier<Integer> supplier = () -> 1010;
        System.out.println("This is the value from Supplier: " + supplier.get());
    }
}
