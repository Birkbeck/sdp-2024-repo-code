package switchexpressions;

enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public class Example {
    public static void main(String[] args) {
        expression1(Day.WEDNESDAY);
    }

    static void expression1(Day day){
        final int numLetters;
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                numLetters = 6;
                break;
            case TUESDAY:
                numLetters = 7;
                break;
            case THURSDAY:
            case SATURDAY:
                numLetters = 8;
                break;
            case WEDNESDAY:
                numLetters = 9;
                break;
            default:
                throw new IllegalStateException("Invalid day: " + day);
        }
        System.out.println(numLetters);
    }

    static void expression2(Day day) {
        final int numLetters;
        switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> numLetters = 6;
            case TUESDAY -> numLetters = 7;
            case THURSDAY, SATURDAY -> numLetters = 8;
            case WEDNESDAY -> numLetters = 9;
            default -> throw new IllegalStateException("Invalid day: " + day);
        }
        System.out.println(numLetters);
    }

    static void expression3(Day day) {
        System.out.println(
            switch (day) {
                case MONDAY, FRIDAY, SUNDAY -> 6;
                case TUESDAY -> 7;
                case THURSDAY, SATURDAY -> 8;
                case WEDNESDAY -> 9;
                // default not needed because all possible values are covered!

                // switch expressions and switch statements used to throw a NullPointerException
                // if the value of the selector expression is null.
                // From Java 21, to add more flexibility, a null case label is available:
                case null -> -1;
            }
        );
    }


    static void expression4(Day day) {
        int numLetters = switch (day) {
            case MONDAY,
                FRIDAY,
                SUNDAY -> {
                System.out.println(6);
                yield 6;
            }
            case TUESDAY -> {
                System.out.println(7);
                yield 7;
            }
            case THURSDAY,
                SATURDAY -> {
                System.out.println(8);
                yield 8;
            }
            case WEDNESDAY -> {
                System.out.println(9);
                yield 9;
            }
            // default not needed because all possible values are covered!
        };
        System.out.println(numLetters);
    }
}