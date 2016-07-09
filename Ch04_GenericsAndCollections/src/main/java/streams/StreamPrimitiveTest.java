package streams;

import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

/**
 * Created by Vitaly on 05.07.2016.
 */
public class StreamPrimitiveTest {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10).max().ifPresent(System.out::println);
        IntStream.range(1, 10).average().ifPresent(System.out::println);
        IntStream.rangeClosed(2, 5).mapToObj(Integer::valueOf).count();
        IntStream stream = new Random().ints().limit(50);
        stream = IntStream.empty();

        IntSummaryStatistics statistics = stream.summaryStatistics();
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMax());



    }
}
