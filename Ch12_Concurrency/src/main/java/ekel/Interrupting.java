package ekel;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by vitaly on 11.11.15.
 */
class SleepBlocked implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Interupted sleep");
                break;
            }
        }

        System.out.println("exitiong SleepBlok.run()");
    }
}

class IOBlocked implements Runnable {
    private final InputStream in;

    public IOBlocked() {
        this(System.in);
    }

    IOBlocked(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        while (true) {
            try {
                in.read();
            } catch (Exception e) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Interrupted from I/O");
                } else {
                    System.out.println(e);
                }
                break;
            }
        }
        System.out.println("Exiting IOBlocked.run()");
    }
}

class SynchronazeBlocked implements Runnable {
    public SynchronazeBlocked() {
        new Thread(this){
            @Override
            public void run() {
                foo();
            }

            {setDaemon(true);}}.start();
    }

    @Override
    public void run() {
        System.out.println("Trying to call foo()");
        foo();
        System.out.println("Exiting SynchronazeBlocked.run()");;
    }

    private synchronized void foo() {
        while (true) {
            Thread.yield();
        }
    }
}

public class Interrupting {
    static ExecutorService exec = Executors.newCachedThreadPool();
    static void test(Runnable runnable) throws InterruptedException {
        System.out.println("=============================================");
        Future<?> f = exec.submit(runnable);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting " + runnable.getClass().getSimpleName());
        f.cancel(true);
        System.out.println("Interrupt send to " + runnable.getClass().getSimpleName());

    }
    public static void main(String[] args) throws InterruptedException {
        test(new SleepBlocked());
        test(new IOBlocked());
        test(new SynchronazeBlocked());
        System.exit(0);
    }
}
