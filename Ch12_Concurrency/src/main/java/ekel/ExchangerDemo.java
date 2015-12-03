package ekel;

import ekel.utils.AbstractWorker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * Created by vitaly on 26.11.15.
 */
public class ExchangerDemo {
    public static void main(String[] args) throws InterruptedException {
        int size = 10;
        int delay = 5;
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Fat>> exchanger = new Exchanger<>();
        exec.execute(new ExchangerConsumer<>(exchanger));
        exec.execute(new ExchangerProducer<>(exchanger, Fat::new, size));
        TimeUnit.SECONDS.sleep(delay);
        exec.shutdownNow();
    }
}

class ExchangerProducer<T> extends AbstractWorker {
    private final Exchanger<List<T>> exchanger;
    private final Supplier<T> generator;
    private final int portionSize;
    private List<T> holder;

    ExchangerProducer(Exchanger<List<T>> exchanger, Supplier<T> generator, int portionSize) {
        this.exchanger = exchanger;
        this.generator = generator;
        this.portionSize = portionSize;
//        holder = new CopyOnWriteArrayList<>();
        holder = new ArrayList<>();
    }

    @Override
    public void doWork() throws InterruptedException {
        for (int i = 0; i < portionSize; i++) {
            holder.add(generator.get());
        }

        this.holder = exchanger.exchange(holder);
        this.holder.clear();
    }
}

class ExchangerConsumer<T> extends AbstractWorker {
    private final Exchanger<List<T>> exchanger;
    private volatile T value;
    private List<T> holder;
    private int part = 0;

    ExchangerConsumer(Exchanger<List<T>> exchanger) {
        this.exchanger = exchanger;
//        holder = new CopyOnWriteArrayList<>();
        holder = new ArrayList<>();
    }

    @Override
    public void doWork() throws InterruptedException {
        holder = exchanger.exchange(holder);
        for (T item :holder) {
            value = item;
            System.out.println(part + ":" + value);
//            holder.remove(value);
        }

        part++;
    }
}
