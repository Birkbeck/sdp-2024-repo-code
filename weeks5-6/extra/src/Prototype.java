import java.util.ArrayList;
import java.util.List;

public class Prototype implements Cloneable {
    private List<Prototype> list = new ArrayList<>();

    @Override
    public Prototype clone() {
        try {
            Prototype clone = (Prototype) super.clone();
            clone.list = new ArrayList<>(list);
            return clone;
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e); // this should never happen
        }
    }
}
