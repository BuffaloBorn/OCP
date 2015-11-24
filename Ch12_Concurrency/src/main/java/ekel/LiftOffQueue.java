package ekel;

import ekel.utils.LiftOff;
import sun.security.krb5.internal.TGSRep;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by vitaly on 24.11.15.
 */
public class LiftOffQueue {
    public static void main(String[] args) {
        BlockingQueue<LiftOff> queue = new ArrayBlockingQueue<>(1);
        queue.add(new LiftOff(15));
        ExecutorService exec = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            exec.execute(new LiftOffRunner(queue));
        }

        exec.shutdown();
    }
}

class LiftOffRunner implements Runnable {
    private final BlockingQueue<LiftOff> queue;

    LiftOffRunner(BlockingQueue<LiftOff> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff lo = queue.take();

                int countDown = lo.getCountDown();

                if (countDown == 0) {
                    queue.put(lo);
                    return;
                }

                System.out.println(Thread.currentThread().getName() + ": " + countDown--);
                lo.setCountDown(countDown);
                queue.put(lo);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + ": " + "Interrupted.");
        } finally {
            System.out.println(Thread.currentThread().getName() + ": " + "End.");
        }
    }
}