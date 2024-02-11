package structural.proxy.person;

public class PersonProxy implements PersonInterface {

    private final Person person;
    private final String cachedName;

    public PersonProxy(Person p) {
        person = p;
        cachedName = person.getName();
    }

    @Override
    public String getName() {
        // return the cached (local) version
        return cachedName;
    }

    @Override
    public float getWeight() {
        // Pass through the request to the real object
        return person.getWeight();
    }
}
