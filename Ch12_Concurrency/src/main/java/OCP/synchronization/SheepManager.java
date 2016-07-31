package OCP.synchronization;

import concurrency.AutoCloseableExecutorService;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Vitaly on 31.07.2016.
 */
public class SheepManager implements Callable<Integer>{
    private static AtomicInteger counter = new AtomicInteger(0);

    @Override
    public Integer call() throws Exception {
        return counter.incrementAndGet();
    }

    private static String futureToString(Future<?> future) {
        try {
            return Objects.toString(future.get());
        } catch (Exception ignore) {return null; }
    }

    public static void main(String[] args) throws InterruptedException {
        try(AutoCloseableExecutorService exec = new AutoCloseableExecutorService(Executors.newFixedThreadPool(10));){
            List<Callable<Integer>> tasks = Stream.generate(SheepManager::new).limit(10).collect(Collectors.toList());
            List<Future<Integer>> results = exec.invokeAll(tasks);

            System.out.println(results.stream().map(SheepManager::futureToString).collect(Collectors.joining(", ", "[", "]")));
            System.out.println(counter);
        }
    }
}
