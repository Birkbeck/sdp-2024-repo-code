import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReferencesDemo {

    public static class A {

        public static void main() {
            A a = new A();
            String k = a.m(1);

            Consumer<Integer> g = System.out::print;
            Function<Integer, String> f = a::m;
            BiFunction<A, Integer, String> f2 = A::m2;
            BiFunction<A, String, String> f2s = A::m2;
            BiFunction<A, Integer, String> f3 = A::m;
            BiFunction<A, Integer, String> f3p = new BiFunction<A, Integer, String>() {
                @Override
                public String apply(A a, Integer integer) {
                    return a.m(integer);
                }
            };
            BiFunction<A, StringBuilder, String> fsb = new BiFunction<A, StringBuilder, String>() {
                @Override
                public String apply(A a, StringBuilder stringBuilder) {
                    return stringBuilder.toString();
                }
            };
            BiFunction<A, String, String> f3s = A::m;
            BiFunction<A, String, String> f3ps = new BiFunction<A, String, String>() {
                @Override
                public String apply(A a, String string) {
                    return a.m(string);
                }
            };

            String s = f3.apply(a, 22);
            String s1 = f.apply(42);

            var i = 1;

            var sb = new StringBuilder();

            var al = new ArrayList<Integer>();

            List<Integer> al2 = new ArrayList<>();

            var h = a.m(23);
        }

        public <T> String m(A this, T i) {
            var ii = i;
            return "0";
        }

        public static <T> String m2(A t, T i) {
            return "1";
        }
    }
}
