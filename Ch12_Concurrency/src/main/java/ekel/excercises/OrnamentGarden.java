package ekel.excercises;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by vitaly on 13.11.15.
 */
public class OrnamentGarden {
    private final Counter counter = new Counter();
    private final CopyOnWriteArraySet<Wicket> wickets = new CopyOnWriteArraySet<>();

    public void addWicket(Wicket wicket) {
        wickets.add(wicket);
    }

//    public synchronized int enter() {
    public int enter() {
        return counter.inc();
    }

    public static void main(String[] args) throws InterruptedException {
        OrnamentGarden ornamentGarden = new OrnamentGarden();
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            exec.execute(new Wicket(ornamentGarden));
        }
        exec.shutdown();
        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();

        System.out.printf("Count by wickets = %d%n", ornamentGarden.getSummByWickets());
        System.out.printf("Total count = %d%n", ornamentGarden.counter.getCount());
//        System.exit(0);
    }

    public int getSummByWickets() {
        int sum = 0;
        for (Wicket wicket : wickets) {
            sum += wicket.getCount();
        }

        return sum;
    }
}

class Wicket implements Runnable {
    private static AtomicInteger idCounter = new AtomicInteger(0);
    private final int id;
    private final Counter counter = new Counter();
    private final OrnamentGarden ornamentGarden;
    private final Random rnd = new Random();

    Wicket(OrnamentGarden ornamentGarden) {
        id = idCounter.getAndIncrement();
        this.ornamentGarden = ornamentGarden;
        ornamentGarden.addWicket(this);
    }

    private int enter() {
        int localCount = counter.inc();
        int total = ornamentGarden.enter();
        System.out.printf("Wicket: %d entrance: %d TOTAL: %d%n", id, localCount, total);
        return localCount;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                enter();
                Thread.yield();
//                Thread.currentThread().interrupt();
                TimeUnit.MILLISECONDS.sleep(rnd.nextInt(1000));
            }
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted.");
        }finally {
            System.out.println(this + " closed.");
        }

    }

    public int getCount() {
        return counter.getCount();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Wicket{");
        sb.append("id=").append(id);
        sb.append(", counter=").append(counter);
        sb.append('}');
        return sb.toString();
    }
}