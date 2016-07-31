package OCP;

import concurrency.AutoCloseableExecutorService;
import print.PrintUtils;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Vitaly on 30.07.2016.
 */
public class ZooInfo {
    private static class PrintRunnable implements Runnable, Callable<Object> {
        private final static Random rnd = new Random();
        private final Optional<Long> delay;

        private PrintRunnable(Long delay) {
            this.delay = Optional.ofNullable(delay);
        }

        private PrintRunnable() {
            this((long) rnd.nextInt(1000));
        }

        @Override
        public void run() {
            System.out.println("Printing zoo inventory with delay: " + delay.orElse(0L));
            delay.ifPresent(this::millisSleepWrapper);
        }

        @Override
        public Object call() throws Exception {
            run();
            return delay.orElse(0L);
        }

        private void sleepWrapper(TimeUnit timeUnit, long time) {
            try {
                timeUnit.sleep(time);
            } catch (InterruptedException e) {
                System.out.println("INTERRUPDED->" + this);
            }
        }

        private void millisSleepWrapper(long time) {
            sleepWrapper(TimeUnit.MILLISECONDS, time);
        }

        @Override
        public String toString() {
            return "D:" + delay.orElse(0L);
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        singleThreadExecutor();
//        collectionTasks();
        collectionTasksAsync();
    }

    public static void collectionTasks() throws InterruptedException, ExecutionException {
        try (AutoCloseableExecutorService exec = new AutoCloseableExecutorService(Executors.newFixedThreadPool(10))) {
            System.out.println("Begin");
            List<Callable<Object>> tasks = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                tasks.add(new PrintRunnable());
            }
            System.out.println(tasks);
            PrintUtils.printSectionName("Invoking ALL");
            List<Future<Object>> results = exec.invokeAll(tasks);
            PrintUtils.printSectionName("Invoking ANY");
            System.out.println("Result: " + exec.invokeAny(tasks));
            System.out.println("End");
        }
    }

    public static void collectionTasksAsync() throws InterruptedException, ExecutionException {
        try (AutoCloseableExecutorService exec = new AutoCloseableExecutorService(Executors.newFixedThreadPool(10))) {
            System.out.println("Begin");
            List<Callable<Object>> tasks = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                tasks.add(new PrintRunnable());
            }
            System.out.println(tasks);
            PrintUtils.printSectionName("Invoking ALL");
            List<Future<Object>> results = exec.invokeAllAsync(tasks);
            for (int i = 0; i < 10; i++) {
//                System.out.println(results);
                Map<String, String> map = IntStream.range(0, results.size()).boxed().collect(Collectors.toMap(ti -> tasks.get(ti).toString(), ri -> results.get(ri).isDone()?"X":"O"));
                System.out.println(map);
                TimeUnit.MILLISECONDS.sleep(100);
            }
            System.out.println("End");
        }
    }

    public static void singleThreadExecutor() throws InterruptedException, ExecutionException {
        Runnable r = () -> {
            System.out.println("printing...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ignore) {
            }
        };
        Future<?> f;
        try (AutoCloseableExecutorService exec = new AutoCloseableExecutorService(Executors.newSingleThreadExecutor())) {
            System.out.println("Begin");
            exec.execute(new PrintRunnable());
            exec.execute(() -> {
                for (int i = 0; i < 10; i++) System.out.println("Printing record " + i);
            });
            exec.execute(new PrintRunnable());
            exec.execute(r);
            exec.execute(r);
            exec.execute(r);
            exec.execute(r);
            f = exec.submit(r);
        }
        System.out.println(f.get());
        System.out.println("End");
    }
}
