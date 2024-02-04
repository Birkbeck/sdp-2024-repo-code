import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static Set<Dish> getSet(Dish d1, Dish d2) {
        Set<Dish> s = new HashSet<>();
        s.add(d1);
        s.add(d2);
        return s;
    }
    public static void main(String... args) {
        List<Dish> list = Dish.getMenu();

//        List<Integer> integers = list.stream()
//                .filter(Dish::vegetarian)
//                .map(Dish::calories)
//                .toList();
//        List<Dish> list3 = stream.toList();

//        List<Dish> dl = list.stream()
//                .filter(Dish::vegetarian)
//                .toList();
//        System.out.println(dl);

//        list.stream()
//                .map(Dish::name)
//                .forEach(n -> System.out.println(n));

//        System.out.println(list.stream()
//                .flatMap(d -> list.stream()
//                        .filter(Dish::vegetarian)
//                        .map(d1 -> Stream.of(d, d1).collect(Collectors.toSet())))
//                .distinct()
//                .toList());

       List<List<Dish>> result = new ArrayList<>();
        for (Dish d : list) {
            for (Dish d1 : list)
                result.add(List.of(d, d1));
        }
        System.out.println(result);

        var o = list.stream()
                .filter(d -> d.vegetarian())
                .flatMap(d -> list.stream()
                        .filter(d1 -> d1.calories() < 500)
                        .map(d1 -> List.of(d, d1)))
                .toList();
        System.out.println(o);

        Optional<Dish> e = list.stream()
                .findFirst();
        e.ifPresent(System.out::println);
        //        .ifPresent(s -> System.out.println(s));



//        list.stream()
//                .peek(d -> System.out.println("before filter " + d))
//                .filter(Dish::vegetarian)
//                .peek(d -> System.out.println("after filter " + d))
//                .findFirst();

//        System.out.println();
        var dl2 = list.stream()
                .flatMap(d -> pairsWithDish(d, list))
                .toList();
//        System.out.println(dl2);

//        List<List<List<Dish>>> result1 = new ArrayList<>();
//        for (Dish d : list) {
//            List<List<Dish>> r = new ArrayList<>();
//            for (Dish d1 : list)
//                r.add(List.of(d, d1));
//            result1.add(r);
//        }

    }


    private static Stream<List<Dish>> pairsWithDish(Dish d, List<Dish> list) {
        return list.stream()
                .map(d1 -> List.of(d, d1));
    }

    public static List<String> getList() {
        return List.of("hi", "bat", "ear", "hello", "iguana",
                "beaver", "winterland", "elephant", "eye", "qi");
    }
}
