package structural.proxy.person;

public class Person implements PersonInterface {
    private final String name;
    private final float weight;

    public Person(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public float getWeight() {
        // Assume we weigh ourselves here
        return weight;
    }

    @Override
    public String getName() {
        return name;
    }
}
