package streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Vitaly on 05.07.2016.
 */
public class StreamTest {
    public static void main(String[] args) {
        Stream<String> empty = Stream.empty();
        Stream<Integer> singleElement = Stream.of(1);
        Stream<Integer> fromArray = Stream.of(1, 2, 3);
        Stream<String> fromList = Arrays.asList("A", "B", "C").parallelStream();
        Stream<Double> randomsInfinity = Stream.generate(Math::random);
        Stream<Integer> oddNumbersInfinity = Stream.iterate(1, i -> i + 2);

        //reduce()
        oddNumbersInfinity
                .limit(5)
                .peek(System.out::print)
                .reduce(Math::subtractExact).ifPresent(System.out::println);

        //collect()
        System.out.println(randomsInfinity
                .limit(10)
                .map(Objects::toString)
                .collect(Collectors.joining("|")));

        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("Bonobo");
        List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");

        List<String> list = Stream.of(zero, one, two).flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(list);
//        s = list.stream().flatMap(s -> IntStream.of(s.toCharArray()));

        IntSummaryStatistics statistics = Arrays.asList("Mama Gorilla", "Baby Gorilla", "Panda", "Lion").stream().collect(Collectors.summarizingInt(String::length));
        System.out.println(statistics);

        String s = "Partitioning is a special case of grouping. With partitioning, there are only two possible groups—true and false. Partitioning is like splitting a list into two parts. Suppose that we are making a sign to put outside each animal’s exhibit. We have two sizes of signs. One can accommodate names with five or fewer characters. The other is needed for longer names. We can partition the list according to which sign we need: ";
        Map<Character, List<String>> map = Arrays.stream(s.split("\\W+")).collect(Collectors.groupingBy(word -> Character.toUpperCase(word.charAt(0)), Collectors.toList()));
        System.out.println(map);

        IntStream.iterate(1, operand -> {
            System.out.print("in = " + operand + " out = " + ++operand); return operand;}).limit(5).forEach(value -> System.out.println("value = " + value));
    }
}

