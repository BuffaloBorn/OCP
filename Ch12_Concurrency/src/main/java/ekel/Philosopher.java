package ekel;

import ekel.utils.AbstractWorker;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by vitaly on 25.11.15.
 */
public class Philosopher extends AbstractWorker{
    private static final int EAT_TIMEOUT = 1000;
    private static final long THINK_TIMEOUT = 33;
    private static AtomicInteger counter = new AtomicInteger(0);
    private final int id = counter.getAndIncrement();
    private Chopstick chopstick1;
    private Chopstick chopstick2;

    public Philosopher() {
        this(null, null);
    }

    public Philosopher(Chopstick chopstick1, Chopstick chopstick2) {
        this.chopstick1 = chopstick1;
        this.chopstick2 = chopstick2;
    }

    @Override
    public void doWork() throws InterruptedException {
        think();
        takeCutlery();
        eat();
        putCutlery();
    }

    public void putCutlery() {
        System.out.printf("%s finish eating%n", this);
        getChopstick1().put();
        System.out.printf("%s put first spoon %s%n", this, chopstick1);
        getChopstick2().put();
        System.out.printf("%s put second spoon %s%n", this, chopstick1);

    }

    protected void takeCutlery() throws InterruptedException {
        System.out.printf("%s want to eat%n", this);
        getChopstick1().take();
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.printf("%s take first spoon %s%n", this, chopstick1);
        getChopstick2().take();
        System.out.printf("%s take second spoon %s%n", this, chopstick1);
    }

    protected void eat() throws InterruptedException {
        System.out.printf("%s eating...%n", this);
        TimeUnit.MILLISECONDS.sleep(EAT_TIMEOUT);
    }

    protected void think() throws InterruptedException {
        System.out.printf("%s thinking...%n", this);
        TimeUnit.MILLISECONDS.sleep(THINK_TIMEOUT);
    }

    public Chopstick getChopstick1() {
        return chopstick1;
    }

    public void setChopstick1(Chopstick chopstick1) {
        this.chopstick1 = chopstick1;
    }

    public Chopstick getChopstick2() {
        return chopstick2;
    }

    public void setChopstick2(Chopstick chopstick2) {
        this.chopstick2 = chopstick2;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Philosopher{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
