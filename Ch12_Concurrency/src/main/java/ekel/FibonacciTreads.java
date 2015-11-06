package ekel;

import ekel.utils.Fibonacci;
import ekel.utils.UniversalThreadFactory;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadFactory;

/**
 * Created by vitaly on 06.11.15.
 */
public class FibonacciTreads {
    public static void main(String[] args) {
        Random random = new Random();
        ThreadFactory tf = new UniversalThreadFactory();

        for (int i = 0; i < 20; i++) {
            Thread t = tf.newThread(() -> System.out.printf("%s :%s%n", Thread.currentThread().getName(), Arrays.toString(Fibonacci.compute(random.nextInt(1000)))));
            t.start();
        }
    }
}
