package staticdemo;

import java.util.Optional;

import static staticdemo.Outer.i;
import static java.lang.Math.PI;
import static staticdemo.DayOfWeek.*;

public class Demo {
    public static void main(String... args) {
        DayOfWeek dnull = null; // null is a possible value for all reference types (including enums)

        DayOfWeek d = DayOfWeek.TUE;
        DayOfWeek dd = TUE; // same as DayOfWeek.TUE because of the static import in line 7
        System.out.println(dd.getFullName());
        System.out.println(dd.name()); // all enums have .name()
        System.out.println(dd.ordinal()); // all enums have .ordinal()

        for (DayOfWeek d0: DayOfWeek.values()) { // all enums have .values()
            System.out.println(d0);
        }

        DayOfWeek tue = DayOfWeek.valueOf("TUE");

        int k = switch (tue) {
            case MON -> 3; // static import is not necessary as the compiler "knows" the enum from the type of tue
            case TUE -> 4;
            default -> 0; // need to cover all cases individually or with default
        };

        int ii = Outer.i;
        int iii = i; // same as Outer.i because of the static import in line 5

        double r = 2;
        double a = r * r * Math.PI;
        double aa = r * r * PI; // same as Math.PI because of static import in line 6

        boolean pf; // 2 values
        Boolean f; // 3 values: null, true and false
        Optional<Boolean> of = null; // 4 values: null, Optional.empty(), Optional.of(true) and Optional.of(false)

        Integer iv = null; // careful - wrapper types are classes, so null is a possible value
        int jv = iv + 3; // what happens here?
    }
}
