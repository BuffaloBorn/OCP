package patterns.singleton;

/**
 * Created by vitaly on 07.09.15.
 */
public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();
    private EagerSingleton(){System.out.println("EagerSingleton create.");}

    public static EagerSingleton getInstance() {
        System.out.println("Try to get instance...");
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
    }
}
