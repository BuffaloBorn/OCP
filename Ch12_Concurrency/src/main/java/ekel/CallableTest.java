package ekel;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by vitaly on 06.11.15.
 */
public class CallableTest implements Callable<String> {
    private static int counter = 0;
    private int value;

    public CallableTest() {
        synchronized (CallableTest.class) {
            value = counter++;
        }
    }

    @Override
    public String call() throws Exception {
        int sleepTime = ThreadLocalRandom.current().nextInt(1000);
        TimeUnit.MILLISECONDS.sleep(sleepTime);
        return String.format("%s-> %s", Thread.currentThread().getName(), value);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final int count = 20;
        final ArrayList<Future<String>> results = new ArrayList<>(count);
        final ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < count; i++) {
            Future<String> result = executorService.submit(new CallableTest());
            results.add(result);
        }

        executorService.shutdown();
//        for (Future<String> result : results) {
//            String s = result.get();
//            System.out.println(s);
//        }
        int done = 0;
        int index = 0;
        int lap = 1;
        while (done < count) {
            if (index == 0) {
                System.out.println("Lap " + lap++);
                TimeUnit.MILLISECONDS.sleep(10);
            }
            final Future<String> result = results.get(index);
            if (result != null && result.isDone()) {
                results.set(index, null);
                String s = result.get();
                System.out.println(s);
                done++;
            }
            index = ++index % count;
        }

    }
}
