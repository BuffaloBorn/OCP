import java.util.concurrent.TimeUnit;

/**
 * Created by vitaly on 02.11.15.
 */
public class SimpleThreads {
    public static Runnable getWorker() {

        return () -> {String[] strings = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };
            for (String s : strings) {
                try {
                    if (Thread.interrupted()) {
                        throw new InterruptedException();
                    }

                    printThreadMessage(s);
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    printThreadMessage("I wasn't done, INTERRUPTED!!!");
                    return;
                }
            }
            printThreadMessage("I am done.");
        };
    }

    public static void printThreadMessage(String message) {
        System.out.printf("%s: %s%n", Thread.currentThread().getName(), message);
    }
    public static void main(String[] args) throws InterruptedException {
        int patient = args.length > 0 ? Integer.parseInt(args[0]) : 5;
        Thread t = new Thread(getWorker());
        printThreadMessage("Starting new thread");
        t.start();
        t.join(patient);
        if (t.isAlive()) {
            printThreadMessage("Tired of waiting!!!");
            t.interrupt();
        }
        printThreadMessage("Finally!");
    }
}
