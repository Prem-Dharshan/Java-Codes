package LambdaExpressions;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.function.BinaryOperator;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        // 1. UnaryOperator<T>: Applies an operation on a single input and returns the same type.
        UnaryOperator<Integer> increment = (x) -> x + 1;
        System.out.println("Increment 5: " + increment.apply(5)); // Output: 6

        // 2. BinaryOperator<T>: Applies an operation on two inputs and returns the same type.
        BinaryOperator<Integer> add = Integer::sum;
        System.out.println("Add 5 and 3: " + add.apply(5, 3)); // Output: 8

        // 3. Consumer<T>: Accepts a single input and returns no result. It's used for side effects.
        Consumer<String> print = (message) -> System.out.println("Message: " + message);
        print.accept("Hello, World!"); // Output: Message: Hello, World!

        // 4. Supplier<T>: Supplies a value of a specific type without taking any input.
        Supplier<String> randomQuoteSupplier = () -> "The only limit to our realization of tomorrow is our doubts of today.";
        System.out.println("Random Quote: " + randomQuoteSupplier.get());

        // 5. Function<T, R>: Accepts an input of type T and returns a result of type R.
        Function<String, Integer> stringLength = String::length;
        System.out.println("Length of 'Hello': " + stringLength.apply("Hello")); // Output: 5

        // 6. Predicate<T>: Takes an input and returns a boolean indicating whether a condition is met.
        Predicate<Integer> isEven = (n) -> n % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4)); // Output: true
        System.out.println("Is 5 even? " + isEven.test(5)); // Output: false
    }
}
