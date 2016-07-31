package OCP;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
//        consumerProducer();
//        concurentException();
        BlockingQueue<Integer> q = new LinkedBlockingQueue<>(1);

        System.out.println(q.offer(2));
        q.put(1);
        System.out.println(q.take());
        System.out.println(q.take());
        System.out.println("end.");
    }

    public static void concurentException() {
        List<Integer> ints = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        for (Iterator<Integer> iterator = ints.iterator(); iterator.hasNext(); ) {
            Integer next = iterator.next();
            ints.remove(next);
        }
    }

    public static void consumerProducer() {
        IntWrapper i = new IntWrapper(1);
        IntConsumer c = value -> {
            i.setValue(i.getValue() + 1);
            ;
        };
        System.out.println(i);
        c.accept(0);
        System.out.println(i);
    }
}

class IntWrapper extends Number {
    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public IntWrapper(int value) {
        this.value = value;
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return value;
    }

    @Override
    public float floatValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}