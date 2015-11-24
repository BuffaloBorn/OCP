package ekel;

import ekel.utils.AbstractWorker;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by vitaly on 24.11.15.
 */
public class ToastQueue {
    public static void main(String[] args) throws InterruptedException {
        Random r = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();
        BlockingQueue<Toast> dryQueue = new ArrayBlockingQueue<Toast>(15);
        BlockingQueue<Toast> butterQueue = new ArrayBlockingQueue<Toast>(15);
        BlockingQueue<Toast> jamQueue = new ArrayBlockingQueue<Toast>(15);

        for (int i = 0; i < r.nextInt(10); i++) {
            exec.execute(new Toaster(dryQueue));
        }

        for (int i = 0; i < r.nextInt(10); i++) {
            exec.execute(new Jammer(jamQueue, butterQueue));
        }

        for (int i = 0; i < r.nextInt(10); i++) {
            exec.execute(new Butter(dryQueue, butterQueue));
        }

        for (int i = 0; i < r.nextInt(10); i++) {
            exec.execute(new Eater(jamQueue));
        }

        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();
    }
}

class Toast {
    public enum Status{DRY, BUTTERED, JAMMED,}
    private static final AtomicInteger counter = new AtomicInteger(0);

    private final int id;
    private Status status;

    Toast() {
        this.id = counter.getAndIncrement();
        this.status = Status.DRY;
    }

    public int getId() {
        return id;
    }

    public void butter() {
        status = Status.BUTTERED;
    }
    public void jam() {
        status = Status.JAMMED;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Toast{");
        sb.append("id=").append(id);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}

class Toaster extends AbstractWorker {
    private int capacity;
    private final BlockingQueue<Toast> dryQueue;

    @Override
    public void doWork() throws InterruptedException {
        final Toast toast = new Toast();
        System.out.println(Thread.currentThread() + " Creating new Toast: " + toast);
        dryQueue.put(toast);

        if (capacity-- == 0) {
            throw new InterruptedException("Done.");
        }
    }

    public Toaster(BlockingQueue<Toast> dryQueue) {
        this(dryQueue, 15);
    }

    Toaster(BlockingQueue<Toast> dryQueue, int capacity) {
        this.dryQueue = dryQueue;
        this.capacity = capacity;
    }
}

class Eater extends AbstractWorker {
    private final BlockingQueue<Toast> jamQueue;

    @Override
    public void doWork() throws InterruptedException {
        Toast toast = jamQueue.take();
        System.out.println(Thread.currentThread() + " Eating Toast: " + toast);
        jamQueue.put(toast);
    }

    Eater(BlockingQueue<Toast> jamQueue) {
        this.jamQueue = jamQueue;
    }
}

class Butter extends AbstractWorker {
    private final BlockingQueue<Toast> dryQueue;
    private final BlockingQueue<Toast> butterQueue;

    @Override
    public void doWork() throws InterruptedException {
        Toast toast = dryQueue.take();
        System.out.println(Thread.currentThread() + " Buttering Toast: " + toast);
        butterQueue.put(new Toast());
    }

    Butter(BlockingQueue<Toast> dryQueue, BlockingQueue<Toast> butterQueue) {
        this.dryQueue = dryQueue;
        this.butterQueue = butterQueue;
    }
}
class Jammer extends AbstractWorker {
    private final BlockingQueue<Toast> jamQueue;
    private final BlockingQueue<Toast> butterQueue;

    @Override
    public void doWork() throws InterruptedException {
        Toast toast = butterQueue.take();
        System.out.println(Thread.currentThread() + " Jamming Toast: " + toast);
        jamQueue.put(new Toast());
    }

    Jammer(BlockingQueue<Toast> jamQueue, BlockingQueue<Toast> butterQueue) {
        this.jamQueue = jamQueue;
        this.butterQueue = butterQueue;
    }
}
