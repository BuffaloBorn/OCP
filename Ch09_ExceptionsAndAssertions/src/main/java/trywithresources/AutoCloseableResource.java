package trywithresources;

/**
 * Created by Vitaly on 29.07.2016.
 */
public class AutoCloseableResource implements AutoCloseable {
    private static int counter = 0;
    private final String name;

    public AutoCloseableResource() {
        this("AutoCloseableResource_" + counter++);
    }

    public AutoCloseableResource(String name) {
        this.name = name;
        System.out.println("Resource '" + name + "' is opened--->");
    }

    @Override
    public void close() {
        System.out.println("Resource '" + name + "' is closed---X");
        throw new RuntimeException("Resource '" + name + "' is broken XXX");
    }
}
