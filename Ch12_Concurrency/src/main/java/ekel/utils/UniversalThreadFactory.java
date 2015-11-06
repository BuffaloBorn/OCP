package ekel.utils;

import java.util.concurrent.ThreadFactory;
import java.util.function.Consumer;

/**
 * Created by vitaly on 06.11.15.
 */
public class UniversalThreadFactory implements ThreadFactory {
    private final Consumer<Thread>[] threadAdvicers;

    public UniversalThreadFactory() {
        this(null);
    }

    @SuppressWarnings("unchecked")
    public UniversalThreadFactory(Consumer<Thread>... threadAdvicers) {
        this.threadAdvicers = threadAdvicers;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        adviceThread(t);

        return t;
    }

    private void adviceThread(Thread t) {
        if (threadAdvicers != null) {
            for (Consumer<Thread> advisor : threadAdvicers) {
                advisor.accept(t);
            }
        }
    }

    public static void main(String[] args) {
        UniversalThreadFactory factory = new UniversalThreadFactory();
    }
}
