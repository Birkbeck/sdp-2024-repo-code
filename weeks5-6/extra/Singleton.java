public class Singleton {

    private Singleton() {
    }

    public static Singleton getInstance() {
        return Instance.INSTANCE;
    }

    private static class Instance {
        public static Singleton INSTANCE = new Singleton();
    }
}
