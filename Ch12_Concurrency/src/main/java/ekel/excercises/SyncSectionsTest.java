package ekel.excercises;

import ekel.utils.IntGenerator;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by vitaly on 10.11.15.
 */
class SyncSectionEvenGenerator {
    public int value = 0;
    private ThreadLocal<Object> lock = ThreadLocal.withInitial(Object::new);

    public synchronized void comeIn() {
//        System.out.println(Thread.currentThread().getName() + "SyncSectionEvenGenerator.comeIn");
        if (value++ > 0)
            System.out.println(Thread.currentThread().getName() + "I'm not alone! " + value);
    }

    public void next() {

        synchronized (lock.get()) {
//            System.out.println(Thread.currentThread().getName() + "SyncSectionEvenGenerator.next");
            comeIn();
            try {
//                System.out.println("sleep");
                TimeUnit.MILLISECONDS.sleep((long) (Math.random()*10));
            } catch (InterruptedException e) { }
            comeOut();
        }
    }

    public synchronized void comeOut() {
        value--;
    }
}

class Worker implements Runnable {
    private final SyncSectionEvenGenerator generator;
    private int i;

    Worker(SyncSectionEvenGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void run() {
        while (true) {
            generator.next();
//            System.out.println(Thread.currentThread().getName() + ": " + i++);
            Thread.yield();
        }
    }
}

public class SyncSectionsTest {
    public static void main(String[] args) throws InterruptedException {
        SyncSectionEvenGenerator generator = new SyncSectionEvenGenerator();
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            exec.execute(new Worker(generator));
        }

        TimeUnit.SECONDS.sleep(2);
        exec.shutdownNow();
    }
}
