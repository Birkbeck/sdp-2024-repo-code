import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {
        Function<String, Integer> f = String::length;
        BiFunction<String, String, Integer> g = String::compareTo;

        Predicate<String> ff = String::isEmpty;
        BiPredicate<String, String> gg = (s1, s2) -> (s1 + s2).isEmpty();

        Consumer<String> fff = System.out::println;
        Supplier<String> ggg = () -> "s";

        IntFunction<String> ffff = i -> "" + i;
        ToIntFunction<String> gggg = String::length;

        BinaryOperator<String> sss = String::concat;
        UnaryOperator<String> ss = String::toUpperCase;

    }

}