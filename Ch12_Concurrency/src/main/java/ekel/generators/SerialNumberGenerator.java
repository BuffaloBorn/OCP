package ekel.generators;

import ekel.utils.IntGenerator;

/**
 * Created by vitaly on 10.11.15.
 */
public class SerialNumberGenerator extends IntGenerator {
    private int sequence;

    public SerialNumberGenerator() {
        this(0);
    }

    public SerialNumberGenerator(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public synchronized int next() {
        return sequence++;
    }
}
