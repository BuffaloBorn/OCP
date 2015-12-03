package ekel;

/**
 * Created by vitaly on 26.11.15.
 */
public class Fat {
    private static int counter = 0;
    private volatile double d;
    private final int id = counter++;

    public Fat() {
        for (int i = 0; i < 100000; i++) {
            d += (Math.PI + Math.E) / (double)i;
        }
    }

    public void operation() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Fat id:" + id;
    }
}
