package OCP.parallel;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Vitaly on 31.07.2016.
 */
public class ParallelStreamTest {
    private static int doSomething(int i) {
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
        }

        return ++i;
    }

    public static void test(Stream<Integer> stream) {
        long start = System.currentTimeMillis();
        stream.forEach(ParallelStreamTest::doSomething);
        System.out.println("Tasks completed in: " + (System.currentTimeMillis() - start) / 1000.0 + " seconds.");
    }

    public static void main(String[] args) {
        test(IntStream.range(0, 1000).boxed());
        test(IntStream.range(0, 1000).boxed().parallel());
    }
}
