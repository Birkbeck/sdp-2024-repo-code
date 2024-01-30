import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReferencesDemo {

    public static void main(String[] args) {
        MethodReferencesDemo a = new MethodReferencesDemo();
        String k = a.m(1);

        Consumer<Integer> g = System.out::print;
        Function<Integer, String> f = a::m;
        BiFunction<MethodReferencesDemo, Integer, String> f2 = MethodReferencesDemo::m2;
        BiFunction<MethodReferencesDemo, String, String> f2s = MethodReferencesDemo::m2;
        BiFunction<MethodReferencesDemo, Integer, String> f3 = MethodReferencesDemo::m;
        BiFunction<MethodReferencesDemo, Integer, String> f3p = new BiFunction<MethodReferencesDemo, Integer, String>() {
            @Override
            public String apply(MethodReferencesDemo a, Integer integer) {
                return a.m(integer);
            }
        };
        BiFunction<MethodReferencesDemo, StringBuilder, String> fsb = new BiFunction<MethodReferencesDemo, StringBuilder, String>() {
            @Override
            public String apply(MethodReferencesDemo a, StringBuilder stringBuilder) {
                return stringBuilder.toString();
            }
        };
        BiFunction<MethodReferencesDemo, String, String> f3s = MethodReferencesDemo::m;
        BiFunction<MethodReferencesDemo, String, String> f3ps = new BiFunction<MethodReferencesDemo, String, String>() {
            @Override
            public String apply(MethodReferencesDemo a, String string) {
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

    public <T> String m(MethodReferencesDemo this, T i) {
        var ii = i;
        return "0";
    }

    public static <T> String m2(MethodReferencesDemo t, T i) {
        return "1";
    }
}
