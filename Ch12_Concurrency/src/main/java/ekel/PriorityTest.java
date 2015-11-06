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
public class PriorityTest {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 7; i++) {
            Thread thread = new Thread(new LiftOff(10));
            thread.setPriority(Thread.MIN_PRIORITY);
            thread.start();
        }

        Thread thread = new Thread(new LiftOff(10));
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();

    }

}
