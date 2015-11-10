package ekel;

import ekel.generators.SerialNumberGenerator;
import ekel.utils.IntGenerator;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by vitaly on 10.11.15.
 */
public class SerialNumberChecker {
    private static final int SIZE = 10;
    private static ExecutorService exec = Executors.newCachedThreadPool();
    private static CircularSet serials = new CircularSet(1000);
    private static IntGenerator generator = new SerialNumberGenerator();

    static class SerialChecker implements Runnable {
        @Override
        public void run() {
            while (!Thread.interrupted()) {
                int serial = generator.next();
                if (serials.contains(serial)) {
                    System.out.printf("Duplicate: %s%n", serial);
                    System.exit(0);
                }
                serials.add(serial);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new SerialChecker());
        }

        TimeUnit.SECONDS.sleep(5);
        System.out.println("No duplicates detected");
    }

}

class CircularSet {
    private int[] array;
    private int len;
    private int index = 0;

    public CircularSet() {
        this(100);
    }

    public CircularSet(int len) {
        array = new int[len];
        this.len = len;
        Arrays.fill(array, -1);
    }

    public synchronized void add(int value) {
        array[index] = value;
        index = ++index % len;
    }

    public synchronized boolean contains(int value) {
        for (int i = 0; i < len; i++) {
            if (array[i] == value) {
                return true;
            }
        }

        return false;
    }
}
