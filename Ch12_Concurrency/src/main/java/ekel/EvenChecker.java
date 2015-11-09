package ekel;

import ekel.generators.EvenGenerator;
import ekel.generators.SynchronizedEvenGenerator;
import ekel.utils.IntGenerator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
        while (!generator.isCanceled() && !Thread.interrupted()) {
            int value = generator.next();
            if (value % 2 != 0) {
                System.out.printf("Value '%d' not even!%n", value);
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator g, int count, long timeout, TimeUnit timeUnit) {

        System.out.println("Press Ctrl+C to break.");
        System.out.printf("Starting to test %s...%n", g.getClass().getName());
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < count; i++) {
            executor.execute(new EvenChecker(g, i));
        }

        executor.shutdown();

        try {
            executor.awaitTermination(timeout, timeUnit);

            if (!executor.isTerminated()) {
                executor.shutdownNow();
            }

            if (g.isCanceled()) {
                System.err.println("Generator has synchronized errors");
            } else {
                System.out.println("Generator works good!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test(new EvenGenerator());
        test(new SynchronizedEvenGenerator());
    }

    private static void test(IntGenerator evenGenerator) {
        test(evenGenerator, 10, 5, TimeUnit.SECONDS);
    }

}
