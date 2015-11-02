import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by vitaly on 02.11.15.
 */
public class ProducerConsumerTest {

    public static void main(String[] args) {
        Random rnd = new Random();
        Data dataObject = new Data();

        final int producerCount = rnd.nextInt(10);
        System.out.printf("Creating %d producers", producerCount);
        for (int i = 0; i < producerCount; i++) {
            new Thread(new Producer(dataObject)).start();
        }

        final int consumerCount = rnd.nextInt(10);
        System.out.printf("Creating %d consumers", consumerCount);
        for (int i = 0; i < producerCount; i++) {
            new Thread(new Consumer(dataObject)).start();
        }
    }
}

abstract class Worker implements Runnable {
    protected static final Random rnd = new Random();
    protected final Data data;
    protected final long delay;

    public Worker(Data data, long delay) {
        this.data = data;
        this.delay = delay;
    }

    protected void getRest() {
        try {
            TimeUnit.MILLISECONDS.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract void doJob();

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            doJob();
            getRest();
        }
    }
}

class Producer extends Worker {
    private final String[] messages = {
            "REGISTERED",
            "addressType",
            "municipalityCode",
            "emails",
            "Orlov",
            "phones",
            "MOBILE",
    };

    public Producer(Data data) {
        super(data, rnd.nextInt(1000));
    }

    @Override
    public void doJob() {
        data.setMessage(messages[rnd.nextInt(messages.length)]);
    }
}

class Consumer extends Worker {

    public Consumer(Data data) {
        super(data, rnd.nextInt(1000));
    }

    @Override
    public void doJob() {
        data.getMessage();
    }
}

class Data {
    private String message;
    private boolean empty = true;

    public synchronized String getMessage() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        empty = true;
        System.out.printf("Thread %s consume message '%s'.%n", Thread.currentThread().getName(), message);
        notifyAll();

        return message;
    }

    public synchronized void setMessage(String message) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.message = message;
        empty = false;
        System.out.printf("Thread %s produce message '%s'.%n", Thread.currentThread().getName(), message);
        notifyAll();
    }
}