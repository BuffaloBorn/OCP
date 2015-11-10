package ekel;

import org.omg.CORBA.*;

import java.lang.Object;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by vitaly on 10.11.15.
 */
public class AttemptLock {
    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock() " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public void timed(long time, TimeUnit timeUnit) {
        boolean captured = false;
        try {
            captured = lock.tryLock(time, timeUnit);
            System.out.printf("tryLock(%d, %s) %b%n", time, timeUnit.name(), captured);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public void timed() {
        timed(2, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException {
        AttemptLock al = new AttemptLock();
        al.untimed();
        al.timed();

        Thread daemon = al.deamonLock();
        daemon.join(0, 1);

        al.untimed();
        al.timed();
    }

    private Thread deamonLock() {
        Thread thread = new Thread() {
            {
                setDaemon(true);
            }

            @Override
            public void run() {
                lock.lock();
                while (true){yield();}
            }
        };

        thread.start();
        return thread;
    }
}
