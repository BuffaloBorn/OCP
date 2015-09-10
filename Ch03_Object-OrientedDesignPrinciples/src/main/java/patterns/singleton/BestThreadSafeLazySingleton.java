package patterns.singleton;

/**
 * Created by vitaly on 07.09.15.
 */
public class BestThreadSafeLazySingleton {
    private static class InstanceHolder {
        private static BestThreadSafeLazySingleton instance = new BestThreadSafeLazySingleton();
    }

    private BestThreadSafeLazySingleton() {
        System.out.println("Singleton creates");
    }

    public static BestThreadSafeLazySingleton getInstance() {
        System.out.println("Try to get instance...");
        return InstanceHolder.instance;
    }

    public static void main(String[] args) {
        System.out.println(BestThreadSafeLazySingleton.class);
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
}
