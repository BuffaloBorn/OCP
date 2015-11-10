package ekel.generators;

import ekel.utils.IntGenerator;

import java.util.concurrent.locks.ReentrantLock;

public  class MutexEvenGenerator extends IntGenerator {
    private int value;
    private ReentrantLock lock = new ReentrantLock();

    public MutexEvenGenerator() {
        this(0);
    }

    public MutexEvenGenerator(int value) {

        this.value = value;
    }

    @Override
    public int next() {
        lock.lock();
        try {
            value++;
            Thread.yield();
            value++;
            return value;
        } finally {
            lock.unlock();
        }
    }
}
