package patterns.singleton;

/**
 * Created by vitaly on 07.09.15.
 */
public class ThreadSafeLazySingleton {
    private static ThreadSafeLazySingleton instance;

    private ThreadSafeLazySingleton() {
        System.out.println("LazySingleton create.");
    }

    public static ThreadSafeLazySingleton getInstance() {
        System.out.println("Try to get instance...");
        if (instance == null) {
            synchronized (ThreadSafeLazySingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeLazySingleton();
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
    }
}
