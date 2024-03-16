import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String... args) {
        List<String> list = Stream.of(
                "one", "two", "three", "four", "five",
                        "six", "seven", "eight", "nine", "ten")
                .flatMap(s -> IntStream.range(0, 10) // "nested loop"
                        .mapToObj(i -> s + ":" + i))
                .toList();

        System.out.println(list.size()); // 10x10 elements

        List<String> result = new ArrayList<>();
        // Collections.synchronizedList(new ArrayList<>()); would fix the problem
        // but would be slow
        list.parallelStream()
                .map(String::toUpperCase)
                // .toList(); should be use here to avoid data races
                .forEach(result::add); // is problematic for parallel streams
                                       // because method .add changes variables shared by many threads
                                       // (class ArrayList is not thread-safe)

        System.out.println(result.size());
    }
}
