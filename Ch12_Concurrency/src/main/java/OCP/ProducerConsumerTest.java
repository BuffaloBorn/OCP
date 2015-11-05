package OCP;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by vitaly on 02.11.15.
 */
public class ProducerConsumerTest {

    public static void main(String[] args) {
        Random rnd = new Random();
        BlockingQueue<String> dataObject = new ArrayBlockingQueue<>(1, true);

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
    protected final BlockingQueue<String> data;
    protected final long delay;

    public Worker(BlockingQueue<String> data, long delay) {
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

    public abstract void doJob() throws InterruptedException;

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                doJob();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
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
            "DONE",
    };

    public Producer(BlockingQueue<String> data) {
        super(data, rnd.nextInt(1000));
    }

    @Override
    public void doJob() throws InterruptedException {
        final String value = messages[rnd.nextInt(messages.length)];
        data.put(value);
        System.out.printf("Thread %s put value '%s' into queue%n", Thread.currentThread().getName(), value);
    }
}

class Consumer extends Worker {

    public Consumer(BlockingQueue<String> data) {
        super(data, rnd.nextInt(1000));
    }

    @Override
    public void doJob() throws InterruptedException {
        String value = data.take();
        System.out.printf("Thread %s take value '%s' from queue%n", Thread.currentThread().getName(), value);
        if (value.equals("DONE")) {
            throw new InterruptedException("I'm Done!");
        }
    }
}
