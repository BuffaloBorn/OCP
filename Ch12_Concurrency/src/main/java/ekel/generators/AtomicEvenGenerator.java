package ekel.generators;

import ekel.utils.IntGenerator;

import java.util.concurrent.atomic.AtomicInteger;

public  class AtomicEvenGenerator extends IntGenerator {
    private final AtomicInteger value;

    public AtomicEvenGenerator() {
        this(0);
    }

    public AtomicEvenGenerator(int value) {

        this.value = new AtomicInteger(value);
    }

    @Override
    public int next() {
        return value.addAndGet(2);
    }
}
