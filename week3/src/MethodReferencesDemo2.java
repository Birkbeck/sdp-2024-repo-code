import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReferencesDemo2 {
    public static void main(String[] args) {
        f("a", "b", "c");
        f(new String[]{"a", "b", "c"});
        //f2("a", "b", "c");
        f2(new String[]{"a", "b", "c"});
    }

    public static void f(String... args) {
        int i = args.length;
        String s = args[0];
    }

    public static void f2(String[] args) {
        int i = args.length;
        String s = args[0];
    }

    public static class A {

        public static void g() {
            //A::m;
            A a = new A();
            //a::m;
            Function<Integer, String> r1 = a::m;
            Function<Integer, String> r2 = a::m2;
            BiFunction<Integer, Long, String> rq = a::q;
            BiFunction<A, Integer, String> sm = A::m;
            BiFunction<A, Integer, String> smp = A::p;
        }

        public String m(Integer i) {
            return "0";
        }

        public String m2(A this, Integer i) {
            return "0";
        }

        public String q(Integer i, Long l) {
            return "2";
        }

        public static String p(A a, Integer i) {
            return "";
        }
    }
}
