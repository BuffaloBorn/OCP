package ekel.excercises;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by vitaly on 12.11.15.
 */
class Dummy {
    public void doSomething() throws InterruptedException {
        System.out.println("Trying to sleep...");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("I have enough sleep!");
    }
}
class Task implements Runnable {
    private final Dummy dummy = new Dummy();
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                dummy.doSomething();
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted in blocked metod.");
        } finally {
            System.out.println("Finalizing task");
        }
    }
}

public class InterruptedTask {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        System.out.println("Starting new task");
        exec.execute(new Task());
        TimeUnit.SECONDS.sleep(1);
        exec.shutdownNow();
    }
}
