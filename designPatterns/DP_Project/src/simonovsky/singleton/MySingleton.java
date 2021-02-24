package simonovsky.singleton;

public class MySingleton {
    private static MySingleton singleton = new MySingleton();

    private int count = 0;

    private MySingleton() {}

    public static MySingleton getInstance() {
        return singleton;
    }

    protected static void demoMethod() {
        System.out.println("demoMethod for singleton");
    }

    protected static int getCount() {
        return singleton.count;
    }

    protected static void setCount(int count) {
        singleton.count = count;
    }
}
