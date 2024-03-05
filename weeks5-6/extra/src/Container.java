import java.util.Iterator;
import java.util.NoSuchElementException;

public class Container implements Iterable<String> {
    private String[] contents = new String[10];

    public static void main(String... args) {
        Container c = new Container();
        //for (Iterator<String> i = c.iterator(); i.hasNext(); ) {
        for (String s : c) {
        //    String s = i.next();
            System.out.println(s);
        }
        c.forEach(System.out::println);
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < contents.length;
            }

            @Override
            public String next() {
                if (hasNext()) {
                    String e = contents[index];
                    index++;
                    return e;
                }
                throw new NoSuchElementException();
            }
        };
    }
}
