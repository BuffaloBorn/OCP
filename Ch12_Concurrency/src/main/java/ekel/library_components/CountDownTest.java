package ekel.library_components;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by vitaly on 25.11.15.
 */
public class CountDownTest {
    public static void main(String[] args) throws InterruptedException {
        final int count = 10;
        CountDownLatch latch = new CountDownLatch(count);
        ExecutorService exec = Executors.newFixedThreadPool(5);

        for (int i = 0; i < count; i++) {
            exec.execute(new TaskPortion(latch));
        }

        exec.shutdown();

        System.out.println("Waiting for tasks...");
        latch.await();
        System.out.println("All tasks complete.");
    }

}

/**
 * Created by vitaly on 25.11.15.
 */

class TaskPortion implements Runnable {
    private static int counter = 0;
    private static final Random RANDOM = new Random(47);
    private final CountDownLatch latch;
    private final int id = counter++;

    public TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(RANDOM.nextInt(2000));
            System.out.println(this + " completed.");
        } catch (InterruptedException e) {
            System.out.println(this + " Interrupted.");
        }finally {
            latch.countDown();
        }
    }

    @Override
    public String toString() {
        return String.format("%1$-3d", id);
    }
}