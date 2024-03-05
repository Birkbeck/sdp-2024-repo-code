import java.util.ArrayList;
import java.util.List;

class Animal {

}

class Buffalo extends Animal {

}

// PECS: Producer extends Consumer super

public class Generics {
    public static void m(List<? extends Animal> list) {
        Animal a = list.get(0);
    }

    public static void m2(List<? super Buffalo> list) {
        list.add(new Buffalo());
    }

    public static void m3(List<Buffalo> list) {
        list.add(new Buffalo());
        Buffalo b = list.get(0);
    }

    public static void main(String[] args) {
        List<Animal> listA = new ArrayList<>();
        listA.add(new Animal());
        List<Buffalo> listB = new ArrayList<>();
        listB.add(new Buffalo());
        m(listB);
        m2(listB);
        m2(listA);
        Animal a = listA.get(0);
        Buffalo b = listB.get(0);

        Buffalo[] ba = new Buffalo[1];
        Animal[] aa = ba;
        aa[0] = new Animal();
        Buffalo bb = ba[0];
    }
}
