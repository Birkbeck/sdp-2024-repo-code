package staticdemo;

public enum DayOfWeek {
    // The enum declaration defines a class (called an enum type).
    // All enums implicitly extend java.lang.Enum, which provides
    // instance methods like .name(), .ordinal(), .equals(Object), .hashCode(), .toString()
    // and class methods .valueOf(String) and value()
    // Enums can implement interfaces

    // instances of the enum - note the parameters passed to the constructor
    // there will be only these 7 instances of this enum
    MON("Monday"),
    TUE("Tuesday"),
    WED("Wednesday"),
    THU("Thursday"),
    FRI("Friday"),
    SAT("Saturday"),
    SUN("Sunday");

    private final String fullName;

    // enums can have constructors
    DayOfWeek(String fullName) {
        this.fullName = fullName;
    }

    // and their own methods
    public String getFullName() {
        return fullName;
    }
}
