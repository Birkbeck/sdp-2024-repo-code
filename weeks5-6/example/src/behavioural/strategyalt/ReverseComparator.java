package behavioural.strategyalt;

import java.util.Comparator;

public class ReverseComparator<T> implements Comparator<T> {
    private final Comparator<T> c;

    public ReverseComparator(Comparator<T> c) {
        this.c = c;
    }

    @Override
    public int compare(T o1, T o2) {
        return c.compare(o2, o1);
    }
}