package simonovsky.singleton;

public class MySingletonTester {
    public static void main(String[] args) {
        MySingleton tmp = MySingleton.getInstance();
        tmp.demoMethod();

        MySingleton tmp2 = MySingleton.getInstance();
        tmp2.demoMethod();

        tmp2.setCount(8);
        System.out.println(tmp.getCount());

        MySingleton tmp3 = MySingleton.getInstance();

        System.out.println(tmp3.getCount());
        System.out.println(MySingleton.getCount());
    }
}
