package ekel.generators;

import ekel.utils.IntGenerator;

public  class SynchronizedEvenGenerator extends IntGenerator {
    private int value;

    public SynchronizedEvenGenerator() {
        this(0);
    }

    public SynchronizedEvenGenerator(int value) {

        this.value = value;
    }

    @Override
    public synchronized int next() {
        value++;
        Thread.yield();
        value++;

        return value;
    }
}
