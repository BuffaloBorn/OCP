package ekel;

import ekel.utils.Fibonacci;
import ekel.utils.UniversalThreadFactory;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * Created by vitaly on 06.11.15.
 */
public class FibonacciPools {
    public static void main(String[] args) {
        Random random = new Random();
        ThreadFactory tf = new UniversalThreadFactory();
        Supplier<Runnable> tasksGenerator = () ->
                () -> {
                    final int[] fibonacciArray = Fibonacci.compute(random.nextInt(100));
                    final String threadName = Thread.currentThread().getName();
                    System.out.printf("%s :%s%n", threadName, Arrays.toString(fibonacciArray));

                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) { }
                };

        ThreadPoolTest.executeTasks(Executors.newSingleThreadExecutor(tf), tasksGenerator);
        ThreadPoolTest.executeTasks(Executors.newFixedThreadPool(3), tasksGenerator);
        ThreadPoolTest.executeTasks(Executors.newCachedThreadPool(tf), tasksGenerator);

    }
}
