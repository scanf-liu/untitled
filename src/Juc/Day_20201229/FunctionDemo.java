package Juc.Day_20201229;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionDemo {
    public static void main(String[] args) {
        Consumer<String> consumer = s -> {
            System.out.println(s);
        };
        consumer.accept("asd");

        Supplier<String> supplier = () -> "error";
        System.out.println(supplier.get());

        Function<String, Integer> function = s -> s.length();
        System.out.println(function.apply("asdf"));

        Predicate<String> predicate = String::isEmpty;
        System.out.println(predicate.test(""));
        System.out.println(predicate.test("asd"));
    }
}
