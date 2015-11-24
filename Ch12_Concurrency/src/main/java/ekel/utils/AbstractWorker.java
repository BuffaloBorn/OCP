package ekel.utils;

/**
 * Created by vitaly on 24.11.15.
 */
public abstract class AbstractWorker implements Runnable {

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                doWork();
            }
        } catch (InterruptedException e) {
            System.out.println(getClass().getSimpleName() + " interrupted.");
        }finally {
            System.out.println(getClass().getSimpleName() + " ended.");
        }

    }

    public abstract void doWork() throws InterruptedException;

}
