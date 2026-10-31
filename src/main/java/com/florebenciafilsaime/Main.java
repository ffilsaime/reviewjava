package com.florebenciafilsaime;

import com.florebenciafilsaime.functionalinterface.Evaluate;
import com.florebenciafilsaime.functionalinterface.Functionable;
import com.florebenciafilsaime.functionalinterface.Printable;
import com.florebenciafilsaime.functionalinterface.Retrievable;
import com.florebenciafilsaime.misc.Person;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
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

        //Using a lambda expression, implement the Evaluate interface (typed for Integer). The relevant
        //method returns true if the argument passed is < 0, otherwise it returns false. Invoke the relevant
        //method twice – the first time pass in -1 and the second time pass in +1
        Evaluate<Integer> evaluate = (number) -> number < 0;
        System.out.println("This is evaluate with -1:   " + evaluate.isNegative(-1));
        System.out.println("This is evaluate with 1:   " + evaluate.isNegative(1));

        //Doing the same thing with Predicate
        Predicate<Integer> predicate = (number) -> number < 0;
        System.out.println("This is evaluate with -1:   " + predicate.test(-1));
        System.out.println("This is evaluate with 1:   " + predicate.test(1));

        //want to know when a number is even; then use 4 and 7
        Predicate<Integer> numPredicate = (number) -> number % 2 == 0;
        System.out.println("Is 4 even?:   " + check(4, numPredicate));
        System.out.println("Is 7 even?:   " + check(7, numPredicate));
        // want to know if words start with "Mr."
        Predicate<String> stringPredicate = (word) -> word.startsWith("Mr.");
        System.out.println("Does Mr. Joe Blogs start with Mr. ? " + check("Mr. Joe Blogs", stringPredicate));
        System.out.println("Does Ms. Ann Blogs start with Mr. ? " + check("Ms. Anne Blogs", stringPredicate));
        // want to know if a person is legally an adult
        Predicate<Person> personPredicate = (person) -> person.age() >= 18;
        System.out.println("Is Mike an Adult? " + check(new Person(33, "Mike", 1.8), personPredicate));
        System.out.println("Is Ann an Adult? " + check(new Person(13, "Mike", 1.4), personPredicate));

        //Using a lambda expression, implement the Functionable interface - the input type is Integer and the
        //return type is String. The relevant method returns the number passed in appended to the String
        //“Number is: ”. Invoke the relevant method passing in 25
        Functionable<Integer, String> functionable = (number) -> "Number is: " + number;
        System.out.println("What is the mystery number? " + functionable.applyThis(25));
        //do the same thing using a function
        Function<Integer, String> function = (number) -> "Number is: " + number;
        System.out.println("What is the mystery number? " + function.apply(25));
    }

    public static <T> boolean check(T tObject, Predicate<T> predicate) {
        return predicate.test(tObject);
    }
}
