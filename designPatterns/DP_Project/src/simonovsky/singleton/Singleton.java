package simonovsky.singleton;

public class Singleton {
    public static final Singleton INSTANCE = new Singleton();

    private Singleton() {
        if(INSTANCE != null) {
            throw new IllegalStateException("Singleton already constructed");
        }
    }

}
