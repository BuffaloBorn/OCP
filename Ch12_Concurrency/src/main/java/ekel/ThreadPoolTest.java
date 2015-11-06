package ekel;

import ekel.utils.LiftOff;
import ekel.utils.UniversalThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * Created by vitaly on 06.11.15.
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        executeTasks(Executors.newCachedThreadPool(new UniversalThreadFactory()));
        executeTasks(Executors.newFixedThreadPool(2, new UniversalThreadFactory()));
        executeTasks(Executors.newSingleThreadExecutor());
    }

    public static void executeTasks(ExecutorService executorService) {
        executeTasks(executorService, LiftOff::new);
    }

    public static void executeTasks(ExecutorService executorService, Supplier<Runnable> taskSupplier) {
        for (int i = 0; i < 7; i++) {
            executorService.execute(taskSupplier.get());
        }

        System.out.println(executorService);
        executorService.shutdown();

        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException ignore) { }

        System.out.println();
        System.out.println("==========================================================================================");
    }
}
