package ekel.generators;

import ekel.utils.IntGenerator;

public  class EvenGenerator extends IntGenerator {
    private int value;

    public EvenGenerator() {
        this(0);
    }

    public EvenGenerator(int value) {

        this.value = value;
    }

    @Override
    public int next() {
        value++;
        Thread.yield();
        value++;

        return value;
    }
}
