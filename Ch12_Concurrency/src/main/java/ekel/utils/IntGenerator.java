package ekel.utils;

import sun.nio.cs.Surrogate;

/**
 * Created by Vitaly on 08.11.2015.
 */
public abstract class IntGenerator {
    private boolean canceled;

    public boolean isCanceled() {
        return canceled;
    }

    public void cancel() {
        this.canceled = true;
    }

    public abstract int next();
}
