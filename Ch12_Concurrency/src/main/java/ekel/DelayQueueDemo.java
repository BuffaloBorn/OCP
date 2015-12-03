package ekel;

import ekel.utils.AbstractWorker;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.concurrent.TimeUnit.*;

/**
 * Created by vitaly on 26.11.15.
 */
public class DelayQueueDemo {
    public static void main(String[] args) {
        final int bound = 1000;
        Random r = new Random();
        ExecutorService exec = Executors.newCachedThreadPool();
        BlockingQueue<DelayTask> tasksQueue = new DelayQueue<>();

        for (int i = 0; i < 15; i++) {
            tasksQueue.offer(new DelayTask(r.nextInt(3000)));
        }

        tasksQueue.offer(new DelayTask.EndSentinel(bound, exec));
        exec.execute(new DelayedTaskConsumer(tasksQueue));
    }
}

class DelayTask implements Runnable, Delayed {
    private static List<DelayTask> tasks = new CopyOnWriteArrayList<>();
    private static AtomicInteger counter = new AtomicInteger(0);
    private static final Comparator<DelayTask> NATURAL_COMPARATOR = Comparator.comparing(delayTask -> delayTask.trigger);

    private final int id;
    private final long delay;
    private final long trigger;

    public static class EndSentinel extends DelayTask {
        private final ExecutorService exec;

        public EndSentinel(long dalayInMilliseconds, ExecutorService exec) {
            super(dalayInMilliseconds);
            this.exec = exec;
        }

        @Override
        public void run() {
            exec.shutdownNow();

            for (DelayTask delayTask :tasks) {
                System.out.print(delayTask.summary());
            }

            System.out.println();
            System.out.println(this + " Colling shutdown()");
        }
    }

    public DelayTask(long dalayInMilliseconds) {
        this.id = counter.getAndIncrement();
        this.delay = dalayInMilliseconds;
        this.trigger = System.nanoTime() + NANOSECONDS.convert(dalayInMilliseconds, MILLISECONDS);
        tasks.add(this);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(), NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        DelayTask that = (DelayTask) o;
        return NATURAL_COMPARATOR.compare(this, that);
    }

    @Override
    public void run() {
        System.out.println(this + " ");
    }

    @Override
    public String toString() {
        return String.format("[%1$02d:%2$-4d]", id, delay);
    }

    public int getId() {
        return id;
    }

    public String summary() {
        return String.format("(%1$d:%2$010d)", id, delay);
    }
}

class DelayedTaskConsumer extends AbstractWorker {
    private final BlockingQueue<DelayTask> tasks;

    public DelayedTaskConsumer(BlockingQueue<DelayTask> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void doWork() throws InterruptedException {
        tasks.take().run();
    }

    @Override
    protected void finalizing() {
        System.out.println("Finishing DelayedTaskConsumer.");
    }
}