package patterns.singleton;

/**
 * Created by vitaly on 07.09.15.
 */
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
        System.out.println("LazySingleton create.");
    }

    public static LazySingleton getInstance() {
        System.out.println("Try to get instance...");
        if (instance == null) {
            instance = new LazySingleton();
        }

        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
    }
}
