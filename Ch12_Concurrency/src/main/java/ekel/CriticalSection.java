package ekel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by vitaly on 10.11.15.
 */
class Pair {
    private int x, y;

    public Pair() {
        this(0, 0);
    }

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void checkState() {
        if (x != y) {
            throw new PairValueNotEqualsException();
        }
    }

    public class PairValueNotEqualsException extends RuntimeException {
        public PairValueNotEqualsException() {
            super("Pair values not equals: " + Pair.this);
        }
    }

    public void intcrementX() {
        x++;
    }

    public void intcrementY() {
        y++;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pair{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }
}

abstract class PairManeger {
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair p = new Pair();
    protected ReentrantLock lock = new ReentrantLock();
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());

    public synchronized Pair getPair() {
        return new Pair(p.getX(), p.getY());
    }

    public void store(Pair p) {
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException ignore) {
        }
    }

    public abstract void increment();
}

class PairManeger1 extends PairManeger {

    @Override
    public synchronized void increment() {
        p.intcrementX();
        p.intcrementY();
        store(getPair());
    }
}

class PairManeger2 extends PairManeger {

    @Override
    public synchronized void increment() {
        Pair temp;
        synchronized (this) {
            p.intcrementX();
            p.intcrementY();
            temp = getPair();
        }
        store(temp);
    }
}

class PairManeger3 extends PairManeger {

    @Override
    public synchronized void increment() {
        lock.lock();
        try {
            p.intcrementX();
            p.intcrementY();
            store(getPair());
        }finally {
            lock.unlock();
        }
    }
}
class PairManeger4 extends PairManeger {

    @Override
    public synchronized void increment() {
        Pair temp;
        lock.lock();
        try {
            p.intcrementX();
            p.intcrementY();
            temp = getPair();
        }finally {
            lock.unlock();
        }
        store(temp);
    }
}

class PairManipulator implements Runnable{
    final PairManeger pm;

    PairManipulator(PairManeger pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.increment();
            Thread.yield();
        }
    }

    @Override
    public String toString() {
        return "Pair: " + pm.getPair() + " checkCounter = " + pm.checkCounter.get();
    }
}

class PairChecker implements Runnable {
    private final PairManeger pm;

    PairChecker(PairManeger pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
//            Thread.yield();
        }
    }
}

public class CriticalSection {
    public static void main(String[] args) throws InterruptedException {
        PairManeger pairManeger1 = new PairManeger3();
        PairManeger pairManeger2 = new PairManeger4();
        testApproaches(pairManeger1, pairManeger2);
    }

    public static void testApproaches(PairManeger pairManeger1, PairManeger pairManeger2) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(4);
        PairManipulator pairManipulator1 = new PairManipulator(pairManeger1);
        PairManipulator pairManipulator2 = new PairManipulator(pairManeger2);
        PairChecker pairChecker1 = new PairChecker(pairManeger1);
        PairChecker pairChecker2 = new PairChecker(pairManeger2);

        exec.execute(pairManipulator1);
        exec.execute(pairManipulator2);
        exec.execute(pairChecker1);
        exec.execute(pairChecker2);

        TimeUnit.MILLISECONDS.sleep(500);

        exec.shutdownNow();

        System.out.println("pm1: " + pairManipulator1 + "\npm2: " + pairManipulator2);
        System.out.println(pairManipulator1.pm.getClass().getSimpleName());
        System.out.println(pairManipulator2.pm.getClass().getSimpleName());
        System.exit(0);
    }
}
