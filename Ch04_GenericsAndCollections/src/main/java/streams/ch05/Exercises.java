package streams.ch05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by vitaly on 22.09.15.
 */
public class Exercises {
    public static void main(String[] args) {
//        1
//        2
        List<String> names = Arrays.asList("John Lennon", "Paul McCartney", "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");
        String longest = names.stream().reduce((s, s2) -> s2.length() > s.length() ? s2 : s).get();
        System.out.println(longest);

        longest = names.stream().collect(Collectors.maxBy(Comparator.comparing(String::length))).get();
        System.out.println(longest);

        Stream<String> names2 = Stream.of("John", "Paul", "George", "John", "Paul", "John");
        System.out.println(names2.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
//todo реализовать коллектор
//        Collector<String, Map, Map> g = new Collector()
//        3
        for (int i = 0; i < 5; i++) {

        }
//        4
//        5
//        6
//        7
//        8
//        9
    }
}
