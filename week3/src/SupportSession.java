import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SupportSession {

    public static List<String> getList() {
        return List.of("hi", "bat", "ear", "hello", "iguana",
                "beaver", "winterland", "elephant", "eye", "qi");
    }

    public static void main(String... args) {
        question17();
    }

    public static void question6() {
        List<String> words = getList();
        System.out.println("6:");

        words.stream()
                .peek(System.out::println)
                .filter(s -> s.contains("e"))
                .peek(System.out::println)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .filter(s -> s.length() < 4)
                .peek(System.out::println)
                .findFirst()
                .ifPresent(System.out::println);
    }

    record Pair(int n1, int n2) {};

    public static void question14() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4);
        Stream<List<Integer>> stream = list1.stream()
                .flatMap(n1 -> list2.stream()
                        .map(n2 -> Arrays.asList(n1, n2)));
        // T = List<Integer>
        int[] array = new int[] {3, 4};
        int first = array[0];
        int firstL = list2.get(0);
        int second = array[1];
        int secondL = list2.get(1);

        List<Pair> pairs = list1.stream()
                .flatMap(n1 -> list2.stream()
                        .map(n2 -> new Pair(n1, n2)))
                //.filter((n1, n2) -> (n1 + n2) % 3 == 0)
                .filter(p -> (p.n1() + p.n2()) % 3 == 0)
                // alternatively: deconstruction in Java 21
                .filter(p -> switch (p) {
                    case Pair(var i1, var i2) -> (i1 + i2) % 3 == 0;
                })
                .toList();
        pairs.forEach(System.out::println);
        System.out.println();
    }

    public static List<Integer> orderedNumberList(int start, int step, int size) {
        Stream<Integer> stream;
        int j;
        return IntStream.iterate(start, i -> i + step)
                .limit(size)
                .boxed()
                .toList();
    }

    public static void question17() {
        int someSize = 10;
        List<Integer> nums = orderedNumberList(50, 5, someSize);
        System.out.println(nums);

        int s = nums.stream()
                .reduce(0, (n1, n2) -> n1 + n2);

        nums.stream()
                .reduce(0, Integer::sum);

        Optional<Integer> s2 = nums.stream()
                .reduce((n1, n2) -> n1 + n2);

        nums.stream()
                .reduce(0, (n1, n2) -> n1 + n2, (n1, n2) -> n1 + n2);

        IntStream intStream = IntStream.of(10, 20);
        int sum = intStream.sum();

        int sum1 = nums.stream()
                .mapToInt(i -> i)
                .sum();

        Random r = new Random();
        DoubleStream
                .generate(() -> r.nextDouble())
                .limit(10)
                .boxed()
                .toList();


        //IntStream intStream = IntStream.of(10);
        //List<String> list = List.of("aa", "b", "ccc");
        //IntStream.range(0, list.size())
        //        .mapToObj(i -> i + ": " + list.get(i))
        //        .forEach(System.out::println);
    }
}
