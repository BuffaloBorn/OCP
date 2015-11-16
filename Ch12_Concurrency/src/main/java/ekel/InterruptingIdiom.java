package ekel;

import java.util.concurrent.TimeUnit;

/**
 * Created by vitaly on 16.11.15.
 */
class NeedsCleanUp {
    private final int id;

    NeedsCleanUp(int id) {
        this.id = id;
        System.out.println("Needs to clean up " + id);
    }

    public void clean() {
        System.out.println("Cleaning up " + id);
    }
}

class Blocked3 implements Runnable {
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                NeedsCleanUp n1 = new NeedsCleanUp(1);
                try {
                    System.out.println("Sleeping...");
                    TimeUnit.MILLISECONDS.sleep(70);
                    NeedsCleanUp n2 = new NeedsCleanUp(2);
                    try {
                        System.out.println("Calculating...");
                        double d = 1;
                        for (long i = 1; i < 100_0000; i++) {
                            d /= i;
                        }
                        System.out.println("Finished calculating.");
                    } finally {
                        n2.clean();
                    }
                } finally {
                    n1.clean();
                }
            }
            System.out.println("Exiting via while() test.");
        } catch (InterruptedException e) {
            System.out.println("Interrupting thread: " + Thread.currentThread());
//        } finally {
//            System.out.println("Finalizing thread: " + Thread.currentThread());
        }
    }
}

public class InterruptingIdiom {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.SECONDS.sleep(2);
        t.interrupt();
    }
}
