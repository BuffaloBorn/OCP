package ekel.utils;

import java.util.concurrent.TimeUnit;

/**
 * Created by vitaly on 06.11.15.
 */
public class LiftOff implements Runnable {
    private static int counter = 0;
    private int countDown;
    private long id;

    public LiftOff() {
        this(10);
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
//        id = counter++;
    }

    @Override
    public void run() {
        id = Thread.currentThread().getId();
        do {
            System.out.printf("#%d(%d), ", id, countDown);
//            Thread.yield();
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.printf("#%d(INTERRUPTED!), ", id);
                return;
            }
        } while (countDown-- > 0);

        System.out.printf("#%d(Liftoff!), ", id);
    }
}
