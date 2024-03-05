import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Equals {
    //@Override
    //public boolean equals(Equals e) { return true; }

    @Override
    public boolean equals(Object o) {
        return Objects.equals(this, o);
    }

    private int i, j;
    private boolean b;

    @Override
    public int hashCode() {
        return Objects.hash(i ,j, b);
    }

    public static void main(String... args) {
        Equals eq = new Equals();
        Equals eq1 = new Equals();
        //eq.equals(eq1);
        //Objects.equals(eq, eq1);
        //eq.equals(eq1);
        //eq1.equals(eq);

        long q = 0b1010_0100_1100_0110_1000_0000_0000_0000L;
        System.out.println(q);

        System.out.println(1_764_472_320 + 1_000_000_000);

        System.out.printf("%x\n", -10);

        String s1 = "FB";
        String s2 = "Ea";
        System.out.println(s1.hashCode() + " v " + s2.hashCode());

        Set<Equals> set = new HashSet<>();
        set.add(eq); // eq.hashCode() % HASH_TABLE_SIZE

    }
}
