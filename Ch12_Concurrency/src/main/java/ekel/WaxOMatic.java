package ekel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by vitaly on 24.11.15.
 */
public class WaxOMatic {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        ExecutorService exec = Executors.newFixedThreadPool(2);
        exec.execute(new WaxOn(car));
        exec.execute(new WaxOff(car));

        TimeUnit.SECONDS.sleep(2);
        exec.shutdownNow();
    }
}

class Car {
    protected boolean waxed;

    public synchronized void waxed() {
        waxed = true;
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        while (!waxed) {
            wait();
        }
    }

    public synchronized void buffed() {
        waxed = false;
        notifyAll();
    }

    public synchronized void waitForBuffing() throws InterruptedException {
        while (waxed) {
            wait();
        }
    }
}

abstract class WaxOMaticTask implements Runnable {
    protected final Car car;

    WaxOMaticTask(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                doWork();
            }
        } catch (Exception e) {
            System.out.printf("%s(%s) is interrupted.", Thread.currentThread().getName(), getClass().getSimpleName());
        } finally {
            System.out.printf("%s(%s) finalized.", Thread.currentThread().getName(), getClass().getSimpleName());
        }
    }

    public abstract void doWork() throws InterruptedException;
}

class WaxOn extends WaxOMaticTask {

    WaxOn(Car car) {
        super(car);
    }

    @Override
    public void doWork() throws InterruptedException {
        car.waitForBuffing();
        System.out.print("Wax on!");
        TimeUnit.MILLISECONDS.sleep(200);
        car.waxed();
    }
}

class WaxOff extends WaxOMaticTask {

    WaxOff(Car car) {
        super(car);
    }

    @Override
    public void doWork() throws InterruptedException {
        car.waitForWaxing();
        System.out.print("Wax off!");
        TimeUnit.MILLISECONDS.sleep(200);
        car.buffed();
    }
}
