package streams.ch05;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by vitaly on 22.09.15.
 */
public class Exercises {
    public static <T, K> Collector<T, Map<K, List<T>>, Map<K, List<T>>> groupByCollector(Function<T, K> mapper) {
        class GroupingBy<T, K> implements Collector<T, Map<K, List<T>>, Map<K, List<T>>> {
            private final Function<T, K> mapper;

            public GroupingBy(Function<T, K> mapper) {
                Objects.requireNonNull(mapper);
                this.mapper = mapper;
            }

            @Override
            @SuppressWarnings("unchecked")
            public Supplier<Map<K, List<T>>> supplier() {
                return LinkedHashMap::new;
            }

            @Override
            public BiConsumer<Map<K, List<T>>, T> accumulator() {
                return (map, value) -> {
                    K key = mapper.apply(value);
                    List<T> keyList;
                    if (map.containsKey(key)) {
                        keyList = map.get(key);
                    } else {
                        keyList = new ArrayList<>();
                        map.put(key, keyList);
                    }
                    keyList.add(value);
                };
            }

            @Override
            public BinaryOperator<Map<K, List<T>>> combiner() {
                return (map1, map2) -> {
                    map1.putAll(map2);
                    return map1;
                };
            }

            @Override
            public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
                return Function.identity();
            }

            @Override
            public Set<Characteristics> characteristics() {
                return Collections.emptySet();
            }
        }

        return new GroupingBy<T, K>(mapper);
    }
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
        Map<Character, List<String>> map = Stream.of("faj;lsdf oaiew ldfjpwpqw ;weqpw gjlsf iriet  asdf [p ew eqwepw fs fpwj fpwj efpjslf jap wejfjf pasfwj fhshas fpas jfpjs fiug auiq".split(" +"))
                .collect(groupByCollector(s -> s.charAt(0)));
        System.out.println(map);
//        3
        Map<Integer, Integer> integerMap = new LinkedHashMap<>();
        for (int i = 1; i < 5; i++) {
            integerMap.computeIfAbsent(i, integer -> integerMap.computeIfAbsent((integer - 1), integer1 -> 0)+integer);
        }
        System.out.println(integerMap);
//        4
//        5
//        6
//        7
//        8
//        9
    }
}
