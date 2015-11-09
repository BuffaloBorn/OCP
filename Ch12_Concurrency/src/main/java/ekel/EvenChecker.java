package ekel;

import ekel.utils.IntGenerator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Vitaly on 08.11.2015.
 */
public class EvenChecker implements Runnable {
    private final IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int value = generator.next();
            if (value % 2 != 0) {
                System.out.printf("Value '%d' not even!%n", value);
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator g, int count) {

        System.out.println("Press Ctrl+C to break.");
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < count; i++) {
            executor.execute(new EvenChecker(g, i));
        }

        executor.shutdown();
    }

    public static void main(String[] args) {
        test(new EvenGenerator(), 10);
    }

    public static class EvenGenerator extends IntGenerator {
        private int value;

        public EvenGenerator() {
            this(0);
        }

        public EvenGenerator(int value) {

            this.value = value;
        }

        @Override
        public synchronized int next() {
            value++;
            Thread.yield();
            value++;

            return value;
        }
    }
}
