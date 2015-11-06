package ekel;

import ekel.utils.UniversalThreadFactory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by vitaly on 06.11.15.
 */
public class RunnableTest implements Runnable{
    private final String message;

    public RunnableTest(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3000; i++) {
            System.out.println(message);
            Thread.yield();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadFactory tf = new UniversalThreadFactory();
        for (int i = 0; i < 5; i++) {
            Thread t = tf.newThread(new RunnableTest(String.format("Thread - %d print new message", i)));
            t.start();
        }

        TimeUnit.SECONDS.sleep(3);
        System.out.println("Main thread done.");
    }
}
