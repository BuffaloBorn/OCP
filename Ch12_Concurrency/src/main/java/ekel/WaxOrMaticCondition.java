package ekel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by vitaly on 24.11.15.
 */
public class WaxOrMaticCondition {
    public static void main(String[] args) throws InterruptedException {
        Car car = new ConditionCar();
        ExecutorService exec = Executors.newFixedThreadPool(2);
        exec.execute(new WaxOn(car));
        exec.execute(new WaxOff(car));

        TimeUnit.SECONDS.sleep(2);
        exec.shutdownNow();
    }
}

class ConditionCar extends Car {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    @Override
    public void waxed() {
        lock.lock();
        try {
            waxed = true;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public  void waitForWaxing() throws InterruptedException {
        lock.lock();
        try {
            while (!waxed) {
                condition.await();
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public  void buffed() {
        lock.lock();
        try {
            waxed = false;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public  void waitForBuffing() throws InterruptedException {
        lock.lock();
        try {
            while (waxed) {
                condition.await();
            }
        } finally {
            lock.unlock();
        }
    }
}