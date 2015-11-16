package ekel.excercises;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by vitaly on 16.11.15.
 */
public class BlockedMutex {
    private ReentrantLock lock = new ReentrantLock();
    public void foo() {
        interruptedLock();
//        lock();
    }

    public void interruptedLock() {
        try {
            lock.lockInterruptibly();
            System.out.println("Lock aquired in foo()");
        } catch (InterruptedException e) {
            System.out.println("Lock interrupted.");
        }
    }
    public void lock() {
            lock.lock();
            System.out.println("Lock aquired in foo()");
    }

    public static void main(String[] args) throws InterruptedException {
        BlockedMutex mutex = new BlockedMutex();
        mutex.lock();
        Thread t = new Thread(new Blocked2(mutex));
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Issue t.interrupt()");
        t.interrupt();
    }
}

class Blocked2 implements Runnable{
    final BlockedMutex mutex;

    Blocked2(BlockedMutex mutex) {
        this.mutex = mutex;
    }

    @Override
    public void run() {
        System.out.println("Waiting for foo() in BlockedMutex.");
        mutex.foo();
        System.out.println("Broken out of call");
    }
}

